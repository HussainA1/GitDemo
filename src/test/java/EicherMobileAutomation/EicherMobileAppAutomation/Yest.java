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


public class Yest  extends base
{
	// //Clicking on Fleet Monitor Icon present in Bottom Icons
	@Test(priority=1)	
	public void Clicking_On_Fleet_Monitor_Icon_Present_In_Bottom_Icons() 
	{	
		//driver.findElement(By.id("com.app.cep:id/ivBack")).click();
		//driver.findElement(By.id("com.app.cep:id/ivNoti1")).click(); // For closing the hamburger panel.

		driver.findElement(By.id("com.app.cep:id/llFleetMonitoring")).click();
	}

	@Test(priority=2)	
	public void Cls() 
	{


		//Duration is "Specific Date"
		String Specific_Day="17";
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Clicking on Duration Dropdown
		driver.findElement(By.xpath("//*[@text='Specific Date']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/imgVNavLeft']")).click();
		java.util.List<AndroidElement> dates=driver.findElements(By.className("android.widget.TextView"));
		for (int i=0;i<dates.size();i++)
		{
			String sd=dates.get(i).getText();
			if(sd.equals(Specific_Day))
			{
				dates.get(i).click();
				break;
			}
		}
		String Specifie_Date[]=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/tvYearTitle']")).getText().split(" ");
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		//Verifying "Specific Date"
		String month=Specifie_Date[0];
		month=month.substring(0,3);
		String year=Specifie_Date[1];
		String Displayed_Specifie_Date=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).getText();
		Assert.assertEquals(Displayed_Specifie_Date, Specific_Day+" "+month+" "+year);


		//Duration is "Date Range"
		String Date_Range_From="8";
		String Date_Range_To="17";
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).click(); // Clicking on Duration Dropdown
		driver.findElement(By.xpath("//*[@text='Date Range']")).click();
		driver.findElement(By.xpath("//*[@resource-id='com.app.cep:id/imgVNavLeft']")).click();
		dates=driver.findElements(By.className("android.widget.TextView"));
		for (int i=0;i<dates.size();i++)
		{
			String sd=dates.get(i).getText();
			if(sd.equals(Date_Range_From))
			{
				dates.get(i).click();
			}
			if(sd.equals(Date_Range_To))
			{
				dates.get(i).click();
				break;
			}

		}
		String Date_Range[]=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/tvYearTitle']")).getText().split(" ");
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		//Verifying "Specific Date"
		month=Date_Range[0];
		month=month.substring(0,3);
		year=Date_Range[1];
		String Displayed_Date_Range=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.app.cep:id/durationTextView']")).getText();
		Assert.assertEquals(Displayed_Date_Range, "08 "+month+" - "+"17 "+month+" "+year);
	}
}
