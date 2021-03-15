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

import org.openqa.selenium.Alert;
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


public class Fleet_Monitor  extends base
{
	//Selecting_ViewType_And_Duration_On_FleetDashboard
	public void Selecting_ViewType_And_Duration_On_FleetDashboard(String ViewType, String Duration)
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='All Vehicles']")).click(); // Clicking on View Type Dropdown
		driver.findElement(By.xpath("//android.widget.TextView[@text=ViewType]")).click();   // Selecting view type
		
		driver.findElement(By.xpath("//android.widget.TextView[@id='com.app.cep:id/durationTextView'")).click();  //CLicking on Duration Dropdown
		driver.findElement(By.xpath("//android.widget.TextView[@text=Duration]")).click();  //Selecting Duration
	}
	
	// //Clicking on Fleet Monitor Icon present in Bottom Icons
	@Test(priority=1)	
	public void Clicking_On_Fleet_Monitor_Icon_Present_In_Bottom_Icons() 
	{	
		//driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		//driver.findElement(By.id("com.app.cep:id/ivNoti1")).click(); // For closing the hamburger panel.

		driver.findElement(By.id("com.app.cep:id/llFleetMonitoring")).click();
	}


	// Verifying_UpdatedScreen_DefaultTab_DefaultViewType_DefaultDuration_On_FleetDashboard
	@Test(priority=2)
	public void Verifying_UpdatedScreen_DefaultTab_DefaultViewType_DefaultDuration_On_FleetDashboard() throws InterruptedException
	{
		//Verify that updated screen is "FLEET Monitor"
		String Fleet_Dashboard_Is_The_Updated_Page= driver.findElement(By.id("com.app.cep:id/tvHeader")).getText();
		Assert.assertEquals("FLEET DASHBOARD",Fleet_Dashboard_Is_The_Updated_Page);
		
		//Verify that Default tab is "Vehicle Usage"
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.RadioButton[@text='Vehicle Usage']")).isEnabled());

		// Verify that default view type is "All Vehicles"
		String Default_ViewType_Is_AllVehicles = driver.findElement(By.id("com.app.cep:id/filterByTextView")).getText();
		Assert.assertEquals(Default_ViewType_Is_AllVehicles,"All Vehicles");
		
		// Verify that default Duration  is "Last 1 day"
		String Default_Duration_Is_Last1Day =driver.findElement(By.id("com.app.cep:id/durationTextView")).getText();
		Assert.assertEquals(Default_Duration_Is_Last1Day, "Last 1 day");
	}
	
	// Viewing_PilotPerformance_By_Selecting_Various_ViewTypes
	@Test(priority=3)
	public void Viewing_PilotPerformance_By_Selecting_Various_ViewTypes() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Clicking on View Type Dropdown
		
		//"View By Vehicle" view type
		driver.findElement(By.xpath("//android.widget.TextView[@text='View by Vehicle']")).click();   // Selecting view type
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/searchByVINEditText']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/searchByVINEditText']")).sendKeys("RJ14GK3451 (MC2S3GRC0JK058846)");
		driver.findElement(By.xpath("//android.widget.TextView[@text='RJ14GK3451 (MC2S3GRC0JK058846)']")).click();
		
		for(int a=0;a<3;a++)
		{
		Vertical_Swipe_Using_Percentage(0.5,0.8,0.5,0.2);
		}
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='View Pilot Performance']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='View Pilot Performance']")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().textContains(\"Vehicle Usage\").instance(0))");
		
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/ivCamera']")).click();

		
		//"View By Pilot" view type
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Clicking on View Type Dropdown
		driver.findElement(By.xpath("//android.widget.TextView[@text='View by Pilot']")).click();   // Selecting view type
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/searchByVINEditText']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/searchByVINEditText']")).sendKeys("Test Pilot12");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Test Pilot12']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/ivCamera']")).click();
		
		//"All Vehicles" view type
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Clicking on View Type Dropdown
		driver.findElement(By.xpath("//android.widget.TextView[@text='All Vehicles']")).click();   // Selecting view type
	}
	
	// Viewing_PilotPerformance_By_Selecting_Various_Duration
		@Test(priority=4)
		public void Viewing_PilotPerformance_By_Selecting_Various_Duration()
		{
	        //Duration is "Last 7 day"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Clicking on Duration Dropdown
			driver.findElement(By.xpath("//*[@text='Last 7 day']")).click();
			
			
			//Duration is "Last 10 days"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Clicking on Duration Dropdown
			driver.findElement(By.xpath("//*[@text='Last 10 days']")).click();
			
			//Duration is "Specific Date"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Clicking on Duration Dropdown
			driver.findElement(By.xpath("//*[@text='Specific Date']")).click();
			driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/imgVNavLeft']")).click();
			String Specifie_Date[]=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/tvYearTitle']")).getText().split(" ");
			driver.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
			//Verifying "Specific Date"
			String month=Specifie_Date[0];
			month=month.substring(0,3);
			String year=Specifie_Date[1];
			String Displayed_Specifie_Date=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).getText();
			Assert.assertEquals(Displayed_Specifie_Date, "17 "+month+" "+year);
			

			//Duration is "Date Range"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Clicking on Duration Dropdown
			driver.findElement(By.xpath("//*[@text='Date Range']")).click();
			driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/imgVNavLeft']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='8']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='17']")).click();
			String Date_Range[]=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/tvYearTitle']")).getText().split(" ");
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
			//Verifying "Specific Date"
			month=Date_Range[0];
			month=month.substring(0,3);
			year=Date_Range[1];
			String Displayed_Date_Range=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).getText();
			Assert.assertEquals(Displayed_Date_Range, "08 "+month+" - "+"17 "+month+" "+year);
		}
		
		// Switching_To_Fuel_Tab_On_FleetDashboard
		@Test(priority=5)
		public void Switching_To_Fuel_Tab_On_FleetDashboard() throws InterruptedException
		{
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Fuel']")).click();
			
			// For "View Type"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Opening View Type Dropdown
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Closing View Type Dropdown
			
			//For "Duration"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Opening Duration Dropdown
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Closing Duration Dropdown
			
			for(int a=0;a<3;a++)
			{
			Vertical_Swipe_Using_Percentage(0.5,0.8,0.5,0.2);
			}
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='View Pilot Performance']")).click(); //Opening Performance Card
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='View Pilot Performance']")).click();//Closing Performance Card
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
					+ ".scrollIntoView(new UiSelector().textContains(\"Vehicle Usage\").instance(0))");
		}
		

		// Switching_To_DrivingBehaviour_Tab_On_FleetDashboard
		@Test(priority=6)
		public void Switching_To_DrivingBehaviour_Tab_On_FleetDashboard() throws InterruptedException
		{
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Driving Behaviour']")).click();
			
			// For "View Type"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Opening View Type Dropdown
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/filterByTextView']")).click(); // Closing View Type Dropdown
			
			//For "Duration"
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Opening Duration Dropdown
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Closing Duration Dropdown
			
			for(int a=0;a<3;a++)
			{
			Vertical_Swipe_Using_Percentage(0.5,0.8,0.5,0.2);
			}
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='View Pilot Performance']")).click(); //Opening Performance Card
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.TextView[@text='View Pilot Performance']")).click();//Closing Performance Card
			
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
					+ ".scrollIntoView(new UiSelector().textContains(\"Driving Behaviour\").instance(0))");
			
			//Closing Fleet Monitor
			driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.app.cep:id/ivBack']")).click();
		}
	
	
	
