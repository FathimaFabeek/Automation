package test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Locatr1 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\91984\\eclipse-workspace\\selenium project\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='✕']")).click();
		Actions action = new Actions(driver);
		WebElement electr=driver.findElement(By.xpath("//*[@alt='Electronics']"));
		action.moveToElement(electr).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='MobileAccessory']")).click();
		Thread.sleep(5000);
		WebElement electr1=driver.findElement(By.xpath("//*[text()='Electronics']"));
		action.moveToElement(electr1).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Mi']")).click();
		Thread.sleep(5000);
		// driver.findElement(By.xpath("(//*[text()='Xiaomi 11i 5G (Purple Mist, 128 GB)'])[1]")).click();
//		 driver.findElement(By.xpath("//*[@id='pincodeInputId']")).sendKeys("680516");
//     	 driver.findElement(By.xpath("//*[text()='Check']")).click();
		// driver.findElement(By.xpath("//*[text()='BUY NOW']")).click();
		 
//		String handle = driver.getWindowHandle();
//		 Set<String> handles = driver.getWindowHandles();
//		 handles.remove(handle);
//		 String newhandle=handles.iterator().next();
//		 driver.switchTo().window(newhandle);
		
//      	//driver.findElement(By.linkText("Mi")).click();

      	//           driver.close();
		

	}

}
