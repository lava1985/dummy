package pomi;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.DataType;
import genericUtilities.ExcelUtility;
import genericUtilities.IConstantPath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;

public class Create_industry {

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
		
		driver.findElement(By.xpath("//a[contains(@href,'Accounts&action=index')]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Organization page is Displayed");
		else
			driverUtil.quitAllWindows();
		
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "Create Organization With Industry And Type");
		
		
		
		WebElement plus=driver.findElement(By.xpath("//img[@alt='Create Organization...']"));
		plus.click();
		
		WebElement createneworg=driver.findElement(By.className("lvtHeaderText"));
		createneworg.click();
		if(createneworg.isDisplayed())
			System.out.println("create new organization page is Displayed");
		else
			System.out.println("create new organization page is not Displayed");
		
		driver.findElement(By.name("accountname")).sendKeys(map.get("Organization Name"));
		WebElement industry=driver.findElement(By.name("industry"));
		Select s1=new Select(industry);
		s1.selectByVisibleText(map.get("Industry"));
		
		WebElement Type=driver.findElement(By.name("accounttype"));
		Select s2=new Select(Type);
		s2.selectByVisibleText(map.get("Type"));
		
		WebElement save=driver.findElement(By.xpath("(//input[contains(@name,'button')])[1]"));
		save.click();
		
		String neworgheader=driver.findElement(By.className("dvHeaderText")).getText();
		if(neworgheader.contains(map.get("Organization Name")))
			System.out.println("organization created successfully");
		else
			System.out.println("organization is not created successfully");
		
		driver.findElement(By.xpath("(//input[@name='Delete'])[1]")).click();
		driver.switchTo().alert().accept();
		if(driver.getTitle().contains("organizations"))
			System.out.println("organization page is Displayed");
		
		
		excel.saveExcel(IConstantPath.EXCIL_PATH);
		WebElement adminWidget = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverUtil.mouseHover(adminWidget);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		excel.closeExcel();
		driverUtil.quitAllWindows();
	}

}