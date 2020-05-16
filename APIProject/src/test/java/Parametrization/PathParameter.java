package Parametrization;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class PathParameter {
	
	@Test
	public void pathParam() {
		
				Response resp = given()
				.param("username","Antonette")
				.param("id","2")
				.pathParam("x", "users")
				.when()
				.get("https://jsonplaceholder.typicode.com/{x}");
		
		resp.then().log().all();
		
	}

}
