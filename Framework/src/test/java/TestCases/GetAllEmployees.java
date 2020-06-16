package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;
import TestBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetAllEmployees extends TestBase{
	
	@BeforeClass
	void getAllEmployees() throws InterruptedException{
		
		logger.info("Started fetching all the employee details");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET);
		Thread.sleep(3);
	}
	
	@Test(priority =1)
	void checkResponseBody() {
		
		logger.info("Checking the Response body of the employees details");
		String body = response.getBody().asString();
		logger.info("Response Body ==>"+body);
		Assert.assertTrue(body!=null);
	}
	
	@Test(priority =2)
	void checkStatusCode() {
	
		logger.info("Checking the Status code");
		int code = response.getStatusCode();
		logger.info("Status Code is ==>"+code);
		Assert.assertEquals(code, 200);
	}
	
	@Test(priority =3)
	void checkResponseTime() {
		
		logger.info("Checking the Response time");
		long time = response.getTime();
		logger.info("Response Time is ==>"+time);
		
		if(time>2000)
			logger.warn("Response Time is greater than 2000");
		Assert.assertTrue(time<2000);
	}
	
	@Test(priority =4)
	void checkContentLength(){
		
		logger.info("Checking the content length of the employee data");
		String contentLength = response.header("Content-Length");
		logger.info("Content Length is==>" +contentLength); 
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
	
	@AfterClass
	void tearDown() {
		logger.info("Finished the Test case for Fetching the Employee details");
	}
}
