package Parametrization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FetchPosts {
	
	@Test
	public void getData()
	{	
		given()
		.queryParam("userId", "8")
		.when()
		.get("https://jsonplaceholder.typicode.com/posts?userId=9")
		.then().log().all();

	}
}