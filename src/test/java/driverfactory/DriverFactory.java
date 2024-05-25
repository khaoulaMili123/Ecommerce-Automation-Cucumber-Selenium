package driverfactory;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public ChromeOptions options;
	public EdgeOptions option;
	public FirefoxOptions opt;
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public WebDriver initialisebrowser (String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver(options));
		}else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			tdriver.set(new EdgeDriver(option));
		}else if (browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions opt = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver(opt));
		}else {
			System.out.println("**Browser is not defines**");
		}
		return tdriver.get();
	}
	public static WebDriver getDriver() {
		return tdriver.get();
	}
public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
		}

}
