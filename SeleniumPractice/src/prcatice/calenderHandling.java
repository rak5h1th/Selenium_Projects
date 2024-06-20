package prcatice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calenderHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String date="16";
		String month="11";
		String year="1997";
		String[] expDate= {"date","month","year"};
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("button.react-date-picker__calendar-button")).click();
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
		Thread.sleep(5000);
		WebElement prevBtn= driver.findElement(By.cssSelector("button[class*='react-calendar__navigation__prev-button']"));
		String currentYearRange= driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).getText();
		String expectYearRange= "1991-2000";
		do {
			prevBtn.click();
		}while(expectYearRange.equalsIgnoreCase(currentYearRange));
		driver.findElement(By.cssSelector("button:nth-child(7)")).click();
		driver.findElement(By.cssSelector("abbr[aria-label='November 16, 1997']")).click();
		List<WebElement> result=driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0; i<result.size();i++) {
			System.out.println(result.get(i).getAttribute("value"));
		
	
		}
	}

}
