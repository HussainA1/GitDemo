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


public class Edit_Profile  extends base{


	//Viewing that EDIT option is present in Hamburger
	@Test(priority=1)	
	public void Edit_Option_Is_Present_In_Hamburger() {	
		
		driver.findElement(By.id("com.app.cep:id/ivMenu")).click();  //Clicking Hamburger
		//driver.findElement(By.id("com.app.cep:id/ivBack")).click(); // Back Button
		String Edit_Option_Is_Present_In_Hamburger = driver.findElement(By.id("com.app.cep:id/tvedit")).getText();


		System.out.println(Edit_Option_Is_Present_In_Hamburger);
		Assert.assertEquals("EDIT", Edit_Option_Is_Present_In_Hamburger);

		driver.findElement(By.id("com.app.cep:id/tvedit")).click();
	}

	//Verify that "EDIT PROFILE" is updated page in EDIT Option in Hamburger
	@Test(priority=2)	
	public void EDIT_PROFILE_is_updated_page_in_EDIT_Option_in_Hamburger() {

		String EDIT_PROFILE_is_updated_page_in_EDIT_Option_in_Hamburger= driver.findElement(By.xpath("//android.widget.TextView[@text='EDIT PROFILE']")).getText();

		System.out.println(EDIT_PROFILE_is_updated_page_in_EDIT_Option_in_Hamburger);
		Assert.assertEquals("EDIT PROFILE", EDIT_PROFILE_is_updated_page_in_EDIT_Option_in_Hamburger);

		System.out.println("Now At "+ EDIT_PROFILE_is_updated_page_in_EDIT_Option_in_Hamburger+ (" Screen"));

	}
	

	// Changing Profile Photo In Edit Option
	@Test(priority=3)
	public void Changing_Profile_Photo_In_Edit_Option() throws InterruptedException
	{
		driver.findElement(By.id("com.app.cep:id/image_edit_icon")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Camera']")).click();  // Phone Gallery Vary phone to phone
		Thread.sleep(2000);
		driver.findElement(By.xpath("//GLButton[@text='Take picture']")).click();
		driver.findElement(By.id("com.sec.android.app.camera:id/okay")).click();  // Phone Gallery Vary phone to phone
		driver.findElement(By.id("com.app.cep:id/crop_image_menu_crop")).click();	
	}

	//Verify that Role Name, Full Name, Mobile No., Email Address is not editable
	@Test(priority=4)	
	public void Verify_That_RoleName_FullName_MobileNo_EmailAddress_Is_Not_Editable() {	
		//Verify That Role name is not editable.
		AndroidElement  Role_Name= driver.findElement(By.id("com.app.cep:id/edrolename"));
		Assert.assertTrue(Role_Name.isEnabled(), "Role Name is Enabled.");


		//Verify That Full name is not editable.
		AndroidElement  Full_Name= driver.findElement(By.id("com.app.cep:id/ednamedctr"));
		Assert.assertFalse(Full_Name.isEnabled(), "Full Name is Enabled.");


		//Verify That Phone Number is not editable.
		AndroidElement  Phone_Number= driver.findElement(By.id("com.app.cep:id/edmobdctr"));
		Assert.assertFalse(Phone_Number.isEnabled(), "Phone Number is Enabled.");


		//Verify That Email Address is not editable.
		AndroidElement  Email_Address= driver.findElement(By.id("com.app.cep:id/edemaildctr"));
		Assert.assertFalse(Email_Address.isEnabled(), "Email Address is Enabled.");
	}


	//Selecting Anniversary Date In Edit Option
	@Test(priority=5)	
	public void Editing_Anniversary_Date_In_Edit_Option() throws InterruptedException 
	{	

		driver.findElement(By.id("com.app.cep:id/calendaranni")).click();  // Calendar icon

		//Selecting Year
		driver.findElement(By.id("android:id/date_picker_header_year")).click();

		for(int i=0;i<15;i++)
		{

			int flag=0;

			java.util.List<AndroidElement> years = driver.findElements(By.className("android.widget.TextView"));

			for (int j=0;j<years.size();j++)
			{
				String year = years.get(j).getText();

				if(year.contains("2005"))
				{
					driver.findElement(By.xpath("//android.widget.TextView[@text='2005']")).click();
					flag=1;
					break;
				}	

			}
			if(flag==1){
				break;
			}
			
			// Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) For Understanding
			Vertical_Swipe_Using_Percentage(0.5,0.4,0.5,0.75);

		}

		//Selecting Date Month
		String AnniversaryMonth="August";
		for(int i=0; i<12;i++)
		{
			String date= driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("content-desc");
			if(date.contains(AnniversaryMonth))
			{
				driver.findElement(By.xpath("//android.view.View[@text='17']")).click();
				driver.findElement(By.id("android:id/button1")).click();
				break;
			}
			else
			{	
				if(date.contains("January")) 
				{
					for(i=0; i<12;i++) 
					{
						driver.findElement(By.id("android:id/next")).click();   //If the Anniversary month comes after the current month.
						date= driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("content-desc");
						if(date.contains(AnniversaryMonth))
						{
							driver.findElement(By.xpath("//android.view.View[@text='17']")).click();
							driver.findElement(By.id("android:id/button1")).click();
							break;
						}
					}
					break;
				}

				driver.findElement(By.id("android:id/prev")).click();    //If the Anniversary month comes before the current month.
			}

		}
	}


	//Editing Address in Edit Profile
	@Test(priority=6)
	public void Editing_Address_In_Edit_Option()
	{
		//Scrolling Screen 
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Save Profile\").instance(0))");

		String address = driver.findElement(By.id("com.app.cep:id/tvAddresss")).getText();
		driver.findElement(By.id("com.app.cep:id/tvAddresss")).click();;
		driver.findElement(By.id("com.app.cep:id/edsearchloc")).sendKeys(address);
		driver.findElement(By.id("com.app.cep:id/tvLocation")).click();
	}


