package practiceProject.frameworkDesign;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import practiceProject.TestComponenets.BaseTest;

public class errorValidation extends BaseTest{
	
	@Test(groups= {"ErrorValidation"})
	public void errorValid() throws IOException{

		String pro="ZARA COAT 3";
		String CountryName="India";
		landingpage.loginapplication("rakshith@gmail.com", "Admin@12");
		AssertJUnit.assertEquals("Incorrect email password.",landingpage.Errorvalidation() );

	}
	
	@Test(groups= {"ErrorValidation"})
	public void producValid() {
		String pro="ZARA COAT 3";
		String CountryName="India";
		ProductCatlog productcatlog=landingpage.loginapplication("raxith@gmail.com", "Admin@123");
		List<WebElement> productsList=productcatlog.getProductList();
		productcatlog.addToCart(pro);
		CartPage cartpage=productcatlog.gotoCart();
		Boolean match=cartpage.verifyProductDisplay(pro);
		Assert.assertFalse(match);
	}
}
