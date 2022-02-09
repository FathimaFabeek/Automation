package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facbk 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait1 = new WebDriverWait(driver,50);
		driver.navigate().to("https://www.facebook.com/");
		WebElement w1=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']")));
		w1.sendKeys("fathima");
		WebElement w2=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pass']")));
		w2.sendKeys("45864");
		WebElement login=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Log In'])[1]")));
		login.sendKeys(Keys.ENTER);
		driver.close();
		

	}

}
