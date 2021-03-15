package EicherMobileAutomation.EicherMobileAppAutomation;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import EicherMobileAutomation.EicherMobileAppAutomation.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverLogin  extends base{

@Test
	
	public void DriverloginToApp() throws SQLException, IOException 
	{
	//public static void main(String[] args) throws SQLException, ClassNotFoundException, MalformedURLException {
		
	 String host = "localhost"; 
	 String port= "3306"; 
	 Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/EicherTesting", "root","root");
	 Statement s = con.createStatement(); 
	ResultSet rs = s.executeQuery("select * from CustomerDetails where ID=8 ");

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
			 
			//dashboard
			//Breakdown bottom bar
			  driver.findElement(By.id("com.app.cep:id/ivBreak")).click();
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();

			  //Fleet performance bottom bar
			  driver.findElement(By.id("com.app.cep:id/ivFleet")).click();
			  driver.findElement(By.id("com.app.cep:id/ivMenu")).click();


			//Menu bar
		    driver.findElement(By.id("com.app.cep:id/ivMenu")).click();
			//driver.findElement(By.id("com.app.cep:id/tvMangaeVehicle")).click();
			
			
			//Logout
			driver.findElement(By.id("com.app.cep:id/tvLogout")).click();
			driver.findElement(By.id("com.app.cep:id/txt_go_back")).click();

			driver.removeApp("com.app.cep");


			
    
        }
	
}
}