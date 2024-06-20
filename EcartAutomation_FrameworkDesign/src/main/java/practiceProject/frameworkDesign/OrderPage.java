package practiceProject.frameworkDesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceProject.AbstractComponents.AbstractCompoenent;

public class OrderPage extends AbstractCompoenent {
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productName;
	
	public Boolean verifyOrderDisplay(String pro) {
		Boolean match=productName.stream().anyMatch(product->product.getText().equalsIgnoreCase(pro));
		return match;
	}

}
