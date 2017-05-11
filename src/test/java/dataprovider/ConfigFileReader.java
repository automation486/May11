package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader{
	
	static Properties pro;
	static FileInputStream fis;
	public ConfigFileReader()  throws IOException
	{
		File src = new File("./Configuration/config.properties");
		
		
		try {
			fis = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pro = new Properties();
		pro.load(fis);
	}
		public static String getChromeDriver()
		{
			String chromedriver = pro.getProperty("chromedriver");
			return chromedriver;
		}
		public static String getIEDriver()
		{
			String iedriver = pro.getProperty("iedriver");
			return iedriver;
		}
		public static String getGeckoDriver()
		{
			String geckodriver = pro.getProperty("geckodriver");
			return geckodriver;
		}
	
	
		public String getURL()
		{
			String url = pro.getProperty("url");
			return url;
		}
		public String getEdgeDriver() {
			String edgedriver = pro.getProperty("edgedriver");
			return edgedriver;
		}
	

}
