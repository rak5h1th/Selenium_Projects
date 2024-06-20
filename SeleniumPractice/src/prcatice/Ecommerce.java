package prcatice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] prodlist= {"Cucumber","Beetroot","Brocolli"};
		addItems(driver, prodlist);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),PROCEED TO CHECKOUT)]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		

	}
	public static void addItems(WebDriver driver,String[] prodlist) {
		List<WebElement> Prod=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<Prod.size();i++) {
			String[] name=Prod.get(i).getText().split("-");
			String formatname=name[0].trim();
			
			List itemsneeded= Arrays.asList(prodlist);
			if(itemsneeded.contains("formatname")) {
			
				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
				
			}
		}
	}

}
