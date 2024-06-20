package practiceProject.frameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceProject.AbstractComponents.AbstractCompoenent;

public class CartPage extends AbstractCompoenent {
	WebDriver driver;
	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElements(By.cssSelector(".cartSection h3"))
	@FindBy(css=".cartSection h3")
	List<WebElement> cartList;
	
	@FindBy(css=".totalRow button")
	WebElement button;
	
	
	public Boolean verifyProductDisplay(String pro) {
		Boolean match=cartList.stream().anyMatch(c->c.getText().equalsIgnoreCase(pro));
		return match;
	}

	public CheckoutPage clickCheckout() {
		button.click();
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
		
	}

}
