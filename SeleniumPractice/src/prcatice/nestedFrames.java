package prcatice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class nestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		WebElement frame1=driver.findElement(By.name("frame-top"));
		driver.switchTo().frame(frame1);
		WebElement frame2=driver.findElement(By.name("frame-middle"));
		driver.switchTo().frame(frame2);
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.switchTo().defaultContent();

	}

}
