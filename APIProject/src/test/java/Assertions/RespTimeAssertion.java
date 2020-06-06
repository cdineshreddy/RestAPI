package Assertions;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RespTimeAssertion {
	
	@Test
	public void assertionTest() {
		
		 Response resp=given()
				 .pathParam("x", "posts")
				 .when()
				 .get("https://jsonplaceholder.typicode.com/{x}");
		 
		 //By using TestNG
		 long timeinMS= resp.time();
		 System.out.println("Time in MS: "+timeinMS);
		 Assert.assertTrue(timeinMS<5000);
		 
		 //By using Rest Assured
		 resp.then().assertThat().time(Matchers.greaterThan(1000L));
		 resp.then().assertThat().time(Matchers.lessThan(5000L));
		 resp.then().log().all();
	}

}
