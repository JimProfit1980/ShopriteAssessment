//Skip to content
//Product
//Solutions
//Open Source
//Pricing
//Search
//Sign in
//Sign up
//naveenanimation20
///
//PageObjectModel
//Public
//Code
//Issues
//8
//Pull requests
//24
//Actions
//Projects
//Security
//Insights
//PageObjectModel/src/main/java/com/qa/ExtentReportListener/ExtentReporterNG.java /
//
//Naveen Khunteta added code base of POM - Part -5
//Latest commit 67bd386 on Oct 13, 2017
// History
// 0 contributors
//Executable File  79 lines (63 sloc)  2.03 KB

/*
 * @autor : Naveen Khunteta
 * 
 */
package com.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator
				+ "Extent.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}

				extent.endTest(test);
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}

//Footer
//© 2023 GitHub, Inc.
//Footer navigation
//Terms
//Privacy
//Security
//Status
//Docs
//Contact GitHub
//Pricing
//API
//Training
//Blog
//About
//PageObjectModel/ExtentReporterNG.java at master · naveenanimation20/PageObjectModel · GitHub