package JSONPath;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetFirstTitle {
	
	@Test
	public void getTitle() {
		
		Response resp=get("https://jsonplaceholder.typicode.com/posts");
		Object obj= resp.jsonPath().getString("title[1]");
		System.out.println(obj);
		
		try {
		String actualTitle=obj.toString();
		Assert.assertEquals(actualTitle, "qui est esse");
		System.out.println("pass");
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
