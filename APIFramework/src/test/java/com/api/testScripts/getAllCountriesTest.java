package com.api.testScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.rootLib.ApiConfig;
import com.api.rootLib.RootClass;

import io.restassured.response.Response;

@Listeners(com.api.rootLib.ApplyListner.class)
public class getAllCountriesTest extends RootClass{

	@Test
	public void fetchAllCountry()
	{
		String apiData = config.getPropertyObject("getAllCountries");
		Response resp = config.executeRequest(apiData);
		resp.then().log().all();
	}
}
