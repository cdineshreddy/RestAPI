package JSONPath;

import java.util.ArrayList;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FetchCountryCodeByName {
	
	@Test
	public void codeByName() {
		
		String CountryName = "India";
		Response resp = RestAssured.get("http://restcountries.eu/rest/v2/all");
		int indexOfCountry=getIndexOfCountry(resp, CountryName);
		if(indexOfCountry!=-1) {
			Object code=resp.jsonPath().get("currencies["+indexOfCountry+"].code");
			System.out.println(CountryName+" having the currency code is "+code);
		}
		
	}
	
	public int getIndexOfCountry(Response resp, String nameToBeSearch) {
		int index=1;
		ArrayList<Object> list = resp.jsonPath().get("name");
		if(list.contains(nameToBeSearch)) {
			index=list.indexOf(nameToBeSearch);
			System.out.println("Index of the given country: "+index);
		}else {
			System.out.println("Invalid country name");
		}
		return index;
	}

}
