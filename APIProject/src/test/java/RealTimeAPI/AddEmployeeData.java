package RealTimeAPI;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddEmployeeData {
	
	@Test
	public void addEmployeeData() {
		
		RequestSpecification req = RestAssured.given();
		
		JSONObject jobj=new JSONObject();
		jobj.put("id", 25);
		jobj.put("name","Dinesh");
		jobj.put("salary",12000);
		jobj.put("age",34);
		
		String jsonData = jobj.toJSONString();
		req.body(jsonData);
		req.contentType(ContentType.JSON);
		
		RequestSpecification sender = req.when();
		Response resp = sender.post("http://dummy.restapiexample.com/api/v1/create");
		
		resp.then().log().all();
		
	}

}
