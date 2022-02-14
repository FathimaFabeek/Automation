package gitprojct;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart 
{
	public WebDriver driver;
	public  WebDriverWait wait;
	By addcart=By.xpath("//*[text()='Add to Cart']");
	//By cartF=By.xpath("//*[text()=' Cart ']");
	
	public Cart(WebDriver driver) 
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}
	public void addcart()
	{
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle = handles.iterator().next();
		driver.switchTo().window(newhandle);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions actions = new Actions(driver);
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(addcart));
		 js.executeScript("arguments[0].scrollIntoView();",cart);
		actions.click(cart).perform();
//		WebElement cart1=wait.until(ExpectedConditions.visibilityOfElementLocated(cartF));
//		actions.click(cart1).perform();
	}

}
