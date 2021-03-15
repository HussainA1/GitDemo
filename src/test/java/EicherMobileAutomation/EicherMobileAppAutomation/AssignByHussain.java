


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

	public class AssignByHussain  extends base{

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
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();
				driver.findElement(By.id("com.app.cep:id/tvnext")).click();

				driver.findElement(By.id("com.app.cep:id/ed_mobile")).sendKeys(rs.getString("LOGIN_ID"));
				driver.findElement(By.id("com.app.cep:id/ed_password")).sendKeys(rs.getString("PASSWORD"));
				driver.findElement(By.id("com.app.cep:id/btnLogin")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='GET STARTED']").click();

			}

		}

		//Selecting "Manage Team" Option From Hamburger
		@Test(priority=1)		
		public void InformationScreenWhileLaunchingApp() 
		{	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Clicking on Hamburger
			driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			// Clicking on "Manage team" in hamburger.
			driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();
			//Clicking on (+)symbol on Manage Team Screen.
			driver.findElement(By.id("com.app.cep:id/add_fab")).click();
		}


		//Inviting Managers
		@Test(priority=2)	
		public void QuickActionableCards() 
		{		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			long phoneNo=123456000L;
			String firstName ="Manager";
			String lastName ="Test";
			int code = 0;

			for(int i =0; i<200; i++)
			{
				String phoneNoString= String.valueOf(phoneNo);
				String codeString= String.valueOf(code);
				driver.findElement(By.id("com.app.cep:id/rlinviteFleet")).click();
				driver.findElement(By.id("com.app.cep:id/lllayout")).click();
				driver.findElementByXPath("//android.widget.TextView[@text='Manager']").click();
				//Enter the Mobile number
				driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys(phoneNoString);
				driver.findElement(By.id("com.app.cep:id/edMobile")).click();
				driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys(codeString);
				//Entering First Name
				driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys(firstName);
				driver.findElement(By.id("com.app.cep:id/edfname")).click();
				driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys(codeString);
				//Entering Last Name
				driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys(lastName);
				driver.findElement(By.id("com.app.cep:id/edlname")).click();
				driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys(codeString);

				driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
				driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
				//driver.findElement(By.id("com.app.cep:id/ivBack")).click();

				code++;
			}
		}
	}

