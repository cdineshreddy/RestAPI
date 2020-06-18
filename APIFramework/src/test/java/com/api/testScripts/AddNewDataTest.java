package com.api.testScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.rootLib.RootClass;


@Listeners(com.api.rootLib.ApplyListner.class)
public class AddNewDataTest extends RootClass{

	@Test
	public void addNewPost()
	{
		String apiData = config.getPropertyObject("createNewPost");
		resp = config.executeRequest(apiData);
		resp.then().log().all();
		String body = resp.getBody().asString();
		Assert.assertTrue(body.contains("RajaRam"));
	}
}
