package RealTimeAPI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationAPI {
	
	@Test
	public void TestAuthorization() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		RestAssured.authentication = auth;
		
		RequestSpecification req = RestAssured.given();
		Response resp = req.request(Method.GET);
		
		String body = resp.getBody().asString();
		System.out.println(body);
		
		String id = resp.jsonPath().get("FaultId");
		System.out.println(id);
		
	}

}
