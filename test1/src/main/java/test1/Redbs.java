package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Redbs 
{
	static WebDriverWait wait1;
	public void home(WebDriver driver)
	{
		WebElement x=driver.findElement(By.xpath("//*[@id='src']"));
		x.sendKeys("Kasaragod");
		x.sendKeys(Keys.ENTER);
		WebElement y=driver.findElement(By.xpath("//*[@id='dest']"));
		y.sendKeys("Thrissur");
		y.sendKeys(Keys.ENTER);
	}

	public static void main(String[] args)
	{
		Redbs obj=new Redbs();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1000,0)");
		 wait1 = new WebDriverWait(driver,10);
		driver.navigate().to("https://www.redbus.in/");
		driver.manage().window().maximize();
		obj.home(driver);
		driver.close();
		

	}

}
