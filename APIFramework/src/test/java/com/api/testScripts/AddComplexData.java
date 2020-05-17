package com.api.testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class AddComplexData {

	@Test
	public void insertComplexData() throws IOException
	{
		// Approach 1
		Path myFile = Paths.get("./data/complex.json");
		byte[] myFileData = Files.readAllBytes(myFile);
		String jsonData = new String(myFileData);
		RequestSpecification req1 = given();
		req1.body(jsonData);
		req1.contentType(ContentType.JSON);
		RequestSender sender1 = req1.when();
		Response resp1 = sender1.post("http://localhost:3000/posts");
		resp1.then().log().all();
		
		// Approach 2
		File f = new File("./data/complex.json");
		FileInputStream fis = new FileInputStream(f);
		RequestSpecification req2 = given();
		req2.body(IOUtils.toString(fis, "UTF-8"));
		req2.contentType(ContentType.JSON);
		RequestSender sender2 = req2.when();
		Response resp2 = sender2.post("http://localhost:3000/posts");
		resp2.then().log().all();
	}
}














