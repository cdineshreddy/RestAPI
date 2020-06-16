package TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import TestBase.TestBase;
import Utilities.RestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PostEmployeeData extends TestBase{
	
		
	String empName=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	void createEmployee() throws InterruptedException{
		logger.info("Started the adding the new employee data");
		httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("title", empName); 
		requestParams.put("salary", empSalary);
		
		httpRequest.body(requestParams.toJSONString());
		httpRequest.contentType(ContentType.JSON);
		RequestSpecification sender = httpRequest.when();
		response = sender.post("http://localhost:3000/posts");
		
		Thread.sleep(3000);

	}
	
	@Test
	void checkResposeBody(){
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
	}
		
	@Test
	void checkStatusCode(){
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 201);
	}
		
		

	@AfterClass
	void tearDown(){
		logger.info("Sucessfully created the new employee data");
	}


}
