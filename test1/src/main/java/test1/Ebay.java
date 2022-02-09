package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ebay {
	static WebDriverWait wait1;

	static String url = "https://www.ebay.com/";

	public void home(WebDriver driver, Actions action) {
		WebElement electr = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Electronics'])[2]")));
		action.moveToElement(electr).build().perform();
		WebElement sams = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung']")));
		sams.click();
		WebElement phones = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung Cell Phones and Smartphones']")));
		phones.click();
	}

	public void list(WebDriver driver) {
		List<WebElement> list = wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@class='s-item__title s-item__title--has-tags']")));
		for (WebElement i : list) 
		{
			System.out.println(i.getText()+"\n");
		}
	}

	public void selct(WebDriver driver) {
		WebElement selct = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@alt='Samsung Galaxy S5 Smartphone 16GB SM-G900T Cracked Screen AS-IS Parts']")));

		if (selct.isDisplayed()) {
			String price = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='$129.99']"))).getText();
			System.out.println("Price is " + price);
		}
		selct.click();
	}

	public void buy(WebDriver driver) {
		WebElement buy = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='binBtn_btn']")));
		buy.click();
		System.out.println("product carted");
		WebElement check = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign in to check out']")));
		check.click();
	}

	public static void main(String[] args) {
		Ebay obj = new Ebay();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		wait1 = new WebDriverWait(driver, 5);
		driver.get(url);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		obj.home(driver, action);
		obj.list(driver);
		obj.selct(driver);
		obj.buy(driver);
		driver.close();
	}
}
