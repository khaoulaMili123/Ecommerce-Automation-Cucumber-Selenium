package pages;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.ElementUtils;
public class BuyingProduct {
	WebDriver driver;
	ElementUtils utils;
	ConfigReader config;
	Properties properties;

public BuyingProduct (WebDriver driver){
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
@FindBy (xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
WebElement ProceedToCheck1;
@FindBy (xpath = "//*[@id=\"center_column\"]/form/p/button")
WebElement ProceedToCheck2;
@FindBy (xpath = "//*[@id=\"uniform-cgv\"]")
WebElement Agree;
@FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")
WebElement ProceedToCheck3;
@FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")
WebElement PayByCheck;
@FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")
WebElement Confirm;
@FindBy (xpath = "//div[@id='center_column']/p[@class='alert alert-success']")
WebElement Confirmation;

public void Connexion () {
	utils.ClickOnElement(SignIn, 10);
	utils.TextIntoElement(email, config.getMail(), 10);
	utils.TextIntoElement(password, config.getPassword(), 10);
	utils.ClickOnElement(login, 10);
}
public void WomenSection () {
	utils.ClickOnElement(Women, 10);
}
public void SelectProduct () {
	Actions act = new Actions(driver);
	act.moveToElement(SecondArticle).moveToElement(Morebtn).click().build().perform();

}
public void SelectQSC() throws Throwable {
	utils.selectOptionByVisibleText(Size, "M");
	//utils.ClickOnElement(Color, 10);
	Thread.sleep(3000);
	Color.click();
	Thread.sleep(3000);
	utils.TextIntoElement(Quantity, "2", 10);
	
}
public void Cartbtn() {
	utils.ClickOnElement(AddToCart, 10);
}
public void checkout() {
	utils.ClickOnElement(Proceed, 10);
	utils.javaScriptscrollToBottom();
	utils.ClickOnElement(ProceedToCheck1, 0);
	utils.ClickOnElement(ProceedToCheck2, 10);
	utils.ClickOnElement(Agree, 10);
	utils.ClickOnElement(ProceedToCheck3, 10);
}
public void payment () {
	utils.ClickOnElement(PayByCheck, 10);
	utils.ClickOnElement(Confirm, 10);
}
public void ConfirmationOrder() {
	Confirmation.getText();
	if(Confirmation.getText().contains("is complete")) {
		   System.out.println("Order Completed: Test Case Passed");
		  }
		  else {
		   System.out.println("Order Not Successfull: Test Case Failed");
		  }
}

}