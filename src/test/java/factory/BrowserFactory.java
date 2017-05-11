package factory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataprovider.ConfigFileReader;

public class BrowserFactory {
	
	static WebDriver driver;
	public static WebDriver getBrowser(String webBrowser) throws IOException
	{
		if(webBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", DataProviderFactory.getConfig().getGeckoDriver());
			driver = new FirefoxDriver();
		}
		else if(webBrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromeDriver());
			driver = new ChromeDriver();
		}
		else if(webBrowser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEDriver());
			driver = new InternetExplorerDriver();
		}
		else if(webBrowser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", DataProviderFactory.getConfig().getEdgeDriver());
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
