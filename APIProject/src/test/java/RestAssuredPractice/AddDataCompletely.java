package RestAssuredPractice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddDataCompletely {
	
	@Test
	public void putData() {
		
		//Set the Precondition
		RequestSpecification req = RestAssured.given();
		
		JSONObject jobj=new JSONObject();
		jobj.put("title", "QA");
		jobj.put("author", "dinesh");
		
		
		String jsonobj = jobj.toJSONString();
		req.body(jsonobj);
		req.contentType(ContentType.JSON);
		
		//Apply Precondition
		RequestSpecification sender = req.when();
		Response resp = sender.put("http://localhost:3000/posts/7");
		
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
