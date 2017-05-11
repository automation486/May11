package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.FileUtils;

public class CaptureScreenShot {
	
	
	//static WebDriver driver;

	public static String getScreenshot(WebDriver driver, String screenshotname) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = "C:\\Users\\Rai\\workspace\\NewFramework425\\com.project1.project\\Screenshots"+screenshotname+System.currentTimeMillis()+"\\screenshots.png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(dest));
		return dest;
	
	}
}
