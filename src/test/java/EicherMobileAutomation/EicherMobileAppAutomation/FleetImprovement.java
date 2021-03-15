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


public class FleetImprovement  extends base{


	//Viewing that Fleet Improvement option is present in Hamburger
		@Test(priority=1)	
	    public void FleetImprovementOptionIsPresentInHamburger() {	
		
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		String FleetImprovementOptionPresentInHamburger= driver.findElement(By.id("com.app.cep:id/tvfleetperfrm")).getText();
		

		System.out.println(FleetImprovementOptionPresentInHamburger);
		Assert.assertEquals("Fleet Improvement", FleetImprovementOptionPresentInHamburger);
		}
		
		//Verify that FLEET IMPROVEMENT  screen appears on tapping Fleet Improvement Module option present in Hamburger.
		
		@Test(priority=2)	
	    public void FLEETIMPROVEMENTScreenAppears() {	
		
		driver.findElement(By.id("com.app.cep:id/tvfleetperfrm")).click();
		String FLEETIMPROVEMENTScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='FLEET IMPROVEMENT']").getText();
		

		System.out.println(FLEETIMPROVEMENTScreenAppears);
		Assert.assertEquals("FLEET IMPROVEMENT", FLEETIMPROVEMENTScreenAppears);
				 			
			  }
 
		//Verify that Fleet Improvement screen appears on tapping "Enroll" present in FLEET IMPROVEMENT screen.  
		@Test(priority=3)	
	    public void FleetImprovementscreenAppearsOnTappingEnroll() {	
			
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"ENROLL\").instance(0))").click();
		String FleetImprovementscreenAppear=driver.findElementByXPath("//android.widget.TextView[@text='FLEET IMPROVEMENT']").getText();
		

		System.out.println(FleetImprovementscreenAppear);
		Assert.assertEquals("FLEET IMPROVEMENT", FleetImprovementscreenAppear);
	
		}
		
		//Verify that Fleet Score Details screen appears on tapping "VIEW DETAILS"button present in Fleet Score card.  
		@Test(priority=4)	
	    public void FleetScoreDetailsScreenAppearsOnTappingVIEWDETAILSbutton() {	
			

			driver.findElement(By.id("com.app.cep:id/rlFleetScore")).click();
			String FleetScoreDetailsScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='FLEET SCORE DETAILS']").getText();
		

		System.out.println(FleetScoreDetailsScreenAppears);
		Assert.assertEquals("FLEET SCORE DETAILS", FleetScoreDetailsScreenAppears);
		
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
	
		}
		

		
		//Verify that DRIVER TRAINING Screen appears on tapping Register button present in Driver Training Program card 
		@Test(priority=5)	
	    public void DRIVERTRAININGScreenAppearsOnTappingRegisterButton() {	
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"REGISTER\").instance(0))");
			driver.findElement(By.id("com.app.cep:id/btnRegisterDriverTraining")).click();
			String DRIVERTRAININGScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='DRIVER TRAINING']").getText();
		

		System.out.println(DRIVERTRAININGScreenAppears);
		Assert.assertEquals("DRIVER TRAINING",DRIVERTRAININGScreenAppears);
		
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
	
		}
		
		
		//Verify that Vehicle Score Details screen appears on tapping "DETAILS" button present in front of respective vehicle in Fleet Score card.  
		@Test(priority=6)	
	    public void VehicleScoreDetailsScreenAppearsOnTappingDETAILSbutton() {	
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"FLEET POLICY FOR SERVICE\").instance(0))");
			driver.findElement(By.id("com.app.cep:id/rlFleetScore2")).click();
			String VehicleScoreDetailsScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='FLEET POLICY FOR SERVICE']").getText();
		

		System.out.println(VehicleScoreDetailsScreenAppears);
		Assert.assertEquals("FLEET POLICY FOR SERVICE", VehicleScoreDetailsScreenAppears);
		
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
	
		}
		
}
		 
	      
		
