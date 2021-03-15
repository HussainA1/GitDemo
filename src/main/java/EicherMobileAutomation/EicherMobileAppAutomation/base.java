package EicherMobileAutomation.EicherMobileAppAutomation;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

public class base {

	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static String destDir;
	public static DateFormat dateFormat;
	public static String scrPath;

	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunning(int port) 
	{
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try 
		{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch(IOException e) {
			// if control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket=null;
		}
		return isServerRunning;
	}


	public static AndroidDriver<AndroidElement>  Capabilities(String appName) throws IOException 
	{
		System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\EicherMobileAutomation\\EicherMobileAppAutomation\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);


		File f = new File("src");
		File fs= new File(f, (String) prop.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();	

		String device =(String)prop.get("device");

		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Swatiy");
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SwatiEmulator");
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4XLAVD");

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);


		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability("autoGrantPermissions", true);
		// cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		// cap.setCapability(MobileCapabilityType.NO_RESET, true);



		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;

	}

	public static void getScreenshot(String s) throws IOException
	{
		//File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));

	}


	//Method for Capturing Screenshot

	public static void takeScreenShot() {
		// Set folder name to store screenshots.
		destDir = "screenshots";
		// Capture screenshot.
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Set date format to set It as screenshot file name.
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		// Create folder under project with name "screenshots" provided to destDir.
		new File(destDir).mkdirs();
		// Set file name using current date time.
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			// Copy paste file at destination folder location
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			scrPath = destDir+ "/" + destFile;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	//OCR Reading

	public static String OCR(String ImagePath)
	{
		String result = null;
		File imageFile = new File(ImagePath);
		ITesseract instance = new Tesseract();  
		try {
			result = instance.doOCR(imageFile);

		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	//Vertical Swipe Using Percentage
	public void Vertical_Swipe_Using_Percentage (double start_x,double start_y, double end_x, double end_y) {
		Dimension size = driver.manage().window().getSize();
		int start_Y = (int) (size.height * start_y);
		int start_X = (int) (size.width * start_x);
		
		int end_Y = (int) (size.height * end_y);
		int end_X = (int) (size.width * end_x);

		TouchAction touch = new TouchAction(driver);
		
		touch.press(PointOption.point(start_X, start_Y))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		.moveTo(PointOption.point(end_X,end_Y)).release().perform();
	}
	
	//Horizontal Swipe Using Web Element
	public void Horizontal_Swipe_Using_Web_Element(AndroidElement startElement, AndroidElement endElement )
	{
		int start_x = startElement.getLocation().getX() + (startElement.getSize().getWidth()/2);
		int start_y = startElement.getLocation().getY() + (startElement.getSize().getHeight()/2);
		
		int end_x =endElement.getLocation().getX()+endElement.getSize().getWidth();
		int end_y= start_y;
		TouchAction touch = new TouchAction(driver);
		
		touch.press(PointOption.point(start_x, start_y))
		            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		            .moveTo(PointOption.point(end_x,end_y)).release().perform();
	}

}




