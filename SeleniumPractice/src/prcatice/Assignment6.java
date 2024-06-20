package prcatice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption2")).click();
		String opt2= driver.findElement(By.xpath("//fieldset/label[@for='benz']")).getText();
		System.out.println(opt2);
		WebElement drpdwn= driver.findElement(By.id("dropdown-class-example"));
		Select dropdown= new Select(drpdwn);
		dropdown.selectByVisibleText(opt2);
		driver.findElement(By.id("name")).sendKeys(opt2);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println( driver.switchTo().alert().getText().contains(opt2));
		
	
		
	}

}
