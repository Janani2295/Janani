package com.omrbranch.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Login", stepNotifications = true, snippets = SnippetType.CAMELCASE, dryRun = false, publish = true, monochrome = true, plugin = {
		"pretty",
		"json:target\\output.json" }, glue = "com.omrbranch.stepdefinition", features = "src\\test\\resources")


public class TestRunner extends BaseClass {
//	@AfterClass
//	public static void afterClass() throws FileNotFoundException, IOException {
//		Reporting.generateJvmReport(getProjectPath() + getPropertyFileValue("jsonPath"));
//
//	}


}
