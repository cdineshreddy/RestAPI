package JSONPath;

import static io.restassured.RestAssured.get;
import java.util.ArrayList;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class GetCurrencyCode {

	@Test
	public void currencyCode() {
		
		Response resp=get("http://restcountries.eu/rest/v2/all");
		ArrayList<Object> list= resp.jsonPath().get("currencies.code");
		for(Object obj:list) {
			System.out.println(obj);
		}
		
		Object obj=resp.jsonPath().get("currencies[1].code");
		System.out.println("The second country currency code is :"+obj);
	}
}
