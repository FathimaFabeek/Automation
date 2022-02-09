package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chroption 
{
	static WebDriver driver;
	 static WebDriverWait wait1;
	static String url = "https://www.amazon.in/";

	public static void main(String[] args)
	{
		DesiredCapabilities obj=DesiredCapabilities.chrome();
		//obj.setBrowserName("firefox");
		
		ChromeOptions op=new ChromeOptions();
		op.addArguments("start-maximized");
		//op.setHeadless(true);
		op.addArguments("version");
		op.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(op);
		
		wait1 = new WebDriverWait(driver,5);
		driver.navigate().to(url);
		System.out.println("driver closed");
		driver.close();

	}

}
