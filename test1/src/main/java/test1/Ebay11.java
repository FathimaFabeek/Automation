package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ebay11
{
	static WebDriverWait wait1;

	static String url = "https://www.ebay.com/";
	public void home(WebDriver driver, Actions action)
	{
		WebElement electr = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Electronics'])[2]")));
		action.moveToElement(electr).perform();
		WebElement sams = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung']")));
		action.click(sams).perform();
		WebElement phones = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung Cell Phones and Smartphones']")));
		action.click(phones).build().perform();
		List<WebElement> list = wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='s-item__title s-item__title--has-tags']")));
		for (WebElement i : list) 
		{
			System.out.println(i.getText()+"\n");
		}
	}

	public static void main(String[] args)
	{
		Ebay11 obj = new Ebay11();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		wait1 = new WebDriverWait(driver, 5);
		driver.get(url);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		obj.home(driver, action);

	}

}
