package pages;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.ElementUtils;

public class VerifyTotalPrice {
	WebDriver driver;
	ElementUtils utils;
	ConfigReader config;
	Properties properties;
	public VerifyTotalPrice (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utils = new ElementUtils(driver);
		config = new ConfigReader(); 
		properties = config.ConfigurationManager();
	}
	@FindBy(xpath = "//a[@class='login']")
	WebElement SignIn;
	@FindBy (id="email")
	WebElement email;
	@FindBy (id="passwd")
	WebElement password;
	@FindBy (id="SubmitLogin")
	WebElement login;
	@FindBy(linkText = "WOMEN")
	WebElement Women;
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img")
	WebElement SecondArticle;
	@FindBy (xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a")
	WebElement Morebtn;
	@FindBy (id ="color_8")
	WebElement Color;
	@FindBy(id="group_1")
	WebElement Size;
	@FindBy (id="quantity_wanted")
	WebElement Quantity;
	@FindBy (id="add_to_cart")
	WebElement AddToCart;
	@FindBy (xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
	WebElement Proceed;
	@FindBy (xpath = "//*[@id=\"cart_quantity_up_2_10_0_5412\"]")
	WebElement ModifiedQty;
	@FindBy (xpath ="//*[@id=\"total_price_container\"]")
	WebElement TotalPrice; 
	public void Signin () {
		utils.ClickOnElement(SignIn, 10);
		utils.TextIntoElement(email, config.getMail(), 10);
		utils.TextIntoElement(password, config.getPassword(), 10);
		utils.ClickOnElement(login, 10);
	}
	public void SelectWomenSection () {
		utils.ClickOnElement(Women, 10);
	}
	public void ChooseProduct () {
		Actions act = new Actions(driver);
		act.moveToElement(SecondArticle).moveToElement(Morebtn).click().build().perform();

	}
	public void SelectSC() throws Throwable {
		utils.selectOptionByVisibleText(Size, "M");
		//utils.ClickOnElement(Color, 10);
		Thread.sleep(3000);
		Color.click();
		Thread.sleep(3000);
	}
	public void CheckQuantity() {
	Quantity.getText();
		if (Quantity.getText().equals("1")) {
			System.out.println("Only one product exists");
		}else {
			utils.TextIntoElement(Quantity, "1", 10);
		}
	}
	public void Cartbtn() {
		utils.ClickOnElement(AddToCart, 10);
	}
	public void checkout() {
		utils.ClickOnElement(Proceed, 10);
	}
	public void ModifQuantity() throws Throwable {
		//utils.ClickOnElement(ModifiedQty, 10);
		Thread.sleep(5000);
		ModifiedQty.click();
	}
	public void TotalPrice() throws Throwable {
		TotalPrice.getText();
		Thread.sleep(5000);
		if (TotalPrice.getText().contains("61")) {
			System.out.println("the price is doubled ");
		}else {
			System.out.println("the price is not changed");
		}
	}
}
