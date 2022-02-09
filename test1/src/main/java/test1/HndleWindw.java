package test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HndleWindw
{
	public void windw(WebDriver driver)
	{
		driver.findElement(By.xpath("//*[text()='Multiple Windows']")).click();
		String Parntw=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[text()='Click Here']")).click();
		Set<String> st=driver.getWindowHandles();
		for(String handle:st)
		{
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("New Window"))
			{
				System.out.println(driver.findElement(By.tagName("h3")).getText());
			}
		}
	}

	public static void main(String[] args)
	{
		HndleWindw obj=new HndleWindw();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/");
		obj.windw(driver);
		
		

	}

}
