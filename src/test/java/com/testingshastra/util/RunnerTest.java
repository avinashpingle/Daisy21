package com.testingshastra.util;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Path of feature files and path of step definition files
@CucumberOptions(features="src/test/resources",
				 glue= {"com.testingshastra.stepdefinitions"},
				 dryRun = false
)
public class RunnerTest extends AbstractTestNGCucumberTests{

}
