package testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage {
	
	WebDriver driver;
	
	@FindBy(name="LOGIN_ID")
	public WebElement login;
	
	@FindBy(id="nextbtn")
	public WebElement Next;
	
	@FindBy(xpath="//input[@name='PASSWORD']")
	public WebElement password;
	
	@FindBy(xpath="//button[@id='nextbtn']")
	public WebElement Signin;
	
	@FindBy(xpath="//div[@data-zcqa='tab_Leads']")
	public WebElement Leadstab;
	
	@FindBy(xpath="//button[@data-zcqa='cv_createbtn']")
	public WebElement CreateLead;
	
	@FindBy(xpath="(//input[@id='inputId'])[2]")
	public WebElement Companytextbox;
	
	@FindBy(xpath="//input[@id='Crm_Leads_LASTNAME_LInput']")
	public WebElement Lastnametextbox;
	
	@FindBy(xpath="//input[@id='Crm_Leads_FIRSTNAME_LInput']")
	public WebElement Firstnametextbox;
	
	@FindBy(xpath="//input[@id='Crm_Leads_EMAIL_LInput']")
	public WebElement Emailtextbox;
	
	@FindBy(xpath="//input[@id='Crm_Leads_MOBILE_LInput']")
	public WebElement Mobiletextbox;
	
	@FindBy(xpath="//button[@id='crm_create_savebutn']")
	public WebElement Savebutton;
	
	@FindBy(xpath="//button[@data-zcqa='profilePicture']")
	public WebElement Profilepicture;
	
	@FindBy(xpath="//button[@data-zcqa='profilePicture_signOut']")
	public WebElement SignOut;
	
}
