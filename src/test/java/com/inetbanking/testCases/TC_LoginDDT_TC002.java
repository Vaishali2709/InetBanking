package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.poi.xssf.XLSBUnsupportedException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_TC002 extends BaseClass{
	
	@Test(dataProvider="LoginDDT")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.clicksubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true )
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clicklogout();
			Thread.sleep(3000);
		}
	}
	
	
	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}

	@DataProvider(name="LoginDDT")
	String[][]getData() throws IOException
	{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		 int rownum=XLUtils.getRowCount(path, "Sheet1");
		 int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		 	
		 String logindata[][]=new String[rownum][colcount];
		 
		 for(int i=1;i<=rownum;i++)
		 {
			 for(int j=0;j<colcount;j++)
			 {
				 logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			 }
		 }
		 return logindata;
		
	}
	
}
