package com.inetbanking.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;


public class TC_LoginTest_TC001 extends BaseClass{
	
	
	@Test
	public void loginTest()
	{
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		logger.info("URL is opened");
		
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		
		logger.info("Username is entered");
		login.setPassword(password);
		login.clicksubmit();
		
		WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/ul/li[2]/a")));
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
			
		{
			Assert.assertTrue(false);
	}

}
}
