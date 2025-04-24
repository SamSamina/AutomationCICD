package samautomation.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import samautomation.TestComponents.BaseTest;
import samautomation.pageobjects.CartPage;
import samautomation.pageobjects.CheckoutPage;
import samautomation.pageobjects.ConfirmationPage;
import samautomation.pageobjects.OrderPage;
import samautomation.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	
	//String productName = "ZARA COAT 3";

	
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException{
		

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		//CartPage cartPage = new CartPage(driver);
		CartPage cartPage = productCatalogue.goToCartPage();
	
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("Pakistan");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		
	    String confirmMessage =	confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dataProvider="getData", dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest(HashMap<String,String> input)
	{
		//"ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(input.get("product")));
		
    }
	
	
	
   @DataProvider
	public Object[][] getData() throws IOException {
	   
	   List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//samautomation//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
   }
	   
	   //return new Object [][] {{"samina.kausar.professional@gmail.com","8b@2$A2Dy.Ua6Z@","ZARA COAT 3"},{"samina.kausar.professional@gmail.com","8b@2$A2Dy.Ua6Z@","ZARA COAT 3"}}; 
  
		/*
		 * HashMap<String,String> map = new HashMap<String,String>(); map.put("email",
		 * "samina.kausar.professional@gmail.com"); map.put("password",
		 * "8b@2$A2Dy.Ua6Z@"); map.put("product", "ZARA COAT 3");
		 * 
		 * HashMap<String,String> map1 = new HashMap<String,String>(); map1.put("email",
		 * "samina.kausar.professional@gmail.com"); map1.put("password",
		 * "8b@2$A2Dy.Ua6Z@"); map1.put("product", "ZARA COAT 3");
		 */
		
		//return new Object[][] {{map},{map1}};
      //}
		
   }





