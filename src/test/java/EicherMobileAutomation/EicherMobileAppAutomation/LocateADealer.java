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


public class LocateADealer  extends base{

	//Viewing that Dealer locator is to be part of the Hamburger menu
		@Test(priority=1)	
	    public void DealerLocatorOptionIsPresentInHamburger() {	
		     
		driver.findElement(By.id("com.app.cep:id/ivBack")).click();

		//driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		
		String DealerLocatorOptionPresentInHamburger= driver.findElement(By.id("com.app.cep:id/tvLocator")).getText();
		

		System.out.println(DealerLocatorOptionPresentInHamburger);
		Assert.assertEquals("Locate a Dealer", DealerLocatorOptionPresentInHamburger);
		
		driver.findElement(By.id("com.app.cep:id/tvLocator")).click();
		}
		
		//Verify that  Dealer Locator Screen Appears on tapping Dealer Locator Module option present in Hamburger.
		
				@Test(priority=2)	
			    public void DealerLocatorScreenAppears() {	
				
			
				String DealerLocatorScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='DEALER LOCATOR']").getText();
				

				System.out.println(DealerLocatorScreenAppears);
				Assert.assertEquals("DEALER LOCATOR",DealerLocatorScreenAppears);
						 			
					  }
				
				
				//Verify that A standard map view which will display all our network Touch points on tapping Dealer Locator Module option present in Hamburger.
				
				@Test(priority=3)	
			    public void StandardMapViewAppears() {	
				
					String StandardMapViewAppear = 	driver.findElement(By.id("com.app.cep:id/mapfragment")).getText();
			
			

				System.out.println(StandardMapViewAppear);
				//Assert.assertEquals("DEALER LOCATOR",StandardMapViewAppear);
						 			
					  }
				
				
				
	//User can manually search for a location basis State, City, District 
				@Test(priority=4, enabled = false)	
			    public void SearchForLocationBasisStateCity() {	
				
					driver.findElement(By.id("com.app.cep:id/spnrState")).click();
					driver.findElementByXPath("//android.view.View[@text='Haryana']").click();
					
					driver.findElement(By.id("com.app.cep:id/spnrcity")).click();
					driver.findElementByXPath("//android.view.View[@text='Gurgaon']").click();
					String StandardMapViewAppear1 = 	driver.findElement(By.id("com.app.cep:id/mapfragment")).getText();
					
					

					System.out.println(StandardMapViewAppear1);
			
					  }
				
				//User should have the option of evaluating the touch points for a particular route
				
				@Test(priority=4, enabled = false)	
			    public void evaluatingTouchPointsforParticularRoute() {	
				
					driver.findElement(By.id("com.app.cep:id/ivnavigate")).click();

					String DealerLocatorScreenRoute=driver.findElementByXPath("//android.widget.TextView[@text='DEALER LOCATOR']").getText();
					

					System.out.println(DealerLocatorScreenRoute);
					Assert.assertEquals("DEALER LOCATOR",DealerLocatorScreenRoute);
	String StandardMapViewAppear2 = 	driver.findElement(By.id("com.app.cep:id/mapfragment")).getText();
					
					

					System.out.println(StandardMapViewAppear2);
					
					  }
				
				@Test(priority=5)	
			    public void evaluatingTouchPointsforRoute() {	
				
					driver.findElement(By.id("com.app.cep:id/ivnavigate")).click();

				String DealerLocatorScreenRoute=driver.findElementByXPath("//android.widget.TextView[@text='DEALER LOCATOR']").getText();
					

				System.out.println(DealerLocatorScreenRoute);
				Assert.assertEquals("DEALER LOCATOR",DealerLocatorScreenRoute);
	//String StandardMapViewAppear2 = driver.findElement(By.id("com.app.cep:id/mapfragment")).getText();
					
					

				//	System.out.println(StandardMapViewAppear2);
					
					  }

}
		 
	      
		
