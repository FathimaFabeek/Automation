package gitprojct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search
{
	public WebDriver driver;
	public  WebDriverWait wait;
	By search1=By.xpath("//*[@id='twotabsearchtextbox']");
	By submt=By.xpath("//*[@id='nav-search-submit-text']");
	By mobil=By.xpath("//*[text()='Smartphones']");
	By samsng=By.xpath("//*[text()='Samsung']");
	By selct=By.xpath("//*[@alt='Samsung Galaxy M12 (Blue,4GB RAM, 64GB Storage) 6000 mAh with 8nm Processor | True 48 MP Quad Camera | 90Hz Refresh Rate']");
	public Search(WebDriver driver) 
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void search(String mob)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(search1)).sendKeys(mob);
	}
	public void submit()
	{
	 wait.until(ExpectedConditions.visibilityOfElementLocated(submt)).click();
	}
	public void mobil()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(mobil)).click();
	}
	public void samsng()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(samsng)).click();
	}
	public void selct()
	{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(selct)).click();
	}
}
