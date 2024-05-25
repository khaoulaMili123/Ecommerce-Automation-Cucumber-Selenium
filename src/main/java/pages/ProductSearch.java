package pages;

import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ProductSearch {
WebDriver driver;
ElementUtils ut;
public ProductSearch(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	ut = new ElementUtils(driver);
}

@FindBy(linkText = "WOMEN")
WebElement WomenTab;
@FindBy (xpath="//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']")
WebElement TshirtTab;
@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
WebElement ProductName;
@FindBy (id = "search_query_top")
WebElement Searchbox;
@FindBy (name = "submit_search")
WebElement Submit;
@FindBy (xpath = "//h5[@itemprop='name']//a[@class='product-name']")
WebElement SearchResultProductname;


public void InitialiseActionsclass () {
	Actions act = new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	act.moveToElement(WomenTab).moveToElement(TshirtTab).click().build().perform();
}
public void NameOfFirstProduct () {
	System.out.println(ProductName.getText());
}
public void ProductNameSearch() {
	ut.TextIntoElement(Searchbox, ProductName.getText(), 10);
	ut.ClickOnElement(Submit, 10);
}
public void ValidateProduct() {
	String ProductSourced= SearchResultProductname.getText();
	if (ProductName.getText().equalsIgnoreCase(ProductSourced)) {
		System.out.println("product is found");
	} else {
		System.out.println("product is not found");
	}
}
}