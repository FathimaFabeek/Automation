package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drop
{
	static WebDriver driver;
	 static WebDriverWait wait1;
	static String url = "https://www.amazon.in/";
	public void dropdown(WebDriver driver)
	{
		WebElement dr=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchDropdownBox']")));
		Select obj=new Select(dr);
		obj.selectByVisibleText("Amazon Fashion");
		List<WebElement> li = obj.getOptions();
		for (WebElement i : li) 
		{
			System.out.println(i.getText()+"\n");
		}}
	

	public static void main(String[] args) 
	{
		Drop obj = new Drop();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		wait1 = new WebDriverWait(driver,10);
		driver.get(url);
		driver.manage().window().maximize();
		obj.dropdown(driver);
		driver.close();
		

	}

}
