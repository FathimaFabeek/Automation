package gitprojct;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class PomAmazn

{
	public WebDriver driver;
	static WebDriverWait wait;
	public Search searchobj;
	public Cart cartobj;
	public Signup loginobj;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String br, String ur) 
	{
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (br.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
		driver.navigate().to(ur);
		searchobj = new Search(driver);
		cartobj = new Cart(driver);
		loginobj=new Signup(driver);
	}
	
	@Test(priority=0)
	@Parameters({"userid","password"})
	public void signup(String Username,String password)
	{
		loginobj.signup();
		loginobj.mail(Username);
		loginobj.conti();
		loginobj.pass(password);
		loginobj.signin();
	}

	@Test(priority = 1)
	@Parameters("search")
	public void select(String mob) {
		searchobj.search(mob);
		searchobj.submit();
		searchobj.mobil();
		searchobj.samsng();
		searchobj.selct();
	}

	@Test(priority = 2)
	public void cart() {
		
		cartobj.addcart();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
