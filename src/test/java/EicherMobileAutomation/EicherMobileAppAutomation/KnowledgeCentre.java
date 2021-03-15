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


public class KnowledgeCentre  extends base{


	//Viewing that Knowledge Centre option is present in Hamburger
		@Test(priority=1)	
	    public void KnowledgeCentreOptionIsPresentInHamburger() {	
		// driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		 driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			
		String KnowledgeCentreOptionPresentInHamburger= driver.findElement(By.id("com.app.cep:id/tvECabinate")).getText();
		

		System.out.println(KnowledgeCentreOptionPresentInHamburger);
		// Assert.assertEquals("Knowledge Centre", KnowledgeCentreOptionPresentInHamburger);
		
		driver.findElement(By.id("com.app.cep:id/tvECabinate")).click();
		}
		
		//Viewing that Vehicle option is present in Knowledge Centre in Hamburger
		@Test(priority=2)	
	    public void Vehicle_Option_Is_Present_In_Knowledge_Centre_In_Hamburger() {	
		// driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		// driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			
		String Vehicle_Option_Is_Present_In_Knowledge_Centre_In_Hamburger= driver.findElement(By.id("com.app.cep:id/tvVehicle")).getText();
		

		System.out.println(Vehicle_Option_Is_Present_In_Knowledge_Centre_In_Hamburger);
		// Assert.assertEquals("Knowledge Centre", KnowledgeCentreOptionPresentInHamburger);
		
		driver.findElement(By.id("com.app.cep:id/tvVehicle")).click();
		}
		//Verify that user is on Vehicle Screen 
				@Test(priority=3)	
			    public void Verify_that_User_Is_On_Vehicle_Screen() {	
				
				String  Verify_that_User_Is_On_Vehicle_Screen= driver.findElement(By.id("com.app.cep:id/tvHeader")).getText();
				

				System.out.println(Verify_that_User_Is_On_Vehicle_Screen);
				Assert.assertEquals("VEHICLE", Verify_that_User_Is_On_Vehicle_Screen);
				
				}
				
		//Viewing that Dashboard in Vehicle screen
		@Test(priority=4)	
	    public void Dashboard_in_Vehicle_Screen_In_Knowledge_Centre() {	
		
		String Dashboard_in_Vehicle_Screen_In_Knowledge_Centre= driver.findElement(By.id("com.app.cep:id/dashboardRadioBtn")).getText();
		

		System.out.println(Dashboard_in_Vehicle_Screen_In_Knowledge_Centre);
		Assert.assertEquals("Dashboard", Dashboard_in_Vehicle_Screen_In_Knowledge_Centre);
		
		driver.findElement(By.id("com.app.cep:id/dashboardRadioBtn")).click();
		}
		//Viewing that EATS in Vehicle screen
				@Test(priority=5)	
			    public void EATS_in_Vehicle_Screen_In_Knowledge_Centre() {	
				
				String EATS_in_Vehicle_Screen_In_Knowledge_Centre= driver.findElement(By.id("com.app.cep:id/eatsRadioBtn")).getText();
				

				System.out.println(EATS_in_Vehicle_Screen_In_Knowledge_Centre);
				Assert.assertEquals("EATS", EATS_in_Vehicle_Screen_In_Knowledge_Centre);
				
				driver.findElement(By.id("com.app.cep:id/eatsRadioBtn")).click();
				}
				//Viewing that Transmission in Vehicle screen
				@Test(priority=6)	
			    public void Transmission_in_Vehicle_Screen_In_Knowledge_Centre() {	
				
				String Transmission_in_Vehicle_Screen_In_Knowledge_Centre= driver.findElement(By.id("com.app.cep:id/transmissionRadioBtn")).getText();
				

				System.out.println(Transmission_in_Vehicle_Screen_In_Knowledge_Centre);
				Assert.assertEquals("Transmission", Transmission_in_Vehicle_Screen_In_Knowledge_Centre);
				
				driver.findElement(By.id("com.app.cep:id/transmissionRadioBtn")).click();
				driver.findElement(By.id("com.app.cep:id/ivBack")).click();
				}
		
	
}
		
