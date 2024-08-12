package hardCodeScripts;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CreateORG {

	public static void main(String[] args) {
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
    driver.findElement(By.linkText("Organizations")).click();
    if(driver.getTitle().contains("Organizations"))
    	System.out.println("Organizations page is displayed");
    else
    	System.out.println("script is incorrect");
    WebElement pageHeader=driver.findElement(By.xpath("//img[@alt='Create Organization...']"));
    if(pageHeader.isDisplayed())
    	System.out.println("New Organization page is displayed");
    else
    	driver.quit();
    driver.findElement(By.xpath("//input[@class='searchBox']")).sendKeys("123");
    driver.findElement(By.xpath("(//input[contains(@type,'button')])")).submit();
    if(driver.getTitle().contains("[ ACC5] Domain - Organization Information  "))
    	System.out.println("Orgnigations information page is displayed");
    else
    	driver.quit();
   WebElement  Organizations= driver.findElement(By.xpath("//td[@class='moduleName']"));
   a1.click(Organizations).perform();
    if(driver.getTitle().contains("Organizations"))
    	System.out.println("Organizations page is displayed");
    else
    	System.out.println("script is incorrect");
    driver.findElement(By.xpath("(//input[@type="
    		+ ""
    		+ ""
    		+ "'checkbox'])[1]")).click();
    driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
    String ORG=driver.getCurrentUrl();
    if(ORG.contentEquals("http://localhost:8888/index.php?action=ListView&module=Accounts&parenttab=Marketing"))
      System.out.println("empty orgnigation page  is displayed");
    else
    	driver.quit();
    WebElement Adiministrator=driver.findElement(By.xpath("(//td[@valign='bottom'])[1]"));
    a1.moveToElement(Adiministrator).perform();
    WebElement Signout=driver.findElement(By.linkText("Sign Out"));
    a1.click(Signout).perform();
    
    
    
    
    //driver.close();
	}

}
