package samautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import samautomation.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	//create constructor
	public LandingPage(WebDriver driver) {
		
		super(driver);
		//Initialisation
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
     
	//PageFactory
	
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;

		
		public ProductCatalogue loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			ProductCatalogue productCatalogue = new ProductCatalogue(driver);
			return productCatalogue;
			
			
		}
		

		  public String getErrorMessage()  { 
	      
		    waitForWebElementToAppear(errorMessage);
		    return errorMessage.getText();
		  }
		 
		
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
	}

