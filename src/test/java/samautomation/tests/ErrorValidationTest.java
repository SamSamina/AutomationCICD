package samautomation.tests;

import org.testng.annotations.Test;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import samautomation.TestComponents.BaseTest;
import samautomation.pageobjects.CartPage;
import samautomation.pageobjects.ProductCatalogue;
import samautomation.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups= {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {
	  
	  String productName = "ZARA COAT 3"; 
	  landingPage.loginApplication("samina.kausar.professional@gmail.com",
	  "8b@2$A2Dy.Ua6Z@"); 
	  Thread.sleep(10);
	  System.out.println("Login Successfully");
      Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

	  }
	  
	  
	  @Test public void ProductErrorValidation() throws IOException,
	  InterruptedException {
	  
	  String productName = "ZARA COAT 3"; 
	  ProductCatalogue productCatalogue =
	  landingPage.loginApplication("samina.kausar.professional@gmail.com",
	  "8b@2$A2Dy.Ua6Z@"); 
	  
	  List<WebElement>products =productCatalogue.getProductList();
	  productCatalogue.addProductToCart(productName); 
	  CartPage cartPage =productCatalogue.goToCartPage(); 
	  Boolean match =cartPage.VerifyProductDisplay("ZARA COAT 33"); 
	  //Assert.assertFalse(match);
	// Ensure that the product "ZARA COAT 33" is not displayed
      System.out.println("Product match: " + match);
      Assert.assertFalse(match, "Product 'ZARA COAT 33' should not be in the cart.");
	  
	  
	  
	  }
	  
	 
	

}
