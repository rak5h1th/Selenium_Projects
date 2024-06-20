package prcatice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class winHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[href='windows/new']")).click();
		Set<String> win= driver.getWindowHandles(); //[pw ,cw]
		Iterator<String> it= win.iterator();
	    String pc= it.next();
	    String cc= it.next();
	    driver.switchTo().window(cc);
	    System.out.println(driver.findElement(By.cssSelector(".example")).getText());
	    driver.switchTo().window(pc);
	    System.out.println(driver.findElement(By.cssSelector(".example")).getText());
	    

	}

}
