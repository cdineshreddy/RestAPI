package Assertions;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CheckAssertion {
	
	@Test
	public void assertionTest() {
		
		Response resp = given()
				.param("userId","7")
				.param("id","64")
				.pathParam("x", "posts")
				.when()
				.get("https://jsonplaceholder.typicode.com/{x}");
		
		resp.then().assertThat().statusCode(200);
		resp.then().assertThat().contentType(ContentType.JSON);
		resp.then().log().all();
	}

}
