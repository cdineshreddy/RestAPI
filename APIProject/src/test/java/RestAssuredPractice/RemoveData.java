package RestAssuredPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RemoveData {
	
	@Test
	public void deletaData() {
		
		Response resp = RestAssured.delete("http://localhost:3000/posts/20");
		
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
		
	}

}
