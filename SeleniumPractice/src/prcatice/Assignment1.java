package prcatice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[2]//span[2]")).click();
		Thread.sleep(7000);
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/button[2]")).click();
		WebElement formdropdown=driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown= new Select(formdropdown);
		dropdown.selectByVisibleText("Student");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		Thread.sleep(7000);
		List<WebElement> products=  driver.findElements(By.xpath("//app-card/div/div[2]/button"));
		for(int i=0;i<products.size();i++) {
			products.get(i).click();
		}
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		

	}

}
