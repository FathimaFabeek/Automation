package test1;

import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkar1 {

	static WebDriverWait wait1;

	static String url = "https://www.flipkart.com/";

	public void home1(WebDriver driver, Actions action) {
		WebElement we1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[text()='Mobiles'])[1]")));
		we1.click();
		driver.navigate().refresh();
		WebElement electr = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Electronics']")));
		action.moveToElement(electr).build().perform();
		WebElement sams = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung']")));
		sams.click();
		WebElement view = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='VIEW ALL'])[1]")));
		view.click();
		String ur = driver.getCurrentUrl();
		System.out.println("URL is " + ur);
		System.out.println("************************************************");
	}

	public void list(WebDriver driver)// printing list of mobiles
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebElement popu = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Popularity']")));
		popu.click();
		driver.navigate().refresh();
		List<WebElement> li = wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("_4rR01T")));// *[@class='_4rR01T']
		System.out.println("No of Mobiles is " + li.size());
		for (WebElement i : li) 
		{
			System.out.println(i.getText()+"\n");
		}
		System.out.println("************************************************");
		}
	public void selectmobil(WebDriver driver) // selecting product
	{
		WebElement selct = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SAMSUNG Galaxy F12 (Sky Blue, 64 GB)']")));

		if (selct.isDisplayed()) {
			String price = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='₹11,499'])[1]"))).getText();
			System.out.println("Price is " + price);
		}
		selct.click();

		System.out.println("************************************************");
		
	}

	public void buy(WebDriver driver) // clicking buy now
	{
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		WebElement buy = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='NOTIFY ME']")));
		buy.click();
		System.out.println("Clicked on Notify");
		driver.findElement(By.xpath("//*[text()='Allow']")).click();
	}

	public static void main(String[] args) throws InterruptedException {
		Flipkar1 obj = new Flipkar1();

		ChromeOptions op=new ChromeOptions();
		op.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(op);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		wait1 = new WebDriverWait(driver,5);
		driver.navigate().to(url);
		driver.findElement(By.xpath("//*[text()='✕']")).click();
		Actions action = new Actions(driver);
		obj.home1(driver, action);
		obj.list(driver);
		obj.selectmobil(driver);
		obj.buy(driver);
		driver.quit();
	}
}
