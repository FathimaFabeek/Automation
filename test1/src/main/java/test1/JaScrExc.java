package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JaScrExc 
{
	static WebDriver driver;
	 static WebDriverWait wait1;
	static String url = "https://www.amazon.in/";


	public static void main(String[] args) 
	{
		ChromeOptions op=new ChromeOptions();
		op.addArguments("start-maximized");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(op);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		wait1 = new WebDriverWait(driver,5);
		driver.navigate().to(url);
		//js.executeScript("alert('Welcome to Amazone');"); 
		js.executeScript("window.scrollBy(0,2000)");//scroll
		WebElement w1=driver.findElement(By.xpath("//*[@alt='Lowest Prices |Boult Audio Headphones']"));
		js.executeScript("arguments[0].click();", w1);
		

	}

}
