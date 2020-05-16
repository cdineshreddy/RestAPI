package RealTimeAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class FetchPosts {
	
	@Test
	public void getData() {
		
		/*
		 * RequestSpecification req = RestAssured.given(); req.queryParam("userId", 9);
		 * 
		 * RequestSender sender =req.when(); Response resp =
		 * sender.get("https://jsonplaceholder.typicode.com/posts");
		 * 
		 * ValidatableResponse vr = resp.then();
		 * ValidatableResponseLogSpec<ValidatableResponse, Response> log = vr.log();
		 * log.all();
		 */
		

		 given().queryParam("userId", 3)
		.when()
		.get("https://jsonplaceholder.typicode.com/posts")
		.then().log().all();
}

}
