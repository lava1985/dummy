package adistionalSenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJet {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--Disable-GEOLOACATION");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[contains(@class,'1v8vaea r-eqz5dr ')]"));
driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']"));
	}

}
