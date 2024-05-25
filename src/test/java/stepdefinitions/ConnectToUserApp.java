package stepdefinitions;
import static org.junit.Assert.assertEquals;



import java.util.Properties;

import driverfactory.DriverFactory;
import pages.UserRegistration;
import utils.ConfigReader;
import utils.ElementUtils;
import io.cucumber.java.en.*;

public class ConnectToUserApp {
	UserRegistration UR;
	ConfigReader config;
	Properties properties;
	ElementUtils utils;
	@Given("I am on the automation practice website")
	public void i_am_on_the_automation_practice_website() {
	    
	}

	@When("I click on sign-in")
	public void i_click_on_sign_in() throws Throwable {
	    config = new ConfigReader();
		properties = config.ConfigurationManager();	
		//config.ConfigurationManager();
	    UR = new UserRegistration(DriverFactory.getDriver());
	    utils = new ElementUtils(DriverFactory.getDriver());
	    Thread.sleep(2000);
	    DriverFactory.getDriver().navigate().refresh();
	    UR.clickOnSignIn();
	}
	@When("I submit the registration form")
	public void i_submit_the_registration_form() {
	UR.CreateAnAccount();
	}

	@When("I fill in my personal information")
	public void i_fill_in_my_personal_information() {
	    UR.EnterPersonalInformation();
	}

	@When("I fill in my address information")
	public void i_fill_in_my_address_information() {
	    UR.EnterAdress();
	}

	@Then("I should see my firstname in my account")
	public void i_should_see_my_firstname_in_my_account() {
	    System.out.println(UR.NameOfAccount());
	    System.out.println(config.getValidateName());
	    assertEquals(UR.NameOfAccount(), config.getValidateName());
	}
}
