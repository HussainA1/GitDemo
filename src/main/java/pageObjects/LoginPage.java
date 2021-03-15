package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='LOGIN']")
	public WebElement LoginButtonOnSignUpPage; 
	
	
	@AndroidFindBy(id ="com.app.cep:id/ed_mobile")
	public WebElement mobileNumberTextbox; 
	
	@AndroidFindBy(xpath="com.app.cep:id/ed_password']")
	public WebElement passwordTextbox; 
	
	@AndroidFindBy(xpath="com.app.cep:id/btnLogin")
	public WebElement LoginButton; 
	
	public WebElement clickLoginButton()
	{
		System.out.println("click on login button");
		return LoginButtonOnSignUpPage; 
	}
	
}
