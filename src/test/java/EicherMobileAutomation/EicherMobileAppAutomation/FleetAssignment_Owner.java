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


public class FleetAssignment_Owner  extends base{


	//@Test(dataProvider="InputData",dataProviderClass=TestData.class)
		@BeforeClass
		public void OwnerloginToApp() throws SQLException, IOException 
		{
			 String host = "localhost"; 
			 String port= "3306"; 
			 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
			 Statement s = con.createStatement(); 
			ResultSet rs = s.executeQuery("select * from CustomerDetails where ID=11");

			 while(rs.next())
			 {
				service = startServer();
				 AndroidDriver<AndroidElement>driver = Capabilities("CEP");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					//Login
					//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Login\"))");
					//driver.findElementByXPath("//android.widget.TextView[@text='Login']").click();
					driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys(rs.getString("LOGIN_ID"));
					driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys(rs.getString("PASSWORD"));
					driver.findElement(By.id("com.app.cep:id/btnLogin")).click();

					
					 	}
		}
		
	
		   //Selecting a Role & assigning a contact person from dashboard

		@Test(priority=1 , enabled=false)	
	    public void QuickActionableCards() {				  
				driver.findElement(By.id("com.app.cep:id/rlinviteFleet")).click();
				
				driver.findElement(By.id("com.app.cep:id/lllayout")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Manager']").click();
				
				//Enter the Mobile number, first name and last name manually, than clear these 
				driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("123456789012345");
				driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("First Name");
				driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("Last Name");
				
				driver.findElement(By.id("com.app.cep:id/edMobile")).clear();
				driver.findElement(By.id("com.app.cep:id/edfname")).clear();
				driver.findElement(By.id("com.app.cep:id/edlname")).clear();


				driver.findElement(By.id("com.app.cep:id/rlContacts")).click();
				driver.findElement(By.id("com.app.cep:id/edsearchContact")).sendKeys("Test");
				driver.findElement(By.id("com.app.cep:id/llContacts")).click();

			//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Xlri\").instance(0))");
			// driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Adesh\").instance(0))");
				//driver.findElement(By.id("com.app.cep:id/llContacts")).click();
				driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
				driver.findElement(By.id("com.app.cep:id/ivBack")).click();
				
		
		}
		
	   //Selecting a Role & assigning a contact person from hamburger
	

		@Test(priority=2)		
	    public void Selecting_A_Role_And_assigning_a_contact_person_from_hamburger() {	
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  
			  driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();

				driver.findElement(By.id("com.app.cep:id/add_fab")).click();
				driver.findElement(By.id("com.app.cep:id/lllayout")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Manager']").click();
				//Enter the Mobile number, first name and last name manually, than clear these 
				driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("123456789012345");
				driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("First Name");
				driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("Last Name");
				driver.findElement(By.id("com.app.cep:id/edMobile")).clear();
				driver.findElement(By.id("com.app.cep:id/edfname")).clear();
				driver.findElement(By.id("com.app.cep:id/edlname")).clear();
				driver.findElement(By.id("com.app.cep:id/rlContacts")).click();
				driver.findElement(By.id("com.app.cep:id/edsearchContact")).sendKeys("Test");
				driver.findElement(By.id("com.app.cep:id/llContacts")).click();

			//	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Xlri\").instance(0))");
			// driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Adesh\").instance(0))");
				//driver.findElement(By.id("com.app.cep:id/llContacts")).click();
				driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
				
				//String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[4]")).getAttribute("name");

				//System.out.println(toastMessage);
				//Assert.assertEquals("User registered already!!", toastMessage);//Actual validation
				//name attribute for toast messages will have content
				

				driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		}
		
		
		  //Resending an Invite
		  
		@Test(priority=3)	
	    public void Resending_An_Invite() {	

			 // driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();
			  driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

			 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"mz\").instance(0))");

			  driver.findElement(By.id("com.app.cep:id/tvresend")).click();
			  
				String ResendingAnInvitePopUp=driver.findElementByXPath("//android.widget.TextView[@text='INVITE SENT TO MZ']").getText();
				

				System.out.println(ResendingAnInvitePopUp);
				Assert.assertEquals("INVITE SENT TO MZ", ResendingAnInvitePopUp);
			  driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
				}
				

		//Assign Fleet to the designated users
		
		@Test(priority=4)	
	    public void Assign_Fleet_To_The_Designated_Users_Manager() throws SQLException {	

	 String host = "localhost"; 
	 String port= "3306"; 
	 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
	 Statement s = con.createStatement(); 
	ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=1 ");

	 while(rs.next())
	 {
	     driver.findElement(By.id("com.app.cep:id/llowner_manager")).click();

		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Prem Chand\").instance(0))");

		     driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
				//Search
			  driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
			     driver.findElement(By.id("com.app.cep:id/iv")).click();
			     driver.findElement(By.id("com.app.cep:id/tvdone")).click();
			     
			 	String AssignFleetToTheDesignatedUsersManagerPopUp=driver.findElementByXPath("//android.widget.TextView[@text='Vehicle Assigned Successfully.']").getText();

					//String AssignFleetToTheDesignatedUsersManagerPopUp=driver.findElement(By.id("//com.app.cep:id/tvName")).getText();

					System.out.println(AssignFleetToTheDesignatedUsersManagerPopUp);
			
				//Assert.assertEquals("Vehicle Assigned Successfully.", AssignFleetToTheDesignatedUsersManagerPopUp);//Actual validation
				
				Assert.assertEquals("Vehicle Assigned Successfully.",AssignFleetToTheDesignatedUsersManagerPopUp);
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			     driver.findElement(By.id("com.app.cep:id/tvOkk")).click();

			 	}
	}
		
