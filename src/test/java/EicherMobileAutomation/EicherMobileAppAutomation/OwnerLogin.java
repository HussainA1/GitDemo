package EicherMobileAutomation.EicherMobileAppAutomation;
import java.net.MalformedURLException;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import EicherMobileAutomation.EicherMobileAppAutomation.base;
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

import java.awt.List;
import java.io.IOException;

import static io.appium.java_client.touch.offset.ElementOption.element;


public class OwnerLogin  extends base{

	
	@Test
	
	public void OwnerloginToApp() throws SQLException, IOException 
	{
	//public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException, IOException {
		
	 String host = "localhost"; 
	 String port= "3306"; 
	 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
	 Statement s = con.createStatement(); 
	ResultSet rs = s.executeQuery("select * from CustomerDetails where ID=1");

	 while(rs.next())
	 {
		 
		 service = startServer();
		 AndroidDriver<AndroidElement>driver = Capabilities("CEP");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Login
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LOGIN\"))");
				driver.findElementByXPath("//android.widget.TextView[@text='LOGIN']").click();
			driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys(rs.getString("LOGIN_ID"));
			driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys(rs.getString("PASSWORD"));
			driver.findElement(By.id("com.app.cep:id/btnLogin")).click();
			 

			//Dashboard 
			//Quick Actionable Cards
			driver.findElement(By.id("com.app.cep:id/rlinviteFleet")).click();
			
			driver.findElement(By.id("com.app.cep:id/lllayout")).click();
			driver.findElementByXPath("//android.widget.TextView[@text='Pilot']").click();
			driver.findElement(By.id("com.app.cep:id/rlContacts")).click();
			driver.findElement(By.id("com.app.cep:id/llContacts")).click();
			driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();


			driver.findElement(By.id("com.app.cep:id/ivBack")).click();


			  //My Fleets 
			  driver.findElement(By.id("com.app.cep:id/llTotalvehicles")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			  
			  driver.findElement(By.id("com.app.cep:id/llInservice")).click();
			  driver.findElement(By.id("com.app.cep:id/Cross_IV")).click();
			  
			  driver.findElement(By.id("com.app.cep:id/llBreakdown")).click();
			  driver.findElement(By.id("com.app.cep:id/Cross_IV")).click();
			  
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TRACK IN MAP\"))").click();
				  driver.findElement(By.id("com.app.cep:id/ivBack")).click();


				//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"RESCHEDULE SERVICE\"))").click();
				//driver.findElement(By.id("com.app.cep:id/ivBack")).click();

			  //Scroll till service alerts card
			  
				//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Events\"))");

			//driver.findElement(By.id("com.app.cep:id/btnBookService")).click();
			  //driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			
			 

			  //Scroll till end 
				//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"OPERATIONAL EXCELLENCE\"))");
				
			  
			//Breakdown bottom bar
				  driver.findElement(By.id("com.app.cep:id/ivBreak")).click();
				  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();


				  //Fleet performance bottom bar
				  driver.findElement(By.id("com.app.cep:id/ivFleet")).click();
				  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();



			  //Hamburger driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  
			  //Manage Vehicle 
			  driver.findElement(By.id("com.app.cep:id/tvMangaeVehicle")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();

			  //Invite Users
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();

			  //Dealer Locator 
			  driver.findElement(By.id("com.app.cep:id/tvLocator")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();

			  //Operation Excellence 
			  driver.findElement(By.id("com.app.cep:id/tvcbop")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();

			  // Product Catalogue 
			  driver.findElement(By.id("com.app.cep:id/tvproductCat")).click();
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

			
			  //Logout 
			 driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			 driver.findElement(By.id("com.app.cep:id/tvLogout")).click();
			 driver.findElement(By.id("com.app.cep:id/txt_go_back")).click();
			  
			  //Delete App 
			  driver.removeApp("com.app.cep");
			 
		  }
	    }
      }
	
