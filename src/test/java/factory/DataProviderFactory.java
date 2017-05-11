package factory;

import java.io.File;
import java.io.IOException;

import dataprovider.ConfigFileReader;
import dataprovider.ExcelReader;

public class DataProviderFactory {
	
	public static ExcelReader getExcel() throws IOException
	{
		
		ExcelReader excelreader = new ExcelReader();
		return excelreader;
	}
	public static ConfigFileReader getConfig() throws IOException
	{
		ConfigFileReader config = new ConfigFileReader();
		return config;
	}

}
