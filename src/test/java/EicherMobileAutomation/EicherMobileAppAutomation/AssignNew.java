package EicherMobileAutomation.EicherMobileAppAutomation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import java files

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

import java.io.File;

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


public class AssignNew extends base {

	long code = 1420;
	int j=1;

	
	
	@Test
	public void OwnerloginToApp() throws SQLException, IOException {
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root", "1234");
		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from CustomerOnBording WHERE ID IN (40, 45, 48, 54, 61, 62, 65, 66, 71, 73, 75, 107, 100, 85, 87, 90, 94, 118, 139)");

		service = startServer();
		AndroidDriver < AndroidElement > driver = Capabilities("CEP");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		while (rs.next()) {

			System.out.println("printing for next record, ID....." + rs.getString("ID"));
			System.out.println("loginid...." + rs.getString("LOGIN_ID"));
			System.out.println("pwd...." + rs.getString("PASSWORD"));

			
			File file = new File("E:\\AssignManager\\starting_ID_"+ rs.getString("ID") + " _code_" + code );
			file.createNewFile();
			
			//if the user id, ie phone number stored in LOGIN_ID, is not a 10 digit number then skip the loop

			if(rs.getString("LOGIN_ID").length()<10)
			{

				continue;  //skip the loop
			}

			Assert.assertEquals(rs.getString("LOGIN_ID").length(), 10);


			if(j==1)
			{
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
			}

			driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys(rs.getString("LOGIN_ID"));
			driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys(rs.getString("PASSWORD"));
			driver.findElement(By.id("com.app.cep:id/btnLogin")).click();


			// ----- create data START  ----------------------

			driver.findElementByXPath("//android.widget.TextView[@text='GET STARTED']").click();

			if(j==1)
			{
				driver.findElement(By.id("com.app.cep:id/layoutFirst")).click();
				driver.findElement(By.id("com.app.cep:id/layoutSecond")).click();
			}

			j++;

			driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

			driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();

			// Creating Managers

			for(int i=0;i<2;i++)
			{
				String codeS= String.valueOf(++code);

				driver.findElement(By.id("com.app.cep:id/add_fab")).click();

				//Enter the Mobile number, first name and last name manually, than clear these 
				driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("912345" + codeS);
				driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("ManagerFN" + codeS);
				driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("MangerLN" + codeS);

				driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
				driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();

				for(int swipe=0;swipe<5;swipe++)
				{
					Vertical_Swipe_Using_Percentage(0.5,0.8,0.5,0.2);
				}

				driver.findElement(By.id("com.app.cep:id/rlSelect")).click();
				driver.findElement(By.id("com.app.cep:id/tvdone")).click();
				driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
			}

			for(int i=0;i<5;i++)
			{
				driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

				driver.findElement(By.id("com.app.cep:id/add_fab")).click();

				String codeS= String.valueOf(++code);

				driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("911234" + codeS);
				driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("PilotFN" + codeS);
				driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("PilotLN" + codeS);

				driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
				driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
				
				//Loop for unassigned vehicle
				while(true)
				{
					String pilotName = driver.findElement(By.id("com.app.cep:id/tvPilotName")).getText();
					System.out.println(pilotName);
					if(pilotName.equals(""))
					{
						break;
					}
					
					Vertical_Swipe_Using_Percentage(0.5,0.6,0.5,0.34);
				}

/*				switch (i) {

				case 0:
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"11\").instance(0))");
					break;

				case 1:
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"13\").instance(0))");
					break;

				case 2:
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"15\").instance(0))");
					break;

				case 3:
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"16\").instance(0))");
					break;

				case 4:
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"19\").instance(0))");
					break;

				default:
					driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"00\").instance(0))");
					break;
					
				}
*/
				driver.findElement(By.id("com.app.cep:id/iv")).click();
				driver.findElement(By.id("com.app.cep:id/tvdone")).click();
				driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
			}

			//Logout 
			driver.findElement(By.id("com.app.cep:id/ivBack")).click();
			driver.findElement(By.id("com.app.cep:id/tvLogout")).click();
			driver.findElement(By.id("com.app.cep:id/txt_go_back")).click();


			// ------- create data END -------------------------
			
			File fileDone = new File("E:\\AssignManager\\Done_ID_"+ rs.getString("ID") + " _code_" + code );
			fileDone.createNewFile();
			
			//create file that is successfully executed
			//File file = new File("E:\\AssignManager\\"+ rs.getString("ID") + " _code_" + code );
			
		}
	}

}
