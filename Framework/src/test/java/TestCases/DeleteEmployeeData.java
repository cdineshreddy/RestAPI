package TestCases;

import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.*;
import TestBase.TestBase;
import io.restassured.RestAssured;

public class DeleteEmployeeData extends TestBase {

	@BeforeClass
	void deleteEmployee() throws InterruptedException {
		logger.info("Deleting an Employee record");

		response = get("http://localhost:3000/posts");
		int id = response.jsonPath().get("id[0]");
		System.out.println(id);
		response = RestAssured.delete("http://localhost:3000/posts/" + id);
		Thread.sleep(2000);
	}

	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}

	@AfterClass
	void tearDown() {
		logger.info("Finished to delete an record");
	}

}
