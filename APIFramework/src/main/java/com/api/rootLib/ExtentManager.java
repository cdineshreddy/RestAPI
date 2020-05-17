package com.api.rootLib;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportFileName = 
			"Test-Execution-Report"+".html";
	
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	//Create an extent report instance
	public static ExtentReports createInstance() {
		Date d = new Date();
		String currentTime = d.toString();
		currentTime = currentTime.replaceAll(" ", "").replaceAll(":", "");

		ExtentHtmlReporter htmlReporter = new 
	ExtentHtmlReporter("./TestReport/test-report"+currentTime+".html");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTimeStampFormat
		("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//Set environment details
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("AUT", "Gaurav");

		return extent;
	}

}
