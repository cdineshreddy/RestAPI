package RealTimeAPI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllEmployee {
	
	@Test
	public void getEmployeeData() {
		
		//Will get 405 Error - Method not allowed
		Response resp = RestAssured.get("http://dummy.restapiexample.com/api/v1/create");
		resp.then().log().all();
	}


}
