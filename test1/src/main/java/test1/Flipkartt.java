package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkartt 
{
	static WebDriverWait wait1;
	
	public void hover(WebDriver driver,Actions action)
	{
		WebElement fashion=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Fashion']")));
		action.click(fashion).perform();
		WebElement woman=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Women']")));
		action.moveToElement(woman).perform();
		WebElement foot=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Footwear']")));
		action.click(foot).build().perform();
//		Action seriesOfActions;
//		seriesOfActions = action.click(fashion).moveToElement(woman).click(foot).build();
//		seriesOfActions.perform();
		}

	public void select(WebDriver driver)
	{
		WebElement min=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='_2YxCDZ'])[1]")));
		Select ob=new Select(min);
		ob.selectByVisibleText("₹500");
		WebElement max=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='_2YxCDZ'])[2]")));
		Select ob1=new Select(max);
		ob1.selectByValue("3000");
		
		List<WebElement> li = ob.getOptions();
		for (WebElement i : li) 
		{
			
			System.out.println(i.getText()+"\n");
			}
		driver.navigate().refresh();
		}
	public void doubl(WebDriver driver,Actions action)
	{
		WebElement doub=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='REEBOK'])[1]")));
		action.doubleClick(doub).build().perform();
		System.out.println("item Double clicked");
		WebElement right=driver.findElement(By.xpath("(//*[@class='_2r_T1I'])[15]"));
		action.contextClick(right).build().perform();
		System.out.println("Item Right Clicked");
	}
	
	public static void main(String[] args)
	{
		Flipkartt obj=new Flipkartt();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 wait1 = new WebDriverWait(driver,5);
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement clos=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='✕']")));
		clos.click();
		Actions action=new Actions(driver);
		obj.hover(driver,action);
		obj.select(driver);	
		driver.navigate().refresh();
		obj.doubl(driver, action);
		driver.close();

	}

}
