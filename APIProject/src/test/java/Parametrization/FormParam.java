package Parametrization;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class FormParam {
	
	@Test
	public void getData()
	{	
		given()
		.formParam("userId", "9")
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then().log().all();

	}

}
