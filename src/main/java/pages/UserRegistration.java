package pages;

import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ConfigReader;
import utils.ElementUtils;

public class UserRegistration {
	WebDriver driver;
	ElementUtils utils;
	ConfigReader config;
	Properties properties; 
	//constructeur
	public UserRegistration (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		utils = new ElementUtils(driver);
		config = new ConfigReader(); 
	properties = config.ConfigurationManager();
	}
	//les elements
	@FindBy(xpath = "//a[@class='login']")
	WebElement SignIn;
	@FindBy (id ="email_create")
	WebElement CreateAnAccount;
	@FindBy (id = "SubmitCreate")
	WebElement Submit;
	@FindBy (xpath = "//input[@id='id_gender2']")
	WebElement MrOrMrs;
	@FindBy (id = "customer_firstname")
	WebElement FName;
	@FindBy (id="customer_lastname")
	WebElement LName;
	@FindBy (id = "passwd")
	WebElement PassWord;
	@FindBy (name = "days")
	WebElement daydropdown;
	@FindBy (name = "months")
	WebElement months;
	@FindBy (name = "years")
	WebElement yeardropdown;
	@FindBy (id="submitAccount")
	WebElement Register;
	@FindBy (xpath = "//a[@href='http://www.automationpractice.pl/index.php?controller=address' and @title='Add my first address']")
	WebElement EnterAdress;
	@FindBy (id = "firstname")
	WebElement fnameforAdress;
	@FindBy (id = "lastname")
	WebElement lnameforAdress;
	@FindBy (id = "address1")
	WebElement address;
	@FindBy (id = "city")
	WebElement City;
	@FindBy (name = "id_state")
	WebElement statedropdown;
	@FindBy (id = "postcode")
	WebElement PostCode;
	@FindBy (name = "id_country")
	WebElement countrydropDown;
	@FindBy (id = "phone")
	WebElement phone;
	@FindBy (id = "phone_mobile")
	WebElement phonemobile;
	@FindBy (xpath = "//input[@name='alias']")
	WebElement Office;
	@FindBy (name = "submitAddress")
	WebElement submitAddress;
	@FindBy (xpath = "//a[@class='account']")
	WebElement MyAccount;
	
	//les méthodes
	//1-Cliquer sur sign-in
	public void clickOnSignIn() {
		utils.ClickOnElement(SignIn,5);
	}
	//2-CREATE AN ACCOUNT
	public void CreateAnAccount() {
		utils.TextIntoElement(CreateAnAccount, config.getMail(), 5);
		utils.ClickOnElement(Submit,5);
	}
	//3-Saisir vos informations personnelles, votre adresse et vos coordonnées
	public void EnterPersonalInformation () {
		utils.ClickOnElement(MrOrMrs, 10);
		//MrOrMrs.click();
		utils.TextIntoElement(FName, config.getFirstName(), 5);
		utils.TextIntoElement(LName, config.getLastName(), 5);
		utils.TextIntoElement(PassWord, config.getPassword(), 5);
		utils.selectOptionByValue(daydropdown, "20");
		utils.selectOptionByValue(months, "7");
		utils.selectOptionByValue(yeardropdown, "1999");
		utils.ClickOnElement(Register, 5);
	}
	public void EnterAdress () {
		utils.ClickOnElement(EnterAdress, 10);
		//EnterAdress.click();
		utils.TextIntoElement(fnameforAdress, config.getFirstName(), 10);
		utils.TextIntoElement(lnameforAdress, config.getLastName(), 10);
		utils.TextIntoElement(address, "58 Rues de xyz", 10);
		utils.TextIntoElement(City, "xyz", 10);
		utils.selectOptionByValue(statedropdown, "5");
		utils.TextIntoElement(PostCode, "20100", 10);
		utils.selectOptionByVisibleText(countrydropDown, "United States");
		utils.TextIntoElement(phone, "123456789", 10);
		utils.TextIntoElement(phonemobile, "014725836", 10);
		utils.TextIntoElement(Office, "Office", 10);
		utils.ClickOnElement(submitAddress, 10);
	}
	public String NameOfAccount() {
		return MyAccount.getText();
	}
}
