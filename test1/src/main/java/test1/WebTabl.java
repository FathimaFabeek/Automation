package test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTabl 
{
	static int count=0;
	static WebDriver driver;
	static WebDriverWait wait1;
	public void tabl(WebDriver driver)
	{
		WebElement tabl=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));  //table
		List<WebElement> rows=tabl.findElements(By.xpath("//tbody//tr"));  //rows
		for(WebElement row:rows)  //to print column 3
		{
			List<WebElement> col=row.findElements(By.tagName("td"));
			String col1=col.get(0).getText();
      		if(col1.equalsIgnoreCase("Kwality"))
      		{
      			System.out.println("Current price is "+col.get(3).getText());//481
      		}
		}
		}
	public void printabl(WebDriver driver)  //to print table
	{
		WebElement tabl=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));  //table
		List<WebElement> rows=tabl.findElements(By.xpath("//tbody//tr"));  //rows
		System.out.println("Table printing");
		List<WebElement> head=tabl.findElements(By.xpath("//table//th"));
		for (WebElement hd : head) 
		{
			System.out.print(hd.getText() + "||");

			}
		System.out.println();
		for(WebElement row:rows)
		{
			List<WebElement> col=row.findElements(By.tagName("td"));
			
			for (WebElement cols : col) 
			{
				System.out.print(cols.getText() + " ");

				}
			System.out.println();
		}}
	public void selct(WebDriver driver)
	{
		
		
	}

	public static void main(String[] args) 
	{
		WebTabl obj=new WebTabl();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 wait1 = new WebDriverWait(driver,10);
		driver.navigate().to("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
		obj.tabl(driver);
		obj.printabl(driver);
		driver.close();

	}

}
