package gitprojct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup 
{
	
	public WebDriver driver;
	public  WebDriverWait wait;
	By signup=By.xpath("(//*[text()='Sign in'])[2]");
	By mail=By.xpath("//*[@name='email']");
	By conti=By.xpath("(//*[@id='continue'])[2]");
	By pass=By.xpath("//*[@id='ap_password']");
	By signin=By.xpath("//*[@id='signInSubmit']");
	
	public Signup(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
		}
	public void signup()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(signup)).click();
	}
	public void mail(String Username)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(mail)).sendKeys(Username);
	}
	public void conti()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(conti)).click();
	}
	public void pass(String password)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(pass)).sendKeys(password);
		
	}
	public void signin()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(signin)).click();
	}

}
