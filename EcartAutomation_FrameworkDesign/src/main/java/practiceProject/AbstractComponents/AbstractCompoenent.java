package practiceProject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practiceProject.frameworkDesign.CartPage;
import practiceProject.frameworkDesign.OrderPage;

public class AbstractCompoenent {
	WebDriver driver;
	public AbstractCompoenent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	@FindBy(css="[routerlink*='cart']")
	WebElement enterCart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement Orderbutton;

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public void waitForElementToDisappear(By findBy) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	public CartPage gotoCart() {
		enterCart.click();
		CartPage cartpage= new CartPage(driver);
		return cartpage;
	}
	public OrderPage gotoOrders() {
		Orderbutton.click();
		OrderPage orderpage= new OrderPage(driver);
		return orderpage;
		
	}

}
