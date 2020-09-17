package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	

	public String baseURL = readconfig.getApplicationURL();

	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
    public static Logger logger;	


@Parameters("browser")
@BeforeClass

public void setUp(String br)
{
	 logger =Logger.getLogger("BaseClass");
	 PropertyConfigurator.configure("Log4j.properties");
	if(br.equals("firefox"))
	{
	System.setProperty("webdriver.gecko.driver",readconfig.getBrowser());
	driver=new FirefoxDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(baseURL);
	
}


@AfterClass

public void tearDown()
{
	driver.quit();
}


public void captureScreen(WebDriver driver,String tname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+	".png");
	FileUtils.copyFile(src, target);
	System.out.println("Screenshot Taken");
	
	
}
}
