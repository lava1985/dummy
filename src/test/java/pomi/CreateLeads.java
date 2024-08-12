package pomi;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;

public class CreateLeads {

	public static void main(String[] args) {
		PropertiesUtility propertyUtil = new PropertiesUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility driverUtil = new WebDriverUtility();
		
		propertyUtil.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInit(IConstantPath.EXCIL_PATH);
		
		WebDriver driver = driverUtil.launchBrowser(propertyUtil.readFromProperties("browser"));
		driverUtil.maximizeBrowser();
		driverUtil.navigateToApp(propertyUtil.readFromProperties("url"));
		
		long time = (Long) jutil.convertStringToAnyDataType(propertyUtil.readFromProperties("timeouts"), 
																				DataType.LONG);
		driverUtil.waitTillElementFound(time);

		if (driver.getTitle().contains("vtiger CRM"))
			System.out.println("Login Page Displayed");
		else
			driverUtil.quitAllWindows();

		driver.findElement(By.name("user_name")).sendKeys(propertyUtil.readFromProperties("username"));
		driver.findElement(By.name("user_password")).sendKeys(propertyUtil.readFromProperties("password"));
		driver.findElement(By.id("submitButton")).submit();

		if (driver.getTitle().contains("Home"))
			System.out.println("Home Page is Displayed");
		else
			driverUtil.quitAllWindows();

		

		driver.findElement(By.xpath("//a[contains(@href,'Leads&action')]")).click();
		if(driver.getTitle().contains("Leads"))
		{
			System.out.println("Leads page is displayed");
		}
		else
		{
			driverUtil.quitAllWindows();
			}
		Map<String, String> map = excel.readFromExcel("LeadsTestData", "Create and Duplicate Lead");
		
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		WebElement pageheader= driver.findElement(By.xpath("//span[text()='Creating New Lead']"));
		if(pageheader.isDisplayed())
		{
			System.out.println("Creating  new Lead page is displayed");
		}
		else
		{
			driverUtil.quitAllWindows();			
		}
		driver.findElement(By.name("lastname")).sendKeys(map.get("Last Name"));
		driver.findElement(By.name("company")).sendKeys(map.get("Company"));
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("Duplicate")).click();
		String pagetitle=driver.findElement(By.xpath("//span[contains(text(),'Duplicating ')]")).getText();
		
		if(pagetitle.contains("Duplicating"))
		{
			System.out.println("Duplicate lead is created");
		}
		else
		{
			driverUtil.quitAllWindows();			
		}
			
        excel.saveExcel(IConstantPath.EXCIL_PATH);
		WebElement adminWidget = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverUtil.mouseHover(adminWidget);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		excel.closeExcel();
		driverUtil.quitAllWindows();
	}
		
}