package prcatice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTableHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.xpath("//table/tbody/tr")).size());
		System.out.println(driver.findElements(By.xpath("//table/tbody/tr[1]/th")).size());
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")).getText());
		

	}

}
