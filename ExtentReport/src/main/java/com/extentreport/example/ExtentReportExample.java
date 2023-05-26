package com.extentreport.example;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportExample {
	static WebDriver driver;
	ExtentReports extentReports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;

	@Test(priority = 1)
	public void openGoogle() throws IOException {
		testCase = extentReports.createTest("Verify Google Title");
		testCase.log(Status.INFO, "Navigating to Google");
		driver.get("https://www.google.co.in");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : " + title);
		testCase.log(Status.INFO, "Expected Title : " + "Google");
		testCase.log(Status.INFO, "Actual Title : " + title);
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("Google")) {
			testCase.log(Status.PASS, "Actual Title And Expected Title are Equal");
		} else {
			testCase.log(Status.FAIL, "Actual Title And Expected Title are Not Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("Google.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("Google.png");
		}
	}

	@Test(priority = 2)
	public void openBing() throws IOException {
		testCase = extentReports.createTest("Verify Bing Title");
		testCase.log(Status.INFO, "Navigating to Bing");
		driver.get("https://www.bing.co.in");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : " + title);
		testCase.log(Status.INFO, "Expected Title : " + "Bing");
		testCase.log(Status.INFO, "Actual Title : " + title);
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("Bing")) {
			testCase.log(Status.PASS, "Actual Title And Expected Title are Equal");
		} else {
			testCase.log(Status.FAIL, "Actual Title And Expected Title are Not Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("Bing.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("Bing.png");

		}
	}

	@Test(priority = 3)
	public void openWikipedia() throws IOException {
		testCase = extentReports.createTest("Verify Wikipedia Title");
		testCase.log(Status.INFO, "Navigating to Wikipedia");
		driver.get("https://www.wikipedia.org/");
		String title = driver.getTitle();
		testCase.log(Status.INFO, "Actual Title : " + title);
		testCase.log(Status.INFO, "Expected Title : " + "Wikipedia");
		testCase.log(Status.INFO, "Actual Title : " + title);
		testCase.log(Status.INFO, "Verification of Actual and Expected Title ");
		if (title.equals("Wikipedia")) {
			testCase.log(Status.PASS, "Actual Title And Expected Title are Equal");
		} else {
			testCase.log(Status.FAIL, "Actual Title And Expected Title are Not Equal");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("Wikipedia.png");
			FileHandler.copy(sourceFile, destinationFile);
			testCase.addScreenCaptureFromPath("Wikipedia.png");

		}
	}

	@BeforeSuite
	public void launchBrowser() {
		extentReports = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		extentReports.attachReporter(htmlReporter);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
	}

	@AfterSuite
	public void closerowser() {
		driver.quit();
		extentReports.flush();
	}
}
