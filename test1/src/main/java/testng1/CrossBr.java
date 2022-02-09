package testng1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CrossBr
{
	public WebDriver driver;
	
	 @Parameters("browser")
	 @BeforeClass
	  public void beforeClass(String br)
	  {
		 if(br.equals("chrome"))
			{
			  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
				 driver=new ChromeDriver();
			
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			}
			driver.get("http://demo.guru99.com/test/newtours/");
		 
	  }
  @Test
  public void f() 
  {
	  driver.findElement(By.xpath("//*[text()='SIGN-ON']")).click();
  }
 

  @AfterClass
  public void afterClass()
  {
	// driver.close();
  }

}
