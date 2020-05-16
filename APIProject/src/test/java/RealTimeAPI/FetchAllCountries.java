package RealTimeAPI;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchAllCountries {
	
	@Test
	public void getCountriesDetails() {
		
		Response resp = RestAssured.get("http://restcountries.eu/rest/v2/all");
		resp.then().log().all();
	}

}
