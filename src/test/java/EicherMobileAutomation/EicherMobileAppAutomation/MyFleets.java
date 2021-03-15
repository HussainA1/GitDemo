package EicherMobileAutomation.EicherMobileAppAutomation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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


public class MyFleets  extends base{

//@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	@BeforeClass
	public void OwnerloginToApp() throws SQLException, IOException 
	{
		 String host = "localhost"; 
		 String port= "3306"; 
		 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
		 Statement s = con.createStatement(); 
		ResultSet rs = s.executeQuery("select * from CustomerDetails where ID=1 ");

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
				
				 	}
	}
	
	
			//My Fleets 
	@Test(priority=3, enabled=false)	
	//@Test(dataProvider="InputData",dataProviderClass=TestData.class)

    public void MyFleetsDashboard() {				
		
			  driver.findElement(By.id("com.app.cep:id/llTotalvehicles")).click();
			//  int TotalvehiclesOnRoad=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			  
			  driver.findElement(By.id("com.app.cep:id/llInservice")).click();
			  //int TotalvehiclesInservice=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
			  driver.findElement(By.id("com.app.cep:id/Cross_IV")).click();
			  
			  driver.findElement(By.id("com.app.cep:id/llBreakdown")).click();
			  //int TotalvehiclesBreakdown=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
			  driver.findElement(By.id("com.app.cep:id/Cross_IV")).click();
			  
			  
			  String countTotalvehiclesOnRoad = driver.findElement(By.id("com.app.cep:id/tvVehicleCountOnRoad")).getText();
			  String countTotalvehiclesInservice  = driver.findElement(By.id("com.app.cep:id/tvserviceCount")).getText();
			  String countTotalvehiclesBreakdown =  driver.findElement(By.id("com.app.cep:id/tvcountbreakdown")).getText();
			  String Totalvehicles =  driver.findElement(By.id("com.app.cep:id/tvCount")).getText();
			  
			  int countOfTotalvehiclesOnRoadValue=Integer.parseInt(countTotalvehiclesOnRoad);
			  int countOfTotalvehiclesInservice=Integer.parseInt(countTotalvehiclesInservice);
			  int countOfTotalvehiclesBreakdown=Integer.parseInt(countTotalvehiclesBreakdown);
			  
			  int SumOfTotalVehicles = countOfTotalvehiclesOnRoadValue + countOfTotalvehiclesInservice + countOfTotalvehiclesBreakdown;
			  int countOfTotalvehicles=Integer.parseInt(Totalvehicles);


			  Assert.assertEquals(SumOfTotalVehicles,countOfTotalvehicles);  
	}
			  @Test(priority=3, enabled=false)	
			    public void MyFleetsTrackInMap() {	
				driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TRACK IN MAP\"))").click();
				  driver.findElement(By.id("com.app.cep:id/ivBack")).click();
				  
				  }

			  //Scroll to Operational Excellence
	@Test(priority=4, enabled=false)	
    public void DashBoardView() {	
				 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Video\").instance(0))");
				 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"QUICK ACTIONABLES\").instance(0))");
				 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Video\").instance(0))");
	}
				 //Breakdown bottom bar
	@Test(priority=5, enabled=false)	
    public void Breakdowbottombar() {	
				  driver.findElement(By.id("com.app.cep:id/ivBreak")).click();
				  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
	}

				  //Fleet performance bottom bar
	@Test(priority=6, enabled=false)	
    public void FleetperformancebottomBar() {	
				  driver.findElement(By.id("com.app.cep:id/ivFleet")).click();
				  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
	}
	@Test(priority=7, enabled=false)	
    public void HamburgerManageVehicle() {	

			  //Hamburger driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  
			  //Manage Vehicle 
			  driver.findElement(By.id("com.app.cep:id/tvMangaeVehicle")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();
	}

			  //Invite Users
			  
				@Test(priority=8, enabled=false)	
			    public void HamburgerInviteUsers() {	

			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			  driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();
				}
				
			  //Dealer Locator 
				@Test(priority=9, enabled=false)	
			    public void HamburgerDealerLocator() {	

			  driver.findElement(By.id("com.app.cep:id/tvLocator")).click();
			  
			  driver.findElement(By.id("com.app.cep:id/tvProb")).click();
			driver.findElementByXPath("//android.widget.TextView[@text='24']").click();

			  
			  driver.findElement(By.id("com.app.cep:id/tvCityWise")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Allahabad']").click();
			  
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();

				}
				
			  //Operation Excellence 
				@Test(priority=10, enabled=false)	
			    public void HamburgerOperationExcellence() {	

			  driver.findElement(By.id("com.app.cep:id/tvcbop")).click();
			  
			  //EOS SelectByModel
			
			  driver.findElement(By.id("com.app.cep:id/filterByTextView")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Model']").click();
				
				driver.findElement(By.id("com.app.cep:id/modelTextView")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Z23']").click();
				
			  driver.findElement(By.id("com.app.cep:id/durationTextView")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Last 2 month']").click();
			  
	
			  
			  //Workshop Repair
			  
			  
			  
			  
			  driver.findElement(By.id("com.app.cep:id/ivBack")).click();
				}

			  // Product Catalogue 
				@Test(priority=11, enabled=false)
				public void HamburgerProductCatalogue() {
			  driver.findElement(By.id("com.app.cep:id/tvproductCat")).click();
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
	
				}
				
			  //Logout 
				@Test(priority=12, enabled=false)	
				public void HamburgerLogout() {
				driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			 driver.findElement(By.id("com.app.cep:id/tvLogout")).click();
			 driver.findElement(By.id("com.app.cep:id/txt_go_back")).click();
				}

				@Test(priority=13, enabled=false)	
				public void Verify() 
				{
				
					
					//Login
					//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LOGIN\"))");
					//driver.findElementByXPath("//android.widget.TextView[@text='LOGIN']").click();
					driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys("7648732490");
					driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys("1234567890");

					driver.findElement(By.id("com.app.cep:id/btnLogin")).click();
					
					String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");

					System.out.println(toastMessage);
					//Assert.assertEquals("Please enter your name", toastMessage);//Actual validation
					//name attribute for toast messages will have content
					
					 	}
			  //Delete App 
				@Test(priority=14, enabled=false)	
				public void DeleteApp() {
			  driver.removeApp("com.app.cep");
				}
			 			
		  }

	 
      
	
