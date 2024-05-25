package stepdefinitions;
import java.util.Properties;



import driverfactory.DriverFactory;
import pages.VerifyTotalPrice;
import utils.ConfigReader;
import utils.ElementUtils;
import io.cucumber.java.en.*;

public class StepDefTotalPrice {
	ElementUtils ut;
	VerifyTotalPrice VTP;
	ConfigReader config;
	Properties properties;
	@Given("I open the Automation Practice website")
	public void i_open_the_automation_practice_website() {
	    
	}

	@When("I log-in")
	public void i_log_in() {
		config = new ConfigReader();
		properties = config.ConfigurationManager();	
		ut = new ElementUtils(DriverFactory.getDriver());
		VTP = new VerifyTotalPrice(DriverFactory.getDriver());
		VTP.Signin();
	}

	@When("I select the Women section")
	public void i_select_the_women_section() {
	    VTP.SelectWomenSection();
	}

	@When("I choose the second displayed product and I click on the More button")
	public void i_choose_the_second_displayed_product_and_i_click_on_the_more_button() {
	   VTP.ChooseProduct();
	}

	@When("I select size and color")
	public void i_select_size_and_color() throws Throwable {
	    VTP.SelectSC();
	}
	@When("I ensure there is only one product")
	public void i_ensure_there_is_only_one_product() {
		VTP.CheckQuantity();;
	}

	@When("I click on the Add to Cart")
	public void i_click_on_the_add_to_cart() {
	    VTP.Cartbtn();
	}

	@When("I click on the Proceed to checkout")
	public void i_click_on_the_proceed_to_checkout() {
	    VTP.checkout();
	}

	@When("I modify the quantity")
	public void i_modify_the_quantity() throws Throwable {
	    VTP.ModifQuantity();
	}

	@Then("I verify that the total price changes and reflects the correct price.")
	public void i_verify_that_the_total_price_changes_and_reflects_the_correct_price() throws Throwable {
	    VTP.TotalPrice();
	}
}
