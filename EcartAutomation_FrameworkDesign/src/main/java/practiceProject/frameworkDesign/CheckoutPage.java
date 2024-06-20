package practiceProject.frameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceProject.AbstractComponents.AbstractCompoenent;

public class CheckoutPage extends AbstractCompoenent{
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country")
	WebElement placeholder;
	
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement country;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement OrderButton;
	
	By results=By.cssSelector(".ta-item");
	
	public void dropdownAction(String CountryName) {
		Actions a= new Actions(driver);
		a.sendKeys(placeholder, CountryName).build().perform();
		waitForElementToAppear(results);
		country.click();
	}
	
	public ConfirmationPage SubmitOrder() {
		OrderButton.click();
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		return confirmpage;
	}
	

}
