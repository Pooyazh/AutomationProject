package testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleLogins {
	
	static ChromeDriver driver=null;
	
	@DataProvider(name = "excel-data")

	public Object[][] excelDP() throws IOException {

		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system

		Object[][] arrObj = getExcelData("C:\\Users\\kuzha\\OneDrive\\Desktop\\Testdata.xlsx", "Sheet1");

		return arrObj;

	}
	public Object[][] getExcelData(String fileName, String sheetName) {

		Object[][] data = null;

		try

		{

			FileInputStream fis = new FileInputStream(fileName);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sh = wb.getSheet(sheetName);

			XSSFRow row = sh.getRow(0);

			int noOfRows = sh.getPhysicalNumberOfRows();

			int noOfCols = row.getLastCellNum();

			Cell cell;

			data = new String[noOfRows - 1][noOfCols];

			for (int i = 1; i < noOfRows; i++) {

				for (int j = 0; j < noOfCols; j++) {

					row = sh.getRow(i);

					cell = row.getCell(j);

					try {
						
						data[i - 1][j] = cell.getStringCellValue();
						
					} catch (Exception e) {
						
						data[i - 1][j] = ("" + cell.getNumericCellValue()).replace(".0", "").trim();
					}

				}

			}

		}

		catch (Exception e) {

			System.out.println("The exception is: " + e.getMessage());

		}

		return data;

	}


@Test(dataProvider = "excel-data")
	public void Login(String username, String password) throws InterruptedException, IOException {


		System.out.println(username + " " + password);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kuzha\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		LeadsPage leadsPage=PageFactory.initElements(driver, LeadsPage.class);
		driver.get("https://accounts.zoho.in/signin?servicename=ZohoCRM&signupurl=https://www.zoho.com/crm/signup.html&serviceurl=https%3A%2F%2Fcrm.zoho.in%2Fcrm%2FShowHomePage.do%3Fref_value%3Dgoogle%253Asheet%257Cgoogle%253Acrm%257Cdirect%253Acrm%252Chttps%253A%252F%252Fwww.zoho.com%252Fcrm%252Flp%252Ft-ee-logout.html%252Ce49779ec-f73b-4a28-a488-00a48c0d0f75_c179%252CDesktop%252Chttps%253A%252F%252Fwww.zoho.com%252Fcrm%252Flp%252Ft-ee-logout.html");
		Thread.sleep(2000);
		leadsPage.login.sendKeys(username);
		leadsPage.Next.click();
		leadsPage.password.sendKeys(password);
		leadsPage.Signin.click();
		Thread.sleep(5000);
		captureEleScreenshot();

	}
	
	  public static void captureEleScreenshot() throws IOException {
	  
	  Date d = new Date(); String fileName = d.toString().replace(":",
	  "_").replace(" ", "_") + ".jpg";
	  
	  File screenshot = ((TakesScreenshot)
	  driver).getScreenshotAs(OutputType.FILE);
	  
	  BufferedImage fullImg = ImageIO.read(screenshot);
	  
	  
	  ImageIO.write(fullImg, "jpg", screenshot);
	  
	  File screenshotLocation = new File(".\\screenshot\\" + fileName);
	  FileUtils.copyFile(screenshot, screenshotLocation);
	 
	 }
	 }
