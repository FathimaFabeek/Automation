package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tabl 
{
	static WebDriver driver;
	static WebDriverWait wait1;
	public void print(WebDriver driver)
	{
		WebElement tabl=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
		List<WebElement> rows=tabl.findElements(By.xpath("//table//tr")); 
		System.out.println("Table is printing");//rows
		for(WebElement row:rows)
		{
			List<WebElement> col=row.findElements(By.tagName("td"));
			for(WebElement colm:col)
			{
			System.out.print(colm.getText()+" ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) 
	{
		Tabl obj=new Tabl();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 wait1 = new WebDriverWait(driver,10);
		driver.navigate().to("https://demo.guru99.com/test/table.html");
		driver.manage().window().maximize();
		obj.print(driver);
		driver.close();

	}

}
