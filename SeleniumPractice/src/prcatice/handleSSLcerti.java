package prcatice;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handleSSLcerti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		ChromeOptions option= new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		//Proxy pr= new Proxy();
		//pr.setHttpProxy("ipaddress:1234");
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
