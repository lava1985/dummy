package chromeoptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.prefs.PreferenceChangeEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import pratice.d;
//Test
public class HandleAnyNotificationns{
@Test
public void handleNotifications() throws InterruptedException
{
	//test handleNotifications
	HashMap<String,Integer> contentsetting= new HashMap<>();
	HashMap<String,Object> profile= new HashMap<>();
	HashMap<String,Object> pereference= new HashMap<>();
	
	contentsetting.put("meida_stream",1);
	contentsetting.put("notification",2);
	contentsetting.put("geolocation",1);
	profile.put("managed_default_content_setting",contentsetting);
	pereference.put("profile", profile);
	
	ChromeOptions options =new ChromeOptions();
	options.setExperimentalOption("prefs", pereference);
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://webcamtests.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("webcam-lancher")).click();
	Thread.sleep(4000);
	driver.quit();
	
	
}
}
