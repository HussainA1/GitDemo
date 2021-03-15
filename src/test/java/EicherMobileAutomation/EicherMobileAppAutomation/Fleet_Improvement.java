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


public class Fleet_Improvement  extends base{


	//Clicking on Fleet Improvement Icon present in Bottom Icons
	@Test(priority=1)	
	public void Clicking_On_Fleet_Improvement_Icon_Present_In_Bottom_Icons() 
	{	
		//driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		//driver.findElement(By.id("com.app.cep:id/ivNoti1")).click(); // For closing the hamburger panel.
		driver.findElement(By.id("com.app.cep:id/rlMore")).click();

		driver.findElement(By.id("com.app.cep:id/tvFleetImprovement")).click();
	}


	// Verify that "Fleet Improvement" is the updated page
	@Test(priority=2)
	public void Fleet_Improvement_Is_The_Updated_Page() throws InterruptedException
	{
		String Fleet_Improvement_Is_The_Updated_Page= driver.findElement(By.id("com.app.cep:id/tvUserName")).getText();
		Assert.assertEquals("FLEET IMPROVEMENT",Fleet_Improvement_Is_The_Updated_Page);
	}

	//Clicking On "Discuss With Eicher Team" Buttom
	@Test(priority=3)	
	public void Clicking_On_Discuss_With_Eicher_Team_Button() throws InterruptedException 
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Testimonials\").instance(0))");
		driver.findElement(By.id("com.app.cep:id/actionEnroll")).click();
		Thread.sleep(5000);
	}

	// Verify that "Fleet Improvement Dashboard" is the updated page
	@Test(priority=4)
	public void Fleet_Improvement_Dashboard_Is_The_Updated_Page() throws InterruptedException
	{
		String Fleet_Improvement_Dashboard_Is_The_Updated_Page= driver.findElement(By.id("com.app.cep:id/tvUserName")).getText();
		Assert.assertEquals("FLEET IMPROVEMENT",Fleet_Improvement_Dashboard_Is_The_Updated_Page);
	}

	// Clicking_On_View_Details_Button_Of_Overall_Fleet_Score_Card
	@Test(priority=5)
	public void Clicking_On_View_Details_Button_Of_Overall_Fleet_Score_Card() throws InterruptedException
	{
		driver.findElement(By.id("com.app.cep:id/rlFleetScore")).click();	
		Thread.sleep(3000);
	}

	// Verifing_UpdatedScreen_DefaultTab_VehicleType_In_FleetScoreDetail
	@Test(priority=6)
	public void Verifing_UpdatedScreen_DefaultTab_VehicleType_In_FleetScoreDetail()
	{
		//Verify that updated screen is "FLEET SCORE CARD"
		String UpdatedScreen_In_FleetScoreDetail = driver.findElement(By.xpath("//android.widget.TextView[@text='FLEET SCORE DETAILS']")).getText();
		Assert.assertEquals(UpdatedScreen_In_FleetScoreDetail, "FLEET SCORE DETAILS");

		//Verify that Default tab is "Overall"
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Overall']")).isEnabled());

		// Verify that default vehicle type is "All Vehicle"
		String Default_VehicleType_Is_AllVehicle = driver.findElement(By.id("com.app.cep:id/spnrVeh1")).getText();
		Assert.assertEquals(Default_VehicleType_Is_AllVehicle,"All Vehicles");

	}

	//Selecting_Pilots_From_PilotList_On_FleetScoreCard_Screen
	@Test(priority=7)
	public void Selecting_Pilots_From_PilotList_On_FleetScoreCard_Screen() throws InterruptedException
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");
		driver.findElement(By.id("com.app.cep:id/rdYellow")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.app.cep:id/rdBlue")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("com.app.cep:id/ivSearchStart")).click(); // Clicking on searching icon
		driver.findElement(By.id("com.app.cep:id/etSearchPiolot")).sendKeys("TestPilot10");

		// Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) For Understanding
		Vertical_Swipe_Using_Percentage(0.5,0.7,0.5,0.3);
		driver.findElement(By.id("com.app.cep:id/btnInvite")).click(); // Clicking on "Details"

	}

	// Verifying_ScreenName_And_PilotName_On_Updated_Screen_After_Selecting_Pilot
	@Test(priority=8)
	public void Verifying_ScreenName_And_PilotName_On_Updated_Screen_After_Selecting_Pilot() throws InterruptedException
	{
		//Verifying Updated Screen
		Thread.sleep(2000);
		String ScreenName_On_Updated_Screen_After_Selecting_Pilot = driver.findElement(By.id("com.app.cep:id/tvUserName")).getText();
		Assert.assertEquals(ScreenName_On_Updated_Screen_After_Selecting_Pilot, "PILOT SCORE DETAILS");

		//Verifying Pilot Name
		String PilotName_On_Updated_Screen_After_Selecting_Pilot = driver.findElement(By.id("com.app.cep:id/tvUserName11")).getText();
		Assert.assertEquals(PilotName_On_Updated_Screen_After_Selecting_Pilot, "TestPilot10");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		// Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) For Understanding
		Vertical_Swipe_Using_Percentage(0.5,0.5,0.5,0.67);		

		driver.findElement(By.xpath("//android.widget.TextView[@text='Trip Score']")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

		driver.findElement(By.id("com.app.cep:id/ivSearchClose")).click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Fuel\").instance(0))");

	}


	//Verifying_Parameters_Of_Fuel_Tab_In_FleetScoreDetails
	@Test(priority=9)
	public void Verifying_Parameters_Of_Fuel_Tab_In_FleetScoreDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='Fuel']")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElement(By.id("com.app.cep:id/btnInvite")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Idling Score\").instance(0))").click();
		Thread.sleep(2000);

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Harsh Acceleration\").instance(0))").click();
		Thread.sleep(2000);

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Harsh Acceleration\").instance(0))");

		AndroidElement startElement=driver.findElement(By.id("com.app.cep:id/rbHarshAcc"));
		AndroidElement endElement =driver.findElement(By.id("com.app.cep:id/rbCruiseScore"));

		// Horizontal_Swipe_Using_Web_Element(AndroidElement startElement, AndroidElement endElement ) FOr Understanding
		Horizontal_Swipe_Using_Web_Element(startElement, endElement);

		driver.findElement(By.id("com.app.cep:id/rbHarshBreak")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Harsh Acceleration\").instance(0))");

		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();  //For back button
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."  //For Scrolling Up
				+ "scrollIntoView(new UiSelector().textContains(\"Overall\").instance(0))");

	}

	//Verifying_Parameters_Of_Trip_Tab_In_FleetScoreDetails
	@Test(priority=10)
	public void Verifying_Parameters_Of_Trip_Tab_In_FleetScoreDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.TextView[@text='Trip']")).click();

		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElement(By.id("com.app.cep:id/btnInvite")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Over Speeding\").instance(0))").click();
		Thread.sleep(2000);

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Night Driving\").instance(0))").click();
		Thread.sleep(2000);

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Night Driving\").instance(0))");

		AndroidElement startElement=driver.findElement(By.id("com.app.cep:id/rbNightDrive"));
		AndroidElement endElement =driver.findElement(By.id("com.app.cep:id/rbNonStopDrive"));

		// Horizontal_Swipe_Using_Web_Element(AndroidElement startElement, AndroidElement endElement ) FOr Understanding
		Horizontal_Swipe_Using_Web_Element(startElement, endElement);

		driver.findElement(By.id("com.app.cep:id/rbOverStop")).click();
		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Change from Last week score\").instance(0))");

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().textContains(\"Over Stoppage\").instance(0))");

		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();  //For back button
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."  //For Scrolling Up
				+ "scrollIntoView(new UiSelector().textContains(\"Overall\").instance(0))").click();;

	}

	// Selecting_VehicleType_As_Model/Cluster
	@Test(priority=11)
	public void Selecting_VehicleType_As_Model_Cluster() throws InterruptedException
	{

		driver.findElement(By.id("com.app.cep:id/spnrVeh1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.app.cep:id/spnrVeh1")).click();

		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

	}

	//Registering_Driver_Training_Program_On_Fleet_Improvement
	@Test(priority=12)
	public void Registering_Driver_Training_Program_On_Fleet_Improvement() throws InterruptedException
	{

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."  //For Scrolling Up
				+ "scrollIntoView(new UiSelector().textContains(\"REGISTER\").instance(0))").click();
		//Updated Screen should be "Driver Training"
		String ScreenTitle= driver.findElement(By.xpath("//android.widget.TextView[@text='DRIVER TRAINING']")).getText();
		Assert.assertEquals(ScreenTitle, "DRIVER TRAINING");

		//Filling field on the screen

		driver.findElement(By.id("com.app.cep:id/etDriverCount")).sendKeys("2");  //No. of Drivers to be trained

		//Training Location
		driver.findElement(By.id("com.app.cep:id/spnrStatePS")).click();  //State DropDown
		Thread.sleep(2000);
		driver.findElement(By.id("com.app.cep:id/spnrStatePS")).click();  //Closing DropDown
		driver.findElement(By.id("com.app.cep:id/etAddress")).sendKeys("Please Type Your Address");  //Filling Address

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."  //For Scrolling Up
				+ "scrollIntoView(new UiSelector().textContains(\"SEND REQUEST\").instance(0))");

		driver.findElement(By.id("com.app.cep:id/next")).click();
		java.util.List<AndroidElement> dates= driver.findElements(By.className("android.widget.CheckedTextView"));  //For Calender
		int i =0;
		while( i<dates.size())
		{
			String date=dates.get(i).getText();
			if(date.equals("10"))
			{
				for (int j=0;j<10;j++)
				{
					dates.get(i).click();
					i++; 
				}
				break;
			}
			i++;
		}

		driver.findElement(By.id("com.app.cep:id/actionSendReq")).click();  //Send Requeast Button

		driver.findElement(By.id("android:id/button2")).click(); //

		driver.findElement(By.id("com.app.cep:id/ivMenu")).click(); //Back

	}

	//Verifying_FleetPolicyForService_On_FleetImprovement
	@Test(priority=13)
	public void FleetPolicyForService_On_FleetImprovement()
	{
		driver.findElement(By.id("com.app.cep:id/tvReqEdit")).click();
		driver.findElement(By.id("com.app.cep:id/tvOkkam")).click();

		driver.findElement(By.id("com.app.cep:id/rlFleetScore2")).click();

		//Screen Title Should Be FLEET POLICY FOR SERVICE
		String Screen_Title=driver.findElement(By.xpath("//android.widget.TextView[@text='FLEET POLICY FOR SERVICE']")).getText();
		Assert.assertEquals(Screen_Title, "FLEET POLICY FOR SERVICE");

		//Group Details should be default tab
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Group Details']")).isEnabled());

		// Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) For Understanding
		Vertical_Swipe_Using_Percentage(0.5,0.5,0.5,0.3);

		driver.findElement(By.id("com.app.cep:id/tvReqEditFPS")).click();

		driver.findElement(By.id("com.app.cep:id/tvOkkam")).click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."  //For Scrolling Up
				+ "scrollIntoView(new UiSelector().textContains(\"Parameters\").instance(0))").click();
		//Toggle Switch
		Assert.assertFalse(driver.findElement(By.id("com.app.cep:id/swP1")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("com.app.cep:id/swP2")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("com.app.cep:id/swP3")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("com.app.cep:id/swP4")).isSelected());
		Assert.assertFalse(driver.findElement(By.id("com.app.cep:id/swP5")).isSelected());

		driver.findElement(By.id("com.app.cep:id/tvReqEditFPS")).click();
		driver.findElement(By.id("com.app.cep:id/tvOkkam")).click();
		
        //Returning to Home Screen
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		driver.findElement(By.id("com.app.cep:id/llClose")).click();
	}
}