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


public class Help_Support  extends base{


	//@Test(dataProvider="InputData",dataProviderClass=TestData.class)
		@BeforeClass
		public void OwnerloginToApp() throws SQLException, IOException 
		{
			 String host = "localhost"; 
			 String port= "3306"; 
			 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
			 Statement s = con.createStatement(); 
			ResultSet rs = s.executeQuery("select * from CustomerDetails where ID=10 ");

			 while(rs.next())
			 {
				service = startServer();
				 AndroidDriver<AndroidElement>driver = Capabilities("CEP");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//Login
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Login\"))");
					driver.findElementByXPath("//android.widget.TextView[@text='Login']").click();
					driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys(rs.getString("LOGIN_ID"));
					driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys(rs.getString("PASSWORD"));
					driver.findElement(By.id("com.app.cep:id/btnLogin")).click();
					
					 	}
		}
		
		//Viewing that Help & Support option is present in Hamburger
				@Test(priority=1)	
			    public void HelpSupportIsPresentInHamburger() {	
				  // driver.findElement(By.id("com.app.cep:id/ivBack")).click();

				driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
				
				String ComplaintModuleOptionPresentInHamburger= driver.findElement(By.id("com.app.cep:id/tvComplaintModule")).getText();
				

				System.out.println(ComplaintModuleOptionPresentInHamburger);
				Assert.assertEquals("Help & Support", ComplaintModuleOptionPresentInHamburger);
				
				driver.findElement(By.id("com.app.cep:id/tvComplaintModule")).click();
				}
				
				//Verify that Complaint List screen appears on tapping  Complaint Module option is present in Hamburger.  
				@Test(priority=2)	
			    public void Verify_that_Complaint_List_screen_appears_on_tapping_Complaint_Module_option_present_in_Hamburger() {	
				
				String VerifyComplaint_List_screen_appears_on_tapping_Complaint_Module_option_present_in_Hamburger= driver.findElement(By.id("com.app.cep:id/toolbar")).getText();
				

				System.out.println(VerifyComplaint_List_screen_appears_on_tapping_Complaint_Module_option_present_in_Hamburger);
				Assert.assertEquals("COMPLAINT LIST", VerifyComplaint_List_screen_appears_on_tapping_Complaint_Module_option_present_in_Hamburger);
				
				}
				
				//Verify that two sections i.e. Pending and Resolved are present on the Complaint List screen 
				
				@Test(priority=3)	
			    public void Verify_that_two_sections_Pending_and_Resolved_are_present_in_Complaint_sreen() 
				{
					
					String Verify_that_Pending_sections_Is_Present = driver.findElement(By.id("com.app.cep:id/pending_LL")).getText();
					

					System.out.println(Verify_that_Pending_sections_Is_Present);
					Assert.assertEquals("Pending", Verify_that_Pending_sections_Is_Present);
					
                    String Verify_that_Resolved_sections_Is_Present = driver.findElement(By.id("com.app.cep:id/resolved_LL")).getText();
					

					System.out.println(Verify_that_Resolved_sections_Is_Present);
					Assert.assertEquals("Resolved", Verify_that_Resolved_sections_Is_Present);
					
			  }
				//Verify that user should able to raise new complaint through Pending section

				@Test(priority=4)	
			    public void Verify_that_user_should_able_to_raise_new_complaint_through_Pending_section() 
				{
					
					
			  }

}

		 
	      
		
