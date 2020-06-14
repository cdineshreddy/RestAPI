package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class FetchData {
	
	@Test
	public void getData() {
		
		//Response resp = RestAssured.get("http://localhost:3000/posts");
		
		RestAssured.baseURI="http://localhost:3000/posts";
		RequestSpecification httpRequest = RestAssured.given();
		Response resp = httpRequest.request(Method.GET);
		
		//To fetch status code for Request
		int statusCode=resp.getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		System.out.println("-------------------------------");
		
		//To fetch content type for Request
		String contentType = resp.getContentType();
		System.out.println("Content Type is: "+contentType);
		System.out.println("---------------------------------");
		
		//To fetch Actual content or Response Body
		//asString() method will convert JSON format to string
		String completeResp = resp.getBody().asString();
		System.out.println("Complete Response is: "+completeResp);
		Assert.assertEquals(completeResp.contains("Dinesh Reddy"),true);
		System.out.println("-------------------------------------------------");
		
		//To fetch all the headers values
		Headers all = resp.getHeaders();
		for(Header header:all) {
			System.out.println(header.getName()+"--->"+header.getValue());
		}
		
	}

}
