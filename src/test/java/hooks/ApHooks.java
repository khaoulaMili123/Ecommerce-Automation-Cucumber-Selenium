package hooks;
import java.time.Duration;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.DriverFactory;
import utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApHooks {
	ConfigReader configreader;
	Properties properties;
	DriverFactory driverFactory;
	WebDriver driver;
	@Before (order = 0)
	public void getPropertyValues() {
		configreader = new ConfigReader();
		properties = configreader.ConfigurationManager();	
	}
	@Before (order = 1)
	public void initBrowser () {
		String browserName = configreader.getBrowserName();
		driverFactory = new DriverFactory();
		driver = driverFactory.initialisebrowser(browserName);
		driver.manage().window().maximize();
		driver.get(configreader.getUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@After
	public void closeBrowser (Scenario scenario) {
		String scenarioName = scenario.getName();
		if (scenario.isFailed()) {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			byte[] screnshot = takescreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screnshot, "image/png", scenarioName);
		}
		//driver.quit();
		
	}
	
}
