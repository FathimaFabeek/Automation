package test1;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class New1 
{
	static WebDriverWait wait1;

	public static void main(String[] args) 
	{
		//New1 obj=new New1();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait1 = new WebDriverWait(driver,20);
		driver.navigate().to("http://the-internet.herokuapp.com/");
//		driver.findElement(By.xpath("//*[text()='Dropdown']")).click();
//		WebElement min=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dropdown']")));
//		Select ob=new Select(min);
//		ob.selectByVisibleText("Option 1");
	       
		
		try
		{
		HttpURLConnection obj=null;
		URL obj2;
		List<WebElement>li= wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("a")));
		for(WebElement w:li)
		{
			String url=w.getAttribute("href");
			obj2=new URL(url);//create a url from string
			obj=(HttpURLConnection) obj2.openConnection();
			obj.connect();
			int rsp=obj.getResponseCode();
			if(rsp==200)
			{
				System.out.println(url+"is working");
			}
			else
			{
				System.out.println(url+"is not working");
			}
		}
		driver.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}}
