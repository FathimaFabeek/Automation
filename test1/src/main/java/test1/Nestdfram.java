package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nestdfram
{
	static WebDriverWait wait1;

	public void Enteriframe(WebDriver driver)
	{
		  driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		  WebElement we = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		  driver.switchTo().frame(we);
		  WebElement we2 = driver.findElement(By.xpath("//*[@style='float: left;height: 250px;width: 400px']"));
		  driver.switchTo().frame(we2);
		  driver.findElement(By.xpath("//input[@type='text']")).click();
		  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
		 }
	public static void main(String[] args)
	{
		Nestdfram obj=new Nestdfram();
		ChromeOptions op = new ChromeOptions();
		  op.addArguments("start-maximized");
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		  WebDriver driver = new ChromeDriver(op);
		  wait1 = new WebDriverWait(driver,5);
		  String url = "http://demo.automationtesting.in/Frames.html";
		  driver.navigate().to(url);
             obj.Enteriframe(driver);
		  driver.switchTo().defaultContent();
		  driver.findElement(By.xpath("//*[text()='Home']")).click();
		  driver.close();
		 }
	}

