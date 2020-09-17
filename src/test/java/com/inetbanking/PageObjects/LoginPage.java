package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 public static WebDriver driver ;
	
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="uid")
	public WebElement txtusername;
	
	@FindBy(name="password")
	public WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	public WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	public WebElement lnkLogOut;

	public void setUsername(String uname)
	{
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String password)
	{
		txtpassword.sendKeys(password);
	}
	
	public void clicksubmit()
	{
		loginbtn.click();
	}
	
	public void clicklogout()
	{
		lnkLogOut.click();
	}
}
