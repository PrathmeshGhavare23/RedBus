package PageLayer;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilsLayer.CalenderHelper;
import UtilsLayer.ElementsHelper;
import UtilsLayer.JsHelper;

public class Redbus extends BaseClass {

	@FindBy(xpath = "//div[@role='button' and .//div[text()='From']]")
	private static WebElement FromField;

	@FindBy(id = "srcDest")
	private static WebElement source_FromCity_Input;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'listHeader')]"))
	private static List<WebElement> selectValue_FromField_Dropdown;

	@FindBy(id = "srcDest")
	private static WebElement sourceToCityInput;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'listHeader')]"))
	private static List<WebElement> selectValue_ToField_Dropdown;

	@FindBy(xpath = "//div[contains(@class,'dateInputWrapper')]")
	private static WebElement Open_Calender;

	@FindBy(xpath = "//p[contains(@class,'monthYear')]")
	private static WebElement capture_Month_And_Year;

	@FindBy(xpath = "//div[contains(@class,'monthArea_')]/child::i[2]")
	private static WebElement NextButton_Month_And_Year;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'dateWrap_')]"))
	private static List<WebElement> Select_Date_Calender;

	@FindBy(xpath = "//button[contains(@class,'primaryButton')]")
	private static WebElement SearchButton;

	@FindBy(xpath = "//div[contains(text(),'Primo Bus')]")
	private static WebElement primo_Bus;

	@FindBy(xpath = "//div[starts-with(text(),'AC ')]")
	private static WebElement AC_Bus;

	@FindBys(@FindBy(xpath = "//div[contains(@class,'travelsName__')]"))
	private static List<WebElement> travelNames;

	public Redbus() {
		PageFactory.initElements(driver(), this);
	}

	static Set<String> AllOperatorNames;

	public void clickOnFromField() {
		ElementsHelper.click(FromField);
	}

	public void EnterSourceLocation(String SourceLocation) {
		ElementsHelper.sendkeys(source_FromCity_Input, SourceLocation);

	}

	public void selectSourceLocation(String expectedSourceLocation) {
		boolean matchFound = false;

		for (WebElement wb : selectValue_FromField_Dropdown) {
			String actualText = ElementsHelper.getText(wb).trim();
			if (actualText.contains(expectedSourceLocation)) {
				ElementsHelper.click(wb);
				matchFound = true;
				break;
			}
		}
		if (!matchFound) {
			System.out.println("NO matching option found for ...." + expectedSourceLocation);
		}
	}

	public void EnterDestinationLocation(String DestinationLocation) {
		ElementsHelper.sendkeys(sourceToCityInput, DestinationLocation);
	}

	public void selectDestinationLocation(String expectedDestinationLocation) {
		boolean matchFound = false;

		for (WebElement wb : selectValue_ToField_Dropdown) {
			String actualText = ElementsHelper.getText(wb).trim();
			if (actualText.contains(expectedDestinationLocation)) {
				ElementsHelper.click(wb);
				matchFound = true;
				break;
			}
		}
		if (!matchFound) {
			System.out.println("NO matching option found for ...." + expectedDestinationLocation);
		}
	}

	public void OpenCalender() {
		ElementsHelper.click(Open_Calender);
	}

	public void ExpectedDateSelector(String expectedMonthYear, String expectedDate) {
		CalenderHelper.SelectMonthAndYear(capture_Month_And_Year, NextButton_Month_And_Year, expectedMonthYear);
		CalenderHelper.selectDate(Select_Date_Calender, expectedDate);
	}

	public void SearchButton() {
		ElementsHelper.click(SearchButton);
	}

	public void searchPrimoBus() {
		ElementsHelper.click(primo_Bus);
	}

	public void searchAcBus() {
		ElementsHelper.click(AC_Bus);
	}

	public void scrollBottomPage() {
		JsHelper.scrollheight();

	}

	public void StoreOperatorNames() {
		AllOperatorNames = new LinkedHashSet<>();
		List<String> operatorNames = travelNames.stream().map(WebElement::getText)
				.filter(name -> !name.trim().isEmpty()).collect(Collectors.toList());
		AllOperatorNames.addAll(operatorNames);
	}

	public void PrintAllOperatorsAndTotal() {
		System.out.println("Total Bus Operators: " + AllOperatorNames.size());
		AllOperatorNames.forEach(System.out::println);

	}
}
