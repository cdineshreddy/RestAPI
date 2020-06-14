package DataDriven;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DataDrivenTest {
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "getEmpData")
	public void createEmployess(String ename, String sal, String age) {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
		RequestSpecification req = RestAssured.given();
		
		JSONObject jobj = new JSONObject();
		jobj.put("name", ename);
		jobj.put("salary", sal);
		jobj.put("age", age);

		String obj = jobj.toJSONString();
		req.body(obj);
		req.contentType(ContentType.JSON);
		
		RequestSpecification sender = req.when();
		Response resp = sender.request(Method.POST);
		String body = resp.asString();
		System.out.println(body);
		Assert.assertEquals(body.contains(ename), true);
		Assert.assertEquals(body.contains(sal), true);
		Assert.assertEquals(body.contains(age), true);
		
		
	}
	@DataProvider
	public String[][] getEmpData() throws IOException{

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\DataDriven\\APITestData.xls";
		int rownum = ExcelUtils.getRowCount(path, "TestData");
		int colnum = ExcelUtils.getCellCount(path, "TestData", 1);
		String empData[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				empData[i - 1][j] = ExcelUtils.getCellData(path, "TestData", i, j);
			}
		}
		
		//String empData[][] = {{"Dinesh","10000","23"},{"Ramesh","20000","32"},"Krishna","23000","27"}};
		return empData;
	}
		

}
