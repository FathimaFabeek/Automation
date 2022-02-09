package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Iframe1
{
	static WebDriverWait wait1;
	static WebDriver driver;

	public void iframe(WebDriver driver)
	{
		//driver.navigate().to("https://the-internet.herokuapp.com/iframe");
		 WebElement w=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
		 driver.switchTo().frame(w);
		 WebElement w1=driver.findElement(By.xpath("//body[@id='tinymce']"));
		 w1.sendKeys("TESTVOXXX");
			System.out.println(w1.getText());
			w1.clear();
		driver.switchTo().defaultContent();
		 WebElement w2= driver.findElement(By.xpath("//*[text()='File']"));
		w2.click();
}

	public static void main(String[] args)
	{
		Iframe1 obj=new Iframe1();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		 op.addArguments("start-maximized");
		wait1 = new WebDriverWait(driver,5);
		driver.navigate().to("https://the-internet.herokuapp.com/iframe");
	    obj.iframe(driver);
	    driver.close();

	}

}
