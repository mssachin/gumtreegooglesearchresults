package com.gumtree.googlesearch.runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features={"src/test/resources/features/"},
        glue = {"com.gumtree.googlesearch.stepdefinitions"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html", "pretty"}
)
public class TestRunner {
    @AfterClass
    public static void tearDown() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//extent-config.xml"));

    }


}