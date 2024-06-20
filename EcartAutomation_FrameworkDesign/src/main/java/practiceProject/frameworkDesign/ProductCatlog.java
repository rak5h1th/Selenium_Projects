package practiceProject.frameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practiceProject.AbstractComponents.AbstractCompoenent;

public class ProductCatlog extends AbstractCompoenent{
	WebDriver driver;
	public ProductCatlog(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory
	@FindBy(css=".mb-3")
	List<WebElement> productList;
	
	By products = By.cssSelector(".mb-3");
	By addToCart= By.xpath("//div[@class='card-body']/button[2]");
	By toast=By.cssSelector("#toast-container");
	By loader=By.cssSelector(".ng-animating");
	
	public   List<WebElement> getProductList() {
		waitForElementToAppear(products);
		return productList;
	}
	
	public WebElement getProductByName(String Product) {
		WebElement prod=productList.stream().filter(p->p.findElement(By.xpath("//div[@class='card-body']/h5/b")).getText().equals(Product)).findFirst().orElse(null);
		return prod;
	}
	public void addToCart(String Product) {
		WebElement prod= getProductByName(Product);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toast);
		waitForElementToDisappear(loader);
	}
}
