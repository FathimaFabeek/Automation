package test1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Screensht 
{
	static WebDriverWait wait1;
	static WebDriver driver;

	public void capturescreenshot(WebDriver driver)
	{
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(screenshot,new File("C:\\screenshots\\page1.png"));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) 
	{
		Screensht obj=new Screensht();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/V4/");
		obj.capturescreenshot(driver);
		driver.close();
		}

	

}
