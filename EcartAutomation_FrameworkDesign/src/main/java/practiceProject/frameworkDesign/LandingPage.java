package practiceProject.frameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceProject.AbstractComponents.AbstractCompoenent;

public class LandingPage extends AbstractCompoenent {
	WebDriver driver;
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement email=driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	public ProductCatlog loginapplication(String usrmail, String pswrd) {
		email.sendKeys(usrmail);
		Password.sendKeys(pswrd);
		Submit.click();
		ProductCatlog productcatlog= new ProductCatlog(driver);
		return productcatlog;
	}
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String Errorvalidation() {
		waitForWebElementToAppear(errormsg);
		return errormsg.getText();
		
	}

}
