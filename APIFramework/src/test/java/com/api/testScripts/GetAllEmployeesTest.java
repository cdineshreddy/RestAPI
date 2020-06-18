package com.api.testScripts;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.rootLib.RootClass;

import junit.framework.Assert;


@Listeners(com.api.rootLib.ApplyListner.class)
public class GetAllEmployeesTest extends RootClass{

	@Test
	public void fetchAllEmployess()
	{
		String apiData = config.getPropertyObject("AllEmp");
		resp = config.executeRequest(apiData);
		resp.then().log().all();
		Assert.assertEquals("HTTP/1.1 200 OK", resp.getStatusLine());
		Assert.assertEquals(200, resp.getStatusCode());
		Assert.assertEquals(resp.getTime()<1000,true);
	}
}
