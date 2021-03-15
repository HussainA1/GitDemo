package EicherMobileAutomation.EicherMobileAppAutomation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.awt.List;

import static io.appium.java_client.touch.offset.ElementOption.element;



import java.io.IOException;


public class OurProducts  extends base{


	//Viewing that Our Products option is present in Hamburger
		@Test(priority=1)	
	    public void OurProductsOptionIsPresentInHamburger() {	
		 driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		 driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			
		String OurProductsOptionPresentInHamburger= driver.findElement(By.id("com.app.cep:id/tvconnVehicles")).getText();
		

		System.out.println(OurProductsOptionPresentInHamburger);
		// Assert.assertEquals("Our Products", OurProductsOptionPresentInHamburger);
		
		driver.findElement(By.id("com.app.cep:id/tvconnVehicles")).click();
		}
		
		//Verify that PRODUCT CATALOGUE  screen appears on tapping Our Products Module option present in Hamburger.
		
				@Test(priority=2)	
			    public void ProductCatalogueScreenAppears() {	
				
			
				String PRODUCT_CATALOGUEScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='PRODUCT CATALOGUE']").getText();
				

				System.out.println(PRODUCT_CATALOGUEScreenAppears);
				Assert.assertEquals("PRODUCT CATALOGUE",PRODUCT_CATALOGUEScreenAppears);
						 			
					  }
				
		//Filter specific types of products by clicking on pre-defined section
		@Test(priority=3)	
	    public void FilterSpecificTypesOfProductsByClickingOnPredefinedSection() throws SQLException {	

			//1. Verify that Trucks and Buses section is present on Product Catalogue screen. 
			
			//String TrucksSectionIsPresent=driver.findElement(By.id("com.app.cep:id/trucks_LL")).getText();
			//System.out.println(TrucksSectionIsPresent);
			//Assert.assertEquals("Trucks",TrucksSectionIsPresent);

			
			
			//2. Verify that following things are present on Trucks screen.
			//a Heavy Duty Trucks - Haulage, Tractor Trailer, Tripper.
           String HeavyDutyTrucksSectionIsPresent=driver.findElement(By.id("com.app.cep:id/tvProCatName")).getText();
           System.out.println(HeavyDutyTrucksSectionIsPresent);
			Assert.assertEquals("Heavy Duty Trucks",HeavyDutyTrucksSectionIsPresent);
			
		}	
         //a Heavy Duty Trucks - Tripper.
		@Test(priority=4)	
	    public void HeavyDutyTrucks_Tripper() throws SQLException {	
  
			
			driver.findElementByXPath("//android.widget.TextView[@text='Tipper']").click();
			
			driver.findElementByXPath("//android.widget.TextView[@text='VIEW DETAILS']").click();
			 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"I’M INTERESTED\").instance(0))");

			 driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		}
			 
		     //a Heavy Duty Trucks - Haulage
				@Test(priority=5)	
			    public void HeavyDutyTrucks_Haulage() throws SQLException {	
		   
			 
			 
			 driver.findElementByXPath("//android.widget.TextView[@text='Haulage']").click();
				driver.findElementByXPath("//android.widget.TextView[@text='VIEW DETAILS']").click();

			 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"I’M INTERESTED\").instance(0))");

			 driver.findElement(By.id("com.app.cep:id/ivBack")).click();
				}
				
			    //a Heavy Duty Trucks - Tractor Trailer
							@Test(priority=6)	
						    public void HeavyDutyTrucks_TractorTrailer() throws SQLException {	
					   
								{
			 driver.findElementByXPath("//android.widget.TextView[@text='Tractor Trailer']").click();
				driver.findElementByXPath("//android.widget.TextView[@text='VIEW DETAILS']").click();

			 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"I’M INTERESTED\").instance(0))");

			 driver.findElement(By.id("com.app.cep:id/ivBack")).click();

								}
			//b. Light & Medium Duty trucks - Sub 5 Ton, Medium Duty, Light Duty and Tipper
			//c. Tell Us What You Looking For - Category, SubCategory, CVW Range and Body Type. 



}
}
	      
		
