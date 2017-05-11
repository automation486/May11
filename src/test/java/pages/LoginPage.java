package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath=".//*[@id='account_sign_in_form_email_id']")WebElement username;
	@FindBy(xpath=".//*[@id='account_sign_in_form_passwd_id']")WebElement password;
	@FindBy(xpath=".//*[@id='send2']")WebElement submitbutton;
	//@Findby(xpath="//a[text()='Log Out']")WebElement logOutLinkText;
	By LogOutLinkText = By.xpath("//a[text()='Log Out']");
	
	public void loginApplication(String uname,String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		submitbutton.click();
	}
	
	public String getLogOutLinkText()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(LogOutLinkText));
		String logoutlinktext = ele.getText();
		return logoutlinktext;
	}
	

}
