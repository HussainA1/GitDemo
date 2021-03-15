package EicherMobileAutomation.EicherMobileAppAutomation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;
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


public class Assign1 extends base {

    long phoneManager = 120000;
    long phonePilot = 34000;

    //@Test(dataProvider="InputData",dataProviderClass=Te'stData.class)
    @Test
    public void OwnerloginToApp() throws SQLException, IOException {
        String host = "localhost";
        String port = "3306";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root", "1234");
        Statement s = con.createStatement();


        //ResultSet rs = s.executeQuery("select * from CustomerOnBording WHERE ID =90");
        ResultSet rs = s.executeQuery("select * from CustomerOnBording WHERE ID BETWEEN 90 AND 95");

        while (rs.next()) {

            System.out.println("printing for next record, ID....." + rs.getString("ID"));
            System.out.println("loginid...." + rs.getString("LOGIN_ID"));
            System.out.println("pwd...." + rs.getString("PASSWORD"));




            service = startServer();
            AndroidDriver < AndroidElement > driver = Capabilities("CEP");
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


            // ----- create data START  ----------------------



            // @Test(priority = 1)
            //public void getStartedScreen() {
            driver.findElementByXPath("//android.widget.TextView[@text='GET STARTED']").click();

            // driver.findElement(By.id("com.app.cep:id/btnLogin")).click();
            //}

            //@Test(priority = 2)
            //public void InformationScreenWhileLaunchingApp() {
            driver.findElement(By.id("com.app.cep:id/layoutFirst")).click();
            driver.findElement(By.id("com.app.cep:id/layoutSecond")).click();
            driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

            driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();

            //}



            //Create new manager and asssign vehicle

            //@Test(priority = 3, invocationCount = 10, enabled = false)
            //public void CreateManagerAndAssignVehicle() {
            Random random = new Random();

            //driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

            //driver.findElement(By.id("com.app.cep:id/tvUseraccount")).click();

            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(30000));
            //String phone = phoneManager++; //increment phone number
            String phone = String.valueOf(++phoneManager);
            String fn = String.valueOf(random.nextInt(3000));
            String ln = String.valueOf(random.nextInt(3000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("91304" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("ManagerfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("MangerlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"24\").instance(0))");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.id("com.app.cep:id/rlSelect")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.findElement(By.id("com.app.cep:id/ivBack")).click();


            //}
            //Create new manager and asssign vehicle

            //@Test(priority = 4, invocationCount = 6)
            //public void CreateManyManagerAndAssignVehicle() {
            //Random random = new Random();
            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(100000));
            //String phone = phoneManager++; //increment phone number
            phone = String.valueOf(++phoneManager);
            fn = String.valueOf(random.nextInt(1000));
            ln = String.valueOf(random.nextInt(1000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("9130" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("ManagerfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("MangerlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"64\").instance(0))");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"64\").instance(0))");

            driver.findElement(By.id("com.app.cep:id/rlSelect")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();


            //}


            //Create new pilot and asssign vehicle

            //@Test(priority = 5)
            //public void CreatePilot1AndAssignVehicle() {
            random = new Random();

            driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(10000));
            //String phone = phonePilot++; //increment phone number
            phone = String.valueOf(++phonePilot);
            fn = String.valueOf(random.nextInt(1000));
            ln = String.valueOf(random.nextInt(1000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("91304" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("PilotfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("PilotlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"11\").instance(0))");

            driver.findElement(By.id("com.app.cep:id/iv")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();


            //Create new pilot and asssign vehicle

            //@Test(priority = 6)
            //public void CreatePilot2AndAssignVehicle() {
            random = new Random();

            driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(10000));
            //String phone = phonePilot++; //increment phone number
            phone = String.valueOf(++phonePilot);
            fn = String.valueOf(random.nextInt(1000));
            ln = String.valueOf(random.nextInt(1000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("91304" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("PilotfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("PilotlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"13\").instance(0))");

            driver.findElement(By.id("com.app.cep:id/iv")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();

            //}
            //Create new pilot and asssign vehicle

            // @//Test(priority = 7)
            //public void CreatePilot3AndAssignVehicle() {
            random = new Random();

            driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(10000));
            //String phone = phonePilot++; //increment phone number
            phone = String.valueOf(++phonePilot);
            fn = String.valueOf(random.nextInt(1000));
            ln = String.valueOf(random.nextInt(1000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("91304" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("PilotfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("PilotlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"15\").instance(0))");

            driver.findElement(By.id("com.app.cep:id/iv")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();

            //}
            //Create new pilot and asssign vehicle

            //@Test(priority = 8)
            //public void CreatePilot4AndAssignVehicle() {
            random = new Random();

            driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(10000));
            //String phone = phonePilot++; //increment phone number
            phone = String.valueOf(++phonePilot);
            fn = String.valueOf(random.nextInt(1000));
            ln = String.valueOf(random.nextInt(1000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("91304" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("PilotfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("PilotlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"16\").instance(0))");

            driver.findElement(By.id("com.app.cep:id/iv")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();



            //Create new pilot and asssign vehicle

            //@Test(priority = 9)
            //public void CreatePilot5AndAssignVehicle() {
            random = new Random();

            driver.findElement(By.id("com.app.cep:id/llpilot_owner")).click();

            driver.findElement(By.id("com.app.cep:id/add_fab")).click();

            //String phone = String.valueOf(random.nextInt(10000));
            //String phone = phonePilot++; //increment phone number
            phone = String.valueOf(++phonePilot);
            fn = String.valueOf(random.nextInt(1000));
            ln = String.valueOf(random.nextInt(1000));

            //Enter the Mobile number, first name and last name manually, than clear these 
            driver.findElement(By.id("com.app.cep:id/edMobile")).sendKeys("91304" + phone);
            driver.findElement(By.id("com.app.cep:id/edfname")).sendKeys("PilotfirstName" + fn);
            driver.findElement(By.id("com.app.cep:id/edlname")).sendKeys("PilotlastName" + ln);

            driver.findElement(By.id("com.app.cep:id/tvsendinvite")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//android.widget.TextView[@text='ASSIGN FLEET']")).click();
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"19\").instance(0))");
            driver.findElement(By.id("com.app.cep:id/iv")).click();
            driver.findElement(By.id("com.app.cep:id/tvdone")).click();
            driver.findElement(By.id("com.app.cep:id/tvOkk")).click();

            //}

            //Logout 
            //@Test(priority = 6, enabled = false)
            //public void HamburgerLogout() {
            driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
            driver.findElement(By.id("com.app.cep:id/tvLogout")).click();
            driver.findElement(By.id("com.app.cep:id/txt_go_back")).click();
            //}

            // ------- create data END -------------------------


        }

        //System.exit(0);

    }

}