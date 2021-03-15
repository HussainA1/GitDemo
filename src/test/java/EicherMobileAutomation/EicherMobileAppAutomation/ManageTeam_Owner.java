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


public class ManageTeam_Owner  extends base{
	
	


	//@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	@BeforeClass
	public void OwnerloginToApp() throws SQLException, IOException, InterruptedException 
	{
		String host = "localhost"; 
		String port= "3306"; 
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","1234");
		Statement s = con.createStatement(); 
		ResultSet rs = s.executeQuery("select * from CustomerDetails where ID=11");

		while(rs.next())
		{
			service = startServer();
			AndroidDriver<AndroidElement>driver = Capabilities("CEP");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElement(By.id("com.app.cep:id/tvSkip")).click();  // For skipping tutorial.

			//Login
			//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Login\"))");
			//driver.findElementByXPath("//android.widget.TextView[@text='Login']").click();
			driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys(rs.getString("LOGIN_ID"));
			driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys(rs.getString("PASSWORD"));
			driver.findElement(By.id("com.app.cep:id/btnLogin")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.app.cep:id/btnLogin")).click();           // For skipping tutorial.
			driver.findElement(By.id("com.app.cep:id/layoutFirst")).click();        // For skipping tutorial.
			driver.findElement(By.id("com.app.cep:id/layoutSecond")).click();       // For skipping tutorial.
			break;
		}
	}


	//Selecting a Role & assigning a contact person from hamburger
	
	@Test
	public void hello()
	{
		System.out.println("Hola");
		
	}


	@Test(priority=1)		
	public void Manage_Team_Hamburger() throws InterruptedException {	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Clicking on Hamburger
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		// Clicking on "Manage team" in hamburger.
		driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();
		//Clicking on (+)symbol on Manage Team Screen.
		driver.findElement(By.id("com.app.cep:id/add_fab")).click();
		//Clicking on Role field.
		driver.findElement(By.id("com.app.cep:id/lllayout")).click();
		//Clicking on Manager from drop down.
		driver.findElementByXPath("//android.widget.TextView[@text='Manager']").click();
		
		//Enter the Mobile number, first name and last name manually, than clear these 
		driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("123456789012345");
		driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("First Name");
		driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("Last Name");
		driver.findElement(By.id("com.app.cep:id/edMobile")).clear();
		driver.findElement(By.id("com.app.cep:id/edfname")).clear();
		driver.findElement(By.id("com.app.cep:id/edlname")).clear();
		driver.findElement(By.id("com.app.cep:id/rlContacts")).click();   //Back Button
		driver.findElement(By.id("com.app.cep:id/edsearchContact")).sendKeys("Test");
		driver.findElement(By.id("com.app.cep:id/llContacts")).click();
		driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
		//driver.findElement(By.id("com.app.cep:id/tvOkk")).click();   //OK in Confirmation Box
		driver.findElement(By.id("com.app.cep:id/ivBack")).click();
	}


	//Resending an Invite

	@Test(priority=2)	
	public void Resending_An_Invite() {	

		driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"mz\").instance(0))");

		driver.findElement(By.id("com.app.cep:id/tvresend")).click();

		driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
	}

	//Assign Fleet to the designated users

	@Test(priority=3)	
	public void Assign_Fleet_To_The_Designated_Users_Manager() throws SQLException {	

		String host = "localhost"; 
		String port= "3306"; 
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
		Statement s = con.createStatement(); 
		ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=6 ");

		while(rs.next())
		{
			driver.findElement(By.id("com.app.cep:id/llowner_manager")).click();

			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"f\").instance(0))");

			driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
			driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
			driver.findElement(By.id("com.app.cep:id/iv")).click();
			driver.findElement(By.id("com.app.cep:id/tvdone")).click();

			String AssignFleetToTheDesignatedUsersManagerPopUp=driver.findElementByXPath("//android.widget.TextView[@text='Vehicle Assigned Successfully.']").getText();

			System.out.println(AssignFleetToTheDesignatedUsersManagerPopUp);

			Assert.assertEquals("Vehicle Assigned Successfully.",AssignFleetToTheDesignatedUsersManagerPopUp);
			driver.findElement(By.id("com.app.cep:id/tvOkk")).click();

		}
	}
	@Test(priority=4)		
	public void Unassign_Fleet_To_The_Designated_Users_Manager() throws SQLException {	

		String host = "localhost"; 
		String port= "3306"; 
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
		Statement s = con.createStatement(); 
		ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=6");

		while(rs.next())
		{
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"f\").instance(0))");

			driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
			//Search
			driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
			driver.findElement(By.id("com.app.cep:id/iv")).click();
			driver.findElement(By.id("com.app.cep:id/tvdone")).click();

			String UnassignFleetToTheDesignatedUsersManagerPopUp=driver.findElementByXPath("//android.widget.TextView[@text='Vehicle Unassigned Successfully.']").getText();

			System.out.println(UnassignFleetToTheDesignatedUsersManagerPopUp);

			Assert.assertEquals("Vehicle Unassigned Successfully.",UnassignFleetToTheDesignatedUsersManagerPopUp);
			driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
			driver.findElement(By.id("com.app.cep:id/ivBack")).click();

		}
	}


}




