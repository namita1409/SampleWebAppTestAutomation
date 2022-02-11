package com.heart.beat;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags ="@bag",dryRun = false)
public class HeartBeatRunner {

}
