package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Phptr 
{
	static String url="https://phptravels.com/";

	public void id1(WebDriver driver)
	{
		WebElement we=driver.findElement(By.id("icon"));
		System.out.println(we.getAttribute("x"));
		WebElement we1=driver.findElement(By.id("email"));
		System.out.println(we1.isDisplayed());
		
	}
	public void name1(WebDriver driver)
	{
//		WebElement we=driver.findElement(By.name("chat-widget"));
//		System.out.println(we.getSize());
		}
	public void classname(WebDriver driver)
	{
		WebElement we=driver.findElement(By.className("cls-2"));
		System.out.println(we.getText());
		WebElement we1=driver.findElement(By.className("cls-1"));
		System.out.println(we1.getAttribute("y"));
	}
	public void linktext(WebDriver driver)
	{
		WebElement we=driver.findElement(By.linkText("Docs"));
		System.out.println(we.getText());
		WebElement we1=driver.findElement(By.linkText("Pricing"));
		System.out.println(we1.getTagName());
	}
	public void partial(WebDriver driver)
	{
		WebElement we=driver.findElement(By.partialLinkText("Integra"));
		System.out.println(we.getText());
		if(we.isDisplayed())
		{
			we.click();
		}}
	public void tag(WebDriver driver)
	{
		//WebElement we=driver.findElement(By.tagName("a"));
		List<WebElement>element=driver.findElements(By.tagName("a"));
		for(WebElement li:element)
		{
			System.out.println(li.getText());
		}
		//System.out.println(element+"\n");
		
	}
	public static void main(String[] args) throws InterruptedException 
	{
		Phptr obj=new Phptr();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91984\\eclipse-workspace\\test1\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
	    driver.manage().window().maximize();
	    Thread.sleep(5000);
         obj.id1(driver);
         //obj.name1(driver);
         obj.classname(driver);
         Thread.sleep(5000);
         obj.linktext(driver);
         obj.partial(driver);
         Thread.sleep(5000);
         obj.tag(driver);
         driver.close();


	}

}
