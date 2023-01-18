package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase1 {
	static ChromeDriver driver;
	@BeforeTest
	public void Lauching() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\kuzha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String realtitle=driver.getTitle();
		String expectedtitle="Swag Labs";
		Assert.assertEquals(realtitle, expectedtitle);
		System.out.println("Browser has been started Successfully");
	
	}

	@Test
	public void Loginuser() {
		//Commenting for test
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\kuzha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 * ChromeDriver driver=new ChromeDriver();
		 * driver.get("https://www.saucedemo.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 */
		//Pomclass pomclass=PageFactory.initElements(driver, Pomclass.class);
		//pomclass.username.sendKeys("standard_user");
		//pomclass.password.sendKeys("secret_sauce");
		//pomclass.loginbutton.click(); 
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String expectedurl="https://www.saucedemo.com/inventory.html";
		String realurl=driver.getCurrentUrl();
		Assert.assertEquals(realurl, expectedurl);
		System.out.println("User logged in Successfully");
	}

	@Test
	public void Addtocart() throws InterruptedException {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\kuzha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 * ChromeDriver driver=new ChromeDriver();
		 * driver.get("https://www.saucedemo.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 */
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		//boolean result=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).isEnabled();
		String items=(driver.findElement(By.tagName("span")).getText());
		int itemcount=Integer.parseInt(items);
		System.out.println("Added to cart successfully");
		Assert.assertEquals(itemcount, 0);
	}
		
		@Test
		public void Logout() throws InterruptedException {
			/*
			 * System.setProperty("webdriver.chrome.driver",
			 * "C:\\Users\\kuzha\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 * ChromeDriver driver=new ChromeDriver();
			 * driver.get("https://www.saucedemo.com/");
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 */
			/*
			 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
			 * driver.findElement(By.id("password")).sendKeys("secret_sauce");
			 * driver.findElement(By.id("login-button")).click();
			 */
			//driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
            driver.findElement(By.id("logout_sidebar_link")).click();
            System.out.println("Logged out successfully");

	}

}
