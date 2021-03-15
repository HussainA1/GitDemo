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


public class ManageFleet  extends base{


	//Viewing that Manage Vehicles option is present in Hamburger
		@Test(priority=1)	
	    public void ManageVehiclesOptionIsPresentInHamburger() {	
		  //   driver.findElement(By.id("com.app.cep:id/ivBack")).click();

		//driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
		
		String ManageFleetOptionPresentInHamburger= driver.findElement(By.id("com.app.cep:id/tvMangaeVehicle")).getText();
		

		System.out.println(ManageFleetOptionPresentInHamburger);
		Assert.assertEquals("Manage Fleet", ManageFleetOptionPresentInHamburger);
		
		driver.findElement(By.id("com.app.cep:id/tvMangaeVehicle")).click();
		}
		
		//Verify that VEHICLES/FLEET  screen appears on tapping ManageVehicles Module option present in Hamburger.
		
				@Test(priority=2)	
			    public void VEHICLES_FLEETScreenAppears() {	
				
			
				String VEHICLES_FLEETScreenAppears=driver.findElementByXPath("//android.widget.TextView[@text='VEHICLES/FLEET']").getText();
				

				System.out.println(VEHICLES_FLEETScreenAppears);
				Assert.assertEquals("VEHICLES/FLEET",VEHICLES_FLEETScreenAppears);
						 			
					  }
				
		//Search by vehicle number
		@Test(priority=3)	
	    public void Assign_Fleet_To_The_Designated_Users_Manager() throws SQLException {	

	 String host = "localhost"; 
	 String port= "3306"; 
	 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
	 Statement s = con.createStatement(); 
	ResultSet rs = s.executeQuery("select * from VehiclesDetail where ID=6 ");

	 while(rs.next())
	 {
		     //driver.findElement(By.id("com.app.cep:id/btnAssignFleet")).click();
				//Search
			  driver.findElement(By.id("com.app.cep:id/edSearchVehicle")).sendKeys(rs.getString("Chassis_Number"));
			    
			 	}
	}
		
 
		//Verify that SERVICE HISTORY screen appears on tapping "View Service History" button present in the card of vehicle in VEHICLES/FLEET screen.  
		@Test(priority=4)	
	    public void SERVICEHISTORYscreenAppearsOnTappingViewServiceHistory() {	
			
	    driver.findElement(By.id("com.app.cep:id/tvViewedService")).click();
	    
	    String SERVICEHISTORYscreenAppear=driver.findElementByXPath("//android.widget.TextView[@text='SERVICE HISTORY']").getText();
		

		System.out.println(SERVICEHISTORYscreenAppear);
		Assert.assertEquals("SERVICE HISTORY", SERVICEHISTORYscreenAppear);
	    driver.findElement(By.id("com.app.cep:id/ivBack")).click();

		}
		
		//Verify that BOOK SERVICE screen appears on tapping "Book Service" button present in the card of vehicle in VEHICLES/FLEET screen.  
		@Test(priority=5 , enabled = false)	
	    public void BOOKSERVICEscreenAppearsOnTappingBookService() {	
			
	    driver.findElement(By.id("com.app.cep:id/tvBookService")).click();
	    
	    String BOOKSERVICEscreenAppear=driver.findElementByXPath("//android.widget.TextView[@text='BOOK SERVICE']").getText();
		

		System.out.println(BOOKSERVICEscreenAppear);
		Assert.assertEquals("BOOK SERVICE", BOOKSERVICEscreenAppear);
	    driver.findElement(By.id("com.app.cep:id/ivBack")).click();

		}

		//Verify that Re Schedule SERVICE screen appears on tapping "ReSchedule" button present in the card of vehicle in VEHICLES/FLEET screen.  
		@Test(priority=6)	
	    public void ReSchedulescreenAppearsOnTappingReSchedulebutton() {	
			
	    driver.findElement(By.id("com.app.cep:id/tvBookService")).click();
	    
	    String ReSchedulesSERVICEscreenAppear=driver.findElementByXPath("//android.widget.TextView[@text='RESCHEDULE SERVICE']").getText();
		

		System.out.println(ReSchedulesSERVICEscreenAppear);
		Assert.assertEquals("RESCHEDULE SERVICE", ReSchedulesSERVICEscreenAppear);
	    driver.findElement(By.id("com.app.cep:id/ivBack")).click();

		}

		

}
		 
	      
		
