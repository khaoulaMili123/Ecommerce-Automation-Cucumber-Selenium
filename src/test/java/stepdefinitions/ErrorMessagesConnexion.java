package stepdefinitions;
import static org.junit.Assert.assertTrue;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import driverfactory.DriverFactory;
import pages.UserRegistration;
import utils.ConfigReader;
import utils.ElementUtils;
import io.cucumber.java.en.*;
public class ErrorMessagesConnexion {
	UserRegistration UR;
	ConfigReader config;
	Properties properties;
	ElementUtils utils;
	ChromeDriver driver;
	@Given("I open the URL")
	public void i_open_the_url()  {
	
	}

	@When("I click on the sign-in link")
	public void i_click_on_the_sign_in_link() throws Throwable {
		config = new ConfigReader();
		properties = config.ConfigurationManager();	
		//config.ConfigurationManager();
	    UR = new UserRegistration(DriverFactory.getDriver());
	    utils = new ElementUtils(DriverFactory.getDriver());
	    Thread.sleep(2000);
	    DriverFactory.getDriver().navigate().refresh();
	    UR.clickOnSignIn();
	}

	@When("I enter {string} into the email input field and {string} into the password input field and press Enter")
	public void i_enter_into_the_email_input_field_and_into_the_password_input_field_and_press_enter(String email, String Password) {
		
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(email);
		DriverFactory.getDriver().findElement(By.id("passwd")).sendKeys(Password);
		DriverFactory.getDriver().findElement(By.id("SubmitLogin")).click();
	}

	@Then("I validate that the error message displays.")
	public void i_validate_that_the_error_message_displays() {
		// Recherche de l'élément contenant le message d'erreur
        WebElement errorMessage = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"center_column\"]/div[1]"));
        
        // Vérification que l'élément est affiché
        assertTrue("Le message d'erreur 'Authentication failed' n'est pas affiché", errorMessage.isDisplayed());
	   
	}
}