		@Test(priority=5)		
		  public void Unassign_Fleet_To_The_Designated_Users_Manager() throws SQLException {	

			  String host = "localhost"; 
			  String port= "3306"; 
			  Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
			  Statement s = con.createStatement(); 
			 ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=1 ");

			  while(rs.next())
			  {
					 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Assad ffff\").instance(0))");

			 	     driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
			 			//Search
			 		  driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
			 		     driver.findElement(By.id("com.app.cep:id/iv")).click();
			 		     driver.findElement(By.id("com.app.cep:id/tvdone")).click();

			 		 	String UnassignFleetToTheDesignatedUsersManagerPopUp=driver.findElementByXPath("//android.widget.TextView[@text='Vehicle Unassigned Successfully.']").getText();

						System.out.println(UnassignFleetToTheDesignatedUsersManagerPopUp);
									
					Assert.assertEquals("Vehicle Unassigned Successfully.",UnassignFleetToTheDesignatedUsersManagerPopUp);
		 		     driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
			
			 		 	}
			 }
		
		
		//Assign Fleet to the designated users
		
			@Test(priority=6, enabled = false)	
		    public void Assign_Fleet_To_The_Designated_Users() throws SQLException {	

		 String host = "localhost"; 
		 String port= "3306"; 
		 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
		 Statement s = con.createStatement(); 
		ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=1 ");

		 while(rs.next())
		 {
			 
			     driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
					//Search
				  driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
				     driver.findElement(By.id("com.app.cep:id/iv")).click();
				     driver.findElement(By.id("com.app.cep:id/tvdone")).click();
				     
						String AssignFleetToTheDesignatedUsersManagerPopUp=driver.findElement(By.id("//com.app.cep:id/tvName")).getText();

						System.out.println(AssignFleetToTheDesignatedUsersManagerPopUp);
						
						//Assert.assertEquals("Vehicle Assigned Successfully.", AssignFleetToTheDesignatedUsersManagerPopUp);//Actual validation
						
					
						
						//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				     driver.findElement(By.id("com.app.cep:id/tvOkk")).click();

				 	}
	}
		
			  //Unassign Fleet from designated users 
			  
			@Test(priority=7, enabled = false)		
		    public void Unassign_Fleet_from_designated_users () throws SQLException {	

				String host = "localhost"; 
				 String port= "3306"; 
				 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
				 Statement s = con.createStatement(); 
				ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=1 ");

				 while(rs.next())
				 {
				
		  driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();
		  driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
		  driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
		  driver.findElement(By.id("com.app.cep:id/iv")).click();
		  driver.findElement(By.id("com.app.cep:id/tvdone")).click();
			String UnassignFleetToTheDesignatedUsersManagerPopUp=driver.findElement(By.id("//com.app.cep:id/tvName")).getText();

			System.out.println(UnassignFleetToTheDesignatedUsersManagerPopUp);
			Assert.assertEquals("Vehicle Unassigned Successfully.", UnassignFleetToTheDesignatedUsersManagerPopUp);//Actual validation
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
			  }
			}
			
	
	
				  //Logout 
					@Test(priority=10,enabled=false )
					public void HamburgerLogout() {
					driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
				 driver.findElement(By.id("com.app.cep:id/tvLogout")).click();
				 driver.findElement(By.id("com.app.cep:id/txt_go_back")).click();
					}

			
				  //Delete App 
					@Test(priority=10,enabled=false)	
					public void DeleteApp() {
				  driver.removeApp("com.app.cep");
					}
				 			
			  }

		 
	      
		
