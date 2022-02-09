package test1;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazone {
	static WebDriverWait wait1;
	static String url = "https://www.amazon.in/";

	public void home(WebDriver driver) {
		WebElement mob = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Mobiles']")));
		mob.click();
		WebElement click1 = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Smartphones & Basic Mobiles']")));
		click1.click();
	}

	public void list(WebDriver driver) {
		driver.navigate().refresh();
		WebElement sams = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung']")));
		sams.click();
		List<WebElement> li1 = wait1
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='s-image']")));
		System.out.println("Mobiles are Listed as ");
		for (WebElement i : li1) {
			System.out.println(i.getAttribute("alt") + "\n");
		}
	}

	public void selct(WebDriver driver) {
		WebElement selct = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@alt='Samsung Guru 1200 (GT-E1200, Black)']")));
		selct.click();
	}

	public void buy(WebDriver driver) {
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		WebElement selct = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@alt='Samsung Guru 1200 (GT-E1200, Black)']")));
		if (selct.isEnabled()) {
			WebElement price = wait1
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='₹1,703.00'])[5]")));
			System.out.println("Selected Mobile Price is " + price.getText());
		}
		WebElement buy1 = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='buy-now-button']")));
		buy1.click();
		System.out.println("BUY NOW clicked");
	}

	public static void main(String[] args) {
		Amazone obj = new Amazone();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		wait1 = new WebDriverWait(driver, 5);
		driver.get(url);
		wait1 = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		obj.home(driver);
		obj.list(driver);
		obj.selct(driver);
		obj.buy(driver);
		driver.quit();
	}
}
