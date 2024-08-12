package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventInfomationPage {
	//declaration
	@FindBy (xpath="//span[@class=lvtheaderText]")
	private WebElement pageHeader;
	 @FindBy (xpath="//input[@name='Delete']")
	private WebElement deleteBTN;
	 
	
// inisialization
	 public EventInfomationPage(WebDriver driver){
		 PageFactory.initElements(driver,this);
	 }
	 //utilization
	 /**
	  * this method returns page header
	  */
	 public String getPageHeader() {
		return pageHeader.getText();
		
	}
	 /**
	  * this method clicks on delete method
	  */
	 public void clickDeleteBTN() {
		deleteBTN.click();
	}
}
