package stepdefinitions;
import java.util.Properties;



import driverfactory.DriverFactory;
import pages.BuyingProduct;
import utils.ConfigReader;
import utils.ElementUtils;
import io.cucumber.java.en.*;
public class StepDefBuyProduct {
	ElementUtils ut;
	BuyingProduct BP;
	ConfigReader config;
	Properties properties;
	@Given("I am on the Automation Practice website")
	public void i_am_on_the_automation_practice_website() {
		
	}

	@When("I log in")
	public void i_log_in() {
		config = new ConfigReader();
		properties = config.ConfigurationManager();	
		ut = new ElementUtils(DriverFactory.getDriver());
	    BP = new BuyingProduct(DriverFactory.getDriver());
	    BP.Connexion();
	}

	@When("I navigate to the Women section")
	public void i_navigate_to_the_women_section() {
		BP.WomenSection();
	}

	@When("I hover over the second displayed product and I click on the More button")
	public void i_hover_over_the_second_displayed_product_and_i_click_on_the_more_button() {
	   BP.SelectProduct();
	}

	@When("I select the quantity, size and color")
	public void i_select_the_quantity_size_and_color() throws Throwable {
	    BP.SelectQSC();
	}

	@When("I click on the Add to Cart button")
	public void i_click_on_the_add_to_cart_button() {
	   BP.Cartbtn();
	}

	@When("I click on the Proceed to checkout button")
	public void i_click_on_the_proceed_to_checkout_button() {
	    BP.checkout();
	}

	@When("I complete the ordering process up to payment")
	public void i_complete_the_ordering_process_up_to_payment() {
	   BP.payment();
	}

	@Then("I ensure that the product is successfully ordered.")
	public void i_ensure_that_the_product_is_successfully_ordered() {
	    BP.ConfirmationOrder();
	}




}