//	// Clicking_On_View_Details_Button_Of_Overall_Fleet_Score_Card
//		@Test
//		public void Clicking_On_View_Details_Button_Of_Overall_Fleet_Score_Card() throws InterruptedException
//		{
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			
//			//Scrolling downward
//			int flag=0;
//			while(flag<3)
//			{
//				// Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) For Understanding
//				Vertical_Swipe_Using_Percentage(0.5,0.8,0.5,0.2);
//				flag++;	
//			}
//			
//			//Scrolling Horizontally in card
//			AndroidElement startElement=driver.findElement(By.id("com.app.cep:id/totalTimeTv"));
//			AndroidElement endElement =driver.findElement(By.id("com.app.cep:id/currentDistanceTv"));
//			// Horizontal_Swipe_Using_Web_Element(AndroidElement startElement, AndroidElement endElement ) FOr Understanding
//			Horizontal_Swipe_Using_Web_Element(startElement, endElement);
//			
//			// Scrolling Horizontally Again
//			startElement=driver.findElement(By.id("com.app.cep:id/totalFuelConsumedTv"));
//			endElement =driver.findElement(By.id("com.app.cep:id/totalTimeTv"));
//			// Horizontal_Swipe_Using_Web_Element(AndroidElement startElement, AndroidElement endElement ) FOr Understanding
//			Horizontal_Swipe_Using_Web_Element(startElement, endElement);
//			
//		}
//	
}
