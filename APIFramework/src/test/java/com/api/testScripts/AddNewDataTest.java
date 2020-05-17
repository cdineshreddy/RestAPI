package com.api.testScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.rootLib.RootClass;

import io.restassured.response.Response;

@Listeners(com.api.rootLib.ApplyListner.class)
public class AddNewDataTest extends RootClass{

	@Test
	public void addNewPost()
	{
		String apiData = config.getPropertyObject("createNewPost");
		Response resp = config.executeRequest(apiData);
		resp.then().log().all();
	}
}
