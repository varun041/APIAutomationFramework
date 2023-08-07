package com.example.demo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",plugin = {"pretty",
                "html:target/report/cucumber.html",
                "json:target/report/cucumber.json"
        }, glue = "com.example.demo.steps")

public class TestRunner {

}
