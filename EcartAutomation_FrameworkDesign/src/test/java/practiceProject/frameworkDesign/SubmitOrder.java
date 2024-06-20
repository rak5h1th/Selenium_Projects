package practiceProject.frameworkDesign;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import practiceProject.TestComponenets.BaseTest;

public class SubmitOrder extends BaseTest{
	//String pro="ZARA COAT 3";
	String CountryName="India";
	@Test(dataProvider="getdata", groups= {"PurchaseOrder"})
	public void submitOrder(HashMap<String, String> input) throws IOException{
		ProductCatlog productcatlog=landingpage.loginapplication(input.get("email"), input.get("password"));
		List<WebElement> productsList=productcatlog.getProductList();
		productcatlog.addToCart(input.get("pro"));
		CartPage cartpage=productcatlog.gotoCart();
		Boolean match=cartpage.verifyProductDisplay(input.get("pro"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage=cartpage.clickCheckout();
		checkoutpage.dropdownAction(CountryName);
		ConfirmationPage confirmpage=checkoutpage.SubmitOrder();
		String text=confirmpage.textConfirmation();
		AssertJUnit.assertFalse(text.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
	}
	
	@Test(dataProvider="getdata",dependsOnMethods= {"submitOrder"}, groups= {"PurchaseOrder"})
	public void orderConfirmation(HashMap<String, String> input) {
		ProductCatlog productcatlog=landingpage.loginapplication(input.get("email"), input.get("password"));
		OrderPage orderpage=productcatlog.gotoOrders();
		Assert.assertTrue(orderpage.verifyOrderDisplay(input.get("pro")));
	}
	

	
	@DataProvider
	public Object[][] getdata() {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "raxith@gmail.com");
		map.put("password", "Admin@123");
		map.put("pro", "ZARA COAT 3");
		
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("email", "raxith@gmail.com");
		map1.put("password", "Admin@123");
		map1.put("pro", "ZARA COAT 3");
		
		return new Object[][] {{map},{map1}};
	}

}
