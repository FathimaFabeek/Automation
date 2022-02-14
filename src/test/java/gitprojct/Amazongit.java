package gitprojct;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Set;


public class Amazongit
{
	public WebDriver driver;
	static WebDriverWait wait;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String br,String ur) {
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		} 
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	    if(br.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		driver.navigate().to(ur);
	}

	@Test
	 //@Parameters({"userid","password","search"})
	@Parameters("search")
	public void list(String searchd) {
		
		wait = new WebDriverWait(driver, 10);
		WebElement search1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='twotabsearchtextbox']")));
		search1.sendKeys(searchd);
		WebElement sbmt = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-search-submit-text']")));
		sbmt.click();
		WebElement mobil = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Smartphones']")));
		mobil.click();
		WebElement sams = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Samsung']")));
		sams.click();
		
		WebElement select = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[@alt='Samsung Galaxy M12 (Blue,4GB RAM, 64GB Storage) 6000 mAh with 8nm Processor | True 48 MP Quad Camera | 90Hz Refresh Rate']")));
		select.click();
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebElement cart = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Add to Cart']")));
		 js.executeScript("arguments[0].scrollIntoView();",cart);
		actions.click(cart).perform();
		WebElement cart1=wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=' Cart ']")));
		actions.click(cart1).perform();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

 
}
