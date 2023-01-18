package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pomclass {
	WebDriver driver;
	
	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement loginbutton;
	
	
	
}
