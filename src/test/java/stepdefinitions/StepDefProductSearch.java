package stepdefinitions;
import driverfactory.DriverFactory;


import pages.ProductSearch;
import utils.ElementUtils;
import io.cucumber.java.en.*;

public class StepDefProductSearch {
	ElementUtils ut;
	ProductSearch PS;
	
	@Given("I am on the homepage of Automation Practice website")
	public void i_am_on_the_homepage_of_automation_practice_website() {
	    
	}
	@When("I hover over the Women menu and I click on the T-shirts sub-menu")
	public void i_hover_over_the_women_menu_and_i_click_on_the_t_shirts_sub_menu() {
	    ut = new ElementUtils(DriverFactory.getDriver());
	    PS = new ProductSearch(DriverFactory.getDriver());
		PS.InitialiseActionsclass();
	}


	@When("I get the name\\/text of the first product displayed on the page")
	public void i_get_the_name_text_of_the_first_product_displayed_on_the_page() {
	    PS.NameOfFirstProduct();
	}

	@When("I enter the product name in the search bar")
	public void i_enter_the_product_name_in_the_search_bar() {
	   PS.ProductNameSearch();
	}

	@Then("I validate the product details")
	public void i_validate_the_product_details() {
	    PS.ValidateProduct();
	}
}
