package RestAssuredPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class FetchData {
	
	@Test
	public void getData() {
		
		Response resp = RestAssured.get("http://localhost:3000/posts");
		
		//To fetch status code for Request
		int statusCode=resp.getStatusCode();
		System.out.println("Status Code is: "+statusCode);
		System.out.println("-------------------------------");
		
		//To fetch content type for Request
		String contentType = resp.getContentType();
		System.out.println("Content Type is: "+contentType);
		System.out.println("---------------------------------");
		
		//To fetch Actual content or Response Body
		String completeResp = resp.asString();
		System.out.println("Complete Response is: "+completeResp);
		Assert.assertEquals(completeResp.contains("Dinesh Reddy"),true);
		
		//To fetch all the headers values
		Headers all = resp.headers();
		for(Header header:all) {
			System.out.println(header.getName()+"--->"+header.getValue());
		}
		
	}

}
