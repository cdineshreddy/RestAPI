package Assertions;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class BasicParam {
	
	@Test
	public void assertionTest() {
		Response resp =  given()
						.param("id",16)
						.param("title","TestEngineer")
						.when()
						.get("http://localhost:3000/posts");
		
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}

}
