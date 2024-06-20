package prcatice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links= driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul/li[2]/a"));
		for(WebElement link : links) {
			String url=link.getAttribute("href");
		    HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
	        conn.setRequestMethod("HEAD");
	        conn.connect();
	        int respCode = conn.getResponseCode();
	        if(respCode >=400) {
	        	System.out.println("Link is broken");
	        }
	        
		}
			

	}

}
