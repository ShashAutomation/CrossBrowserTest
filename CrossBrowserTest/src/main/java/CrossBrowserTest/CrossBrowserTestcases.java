package CrossBrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTestcases {

	WebDriver driver;
	@Test
	@Parameters("browser")
	public void titleTest(String Browsername)
	{
		if(Browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\selenium projects\\seleniumtestngprojects\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("Google Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\selenium projects\\seleniumtestngprojects\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("Internet Explorer"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\selenium projects\\seleniumtestngprojects\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else if(Browsername.equalsIgnoreCase("Opera Browser"))
		{

			System.setProperty("webdriver.opera.driver", "F:\\selenium projects\\seleniumtestngprojects\\operadriver.exe");
			driver=new OperaDriver();
		}
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Facebook – log in or sign up","Title not matched");
		driver.quit();
	}
}
