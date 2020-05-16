package JSONPath;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.ArrayList;

public class CheckJsonPath {
	
	@Test
	public void jsonContentFetching() {
		
		Response resp= get("https://jsonplaceholder.typicode.com/posts");
		
		/*
		 * Object obj=resp.jsonPath().get("title"); 
		 * System.out.println(obj);
		 */
		
		ArrayList<Object> list=resp.jsonPath().get("title");
		for(Object obj:list) {
			System.out.println(obj);
		}
		System.out.println("Number of titles are :"+list.size());
	}

}
