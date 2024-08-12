package hardCodeScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateLeads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://localhost:8888/");
	    Actions a1=new Actions(driver);
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	    driver.findElement(By.id("submitButton")).submit();
	    if(driver.getTitle().contains("Home"))
	    	System.out.println("Home page is displayed");
	    else
	    	System.out.println("scripts not valid");
	     driver.findElement(By.xpath("(//a[contains(text(),'Leads')])[1]")).click();
	     WebElement pageHeader=driver.findElement(By.xpath("//a[@class=\"hdrLink\""));
	  if(pageHeader.isDisplayed())
	    System.out.println("Create new leads page is displayed");
	  else
		  driver.quit();
	  
	  
	}

}
