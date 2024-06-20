package prcatice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class streamsSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr.th[1]")).click();
		List<WebElement> list=driver.findElements(By.xpath("//tr/td[1]"));
		List<String> actlist=list.stream().map(a->a.getText()).collect(Collectors.toList());
		List<String> explist=actlist.stream().sorted().collect(Collectors.toList());
		
		List<String> price=list.stream().filter(a->a.getText().contains("Rice")).map(a->getPrice(a)).collect(Collectors.toList());
		

	}


private static String getPrice(WebElement a) {
	String priceval= a.findElement(By.xpath("following-sibling::td[1]")).getText();
	return priceval;
	
}
}