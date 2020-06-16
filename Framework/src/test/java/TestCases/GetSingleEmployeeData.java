package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;
import TestBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetSingleEmployeeData extends TestBase{
	
	@BeforeClass
	void getEmployeeData() throws InterruptedException {
		
		logger.info("Getting the Single employee data");
		RestAssured.baseURI = "http://localhost:3000/posts/"+empID;
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET);
		Thread.sleep(7000);
	}
	
	@Test(priority=1)
	void checkResposeBody(){
		String responseBody = response.getBody().asString();
		logger.info("Respone Body ==>"+responseBody);
		Assert.assertEquals(responseBody.contains(empID), true);
	}
		
	@Test
	void checkStatusCode(){
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkResponseTime(){
		long responseTime = response.getTime(); // Getting status Line
		Assert.assertTrue(responseTime<6000);
		
	}
		
		
	@Test
	void checkContentLength(){
		String contentLength = response.header("Content-Length");
		Assert.assertTrue(Integer.parseInt(contentLength)<1500);
	}
	
	@AfterClass
	void tearDown(){
		logger.info("Finished the test case of getting the single employee data");
	}

}
