package practiceProject.frameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceProject.AbstractComponents.AbstractCompoenent;

public class ConfirmationPage extends AbstractCompoenent{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement Confirmtxt;
	
	public String textConfirmation() {
		return Confirmtxt.getText();
		
	}
}