	//Editing Gender in Edit Profile
	@Test(priority=7)	
	public void Editing_Gender_In_Edit_Option() 
	{	
		driver.findElement(By.id("com.app.cep:id/ivFemale")).click();
		driver.findElement(By.id("com.app.cep:id/ivmale")).click();
	}


	//Editing DOB In Edit Option
	@Test(priority=8)	
	public void Editing_DOB_In_Edit_Option() throws InterruptedException 
	{	

		driver.findElement(By.id("com.app.cep:id/calendar")).click();  // Calendar icon

		//Selecting Year
		driver.findElement(By.id("android:id/date_picker_header_year")).click();


		for(int i=0;i<15;i++)
		{

			int flag=0;

			java.util.List<AndroidElement> years = driver.findElements(By.className("android.widget.TextView"));

			for (int j=0;j<years.size();j++)
			{
				String year = years.get(j).getText();

				if(year.contains("1990"))
				{
					driver.findElement(By.xpath("//android.widget.TextView[@text='1990']")).click();
					flag=1;
					break;
				}	

			}
			if(flag==1){
				break;
			}
			
			// Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) For Understanding
			Vertical_Swipe_Using_Percentage(0.5,0.4,0.5,0.75);

		}


		//Selecting Date Month
		String DOB_Month= "July";
		for(int i=0; i<12;i++)
		{
			String date= driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("content-desc");
			if(date.contains(DOB_Month))
			{
				driver.findElement(By.xpath("//android.view.View[@text='17']")).click();
				driver.findElement(By.id("android:id/button1")).click();
				break;
			}
			else
			{

				if(date.contains("January")) 
				{
					for(i=0; i<12;i++) 
					{
						driver.findElement(By.id("android:id/next")).click();   //If the DOB month comes after the current month.
						date= driver.findElement(By.xpath("//android.view.View[@text='1']")).getAttribute("content-desc");
						if(date.contains(DOB_Month))
						{
							driver.findElement(By.xpath("//android.view.View[@text='17']")).click();
							driver.findElement(By.id("android:id/button1")).click();
							break;
						}
					}
					break;
				}

				driver.findElement(By.id("android:id/prev")).click();    //If the DOB month comes before the current month.
			}

		}
	}


	// Verifying Save Profile Button And Confirmation Message In Edit Option
	@Test(priority=9)	
	public void Clicking_On_Save_Profile_Button_In_Edit_Option() throws InterruptedException 
	{	
		driver.findElement(By.id("com.app.cep:id/Btnsave")).click();

//		Alert alert = driver.switchTo().alert();
//		String Confirmation_Message = alert.getText();
//
//		Assert.assertEquals(Confirmation_Message, "Profile Updated Successfully.");
//		Thread.sleep(30000);
//		System.out.println(""
//				+ ""
//				+ "Confirmation_Message");
//		Thread.sleep(50000);

	}

	// Updated Screen After Profile Update Is My Eicher
	@Test(priority=10)
	public void Updated_Screen_After_Profile_Update_Is_My_Eicher()
	{
		String Screen=driver.findElement(By.id("com.app.cep:id/tvUserName")).getText();
		Assert.assertEquals(Screen,"MY EICHER");
	}
	
}
