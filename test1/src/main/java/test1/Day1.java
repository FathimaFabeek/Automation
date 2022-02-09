package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1
{
	static String url;

	public void func(String username, String passwrd, WebDriver driver) 
	{
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(passwrd);
		driver.findElement(By.id("login-button")).click();
	}

	public void url1(String username, WebDriver driver) throws InterruptedException 
	{
		Thread.sleep(5000);
		String expurl = "https://www.saucedemo.com/inventory.html";
		String acturl = driver.getCurrentUrl();
		if (expurl.equals(acturl)) 
		{
			System.out.println(username + " is working");
		} else
		{
			System.out.println(username + " is not working");
		}}
	public static void main(String[] args) throws InterruptedException
	{
		Day1 obj = new Day1();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91984\\eclipse-workspace\\selenium project\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		url = "https://www.saucedemo.com/";
		driver.manage().window().maximize();
		Thread.sleep(5000);
		obj.func("standard_user", "secret_sauce", driver);
		obj.url1("standard_user", driver);

		obj.func("locked_out_user", "secret_sauce", driver);
		obj.url1("locked_out_user", driver);

		obj.func("problem_user", "secret_sauce", driver);
		obj.url1("problem_user", driver);

		obj.func("performance_glitch_user", "secret_sauce", driver);
		obj.url1("performance_glitch_user", driver);

		obj.func("admin", "secret_sauce", driver);
		obj.url1("admin", driver);

		driver.close();
		}
}
