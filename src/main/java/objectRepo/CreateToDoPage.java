package objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.DataType;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;

/**
 * this class contains ,elements,locators and respective business libraries of
 * create to do page
 * 
 */
public class CreateToDoPage {
//declaration
	@FindBy(name = "subject")
	private WebElement subjectTF;

	@FindBy(id = "jscal_trigger_date_start")
	private WebElement startDateWidget;
	@FindBy(xpath = "//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")
	private WebElement calenderTitle;
	private String calendarCommonPath = "//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='%s']";

	@FindBy(id = "jscal_trigger_due_date")
	private WebElement dueDateWidget;
	@FindBy(xpath = "//input[@value='  Save']")
	private WebElement saveBTN;

//	Initilization
	public CreateToDoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilizatiuon
	public void setSubject(String subject) {
		subjectTF.sendKeys(subject);
	}

	/**
	 * this method clicks on the start date clender widget
	 */

	public void clickStartDateWidget() {
		startDateWidget.click();
	}

	/**
	 * this method clicks on the d date clender widget
	 */
	public void clickDueDateWidget() {
		dueDateWidget.click();
	}

	/**
	 * this method picks required date from calendar
	 * 
	 * @param calendarCommonPath
	 * 
	 */
	public void datePicker(JavaUtility jutil, WebDriverUtility driverUtil, String reqDate) {
		String[] startDate = jutil.splitString(reqDate, "-");
		int reqStartYear = (Integer) jutil.convertStringToAnyDataType(startDate[0], DataType.INT);
		String reqStartDate = startDate[2];
		int reqStartMonth = jutil.convertMonthToInt(startDate[1]);

		String currentMonthYear = calenderTitle.getText();
		String[] str = jutil.splitString(currentMonthYear, ", ");
		int currentYear = (Integer) jutil.convertStringToAnyDataType(str[1], DataType.INT);

		while (currentYear < reqStartYear) {
			driverUtil.convertDynamicXpathToWebElement(calendarCommonPath, "»").click();

			currentMonthYear = calenderTitle.getText();
			str = jutil.splitString(currentMonthYear, ", ");
			currentYear = (Integer) jutil.convertStringToAnyDataType(str[1], DataType.INT);
		}

		int currentMonth = jutil.convertMonthToInt(str[0]);

		while (currentMonth < reqStartMonth) {
			driverUtil.convertDynamicXpathToWebElement(calendarCommonPath, "›").click();
			currentMonthYear = calenderTitle.getText();
			str = jutil.splitString(currentMonthYear, ", ");
			currentMonth = jutil.convertMonthToInt(str[0]);
		}

		while (currentMonth > reqStartMonth) {
			driverUtil.convertDynamicXpathToWebElement(calendarCommonPath, "‹").click();
			currentMonthYear = calenderTitle.getText();
			str = jutil.splitString(currentMonthYear, ", ");
			currentMonth = jutil.convertMonthToInt(str[0]);
		}

		driverUtil.convertDynamicXpathToWebElement(calendarCommonPath, reqStartDate).click();
	}

	/**
	 * This method clicks on save button
	 */
	public void clickSaveBTN() {
		saveBTN.click();
	}

}
