package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[text()='Home']")WebElement homelink;
	@FindBy(xpath="//a[text()='My Account']")WebElement myaccountlink;
	@FindBy(xpath="//a[text()='Log In']")WebElement loginlink;
	
	public void clickLink()
	{
		homelink.click();
	}
	public void clickMyAccountLink()
	{
		myaccountlink.click();
	}
	public void clickLoginLink()
	{
		loginlink.click();
	}
	public String getApplicationTitle()
	{
		return driver.getTitle();
	}
	
}
