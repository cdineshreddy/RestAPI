package Parametrization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddComplexData 

{
	@Test
	public void CreateComplexData()
	{
		//Rest assured class and calling given method is returning RequestSpecification
		RequestSpecification req = RestAssured.given();
		
		//JSONObject is a java class, and data is written in java format
		JSONObject jobj = new JSONObject();
		jobj.put("Java", 90);
		jobj.put("SQL", 78);
		jobj.put("API", 86);
		
		JSONObject jobj2 = new JSONObject();
		jobj2.put("Name", "Sanjay");
		jobj2.put("RollNum", 12);
		jobj2.put("Subject", jobj);
		
		JSONObject jobj3 = new JSONObject();
		jobj3.put("Student", jobj2);
		
		//Converting Java format into JSON format 
		String json = jobj3.toJSONString();
		
		//data is written in the Body
		req.body(json);
		req.contentType(ContentType.JSON);
		
		//Now getting response from the body and posting into API
		RequestSpecification sender = req.when();
		Response res = sender.post("http://localhost:3000/posts");
		
		res.then().log().all();
		
	}
}
