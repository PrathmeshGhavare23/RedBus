package UtilsLayer;

import java.util.List;

import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class CalenderHelper extends BaseClass {

	public static void SelectMonthAndYear(WebElement MonthYear, WebElement next, String expectedMonthYear) {
		while (true) {
			String actualMonthYear = ElementsHelper.getText(MonthYear);
			if (actualMonthYear.equalsIgnoreCase(expectedMonthYear)) {
				break;
			} else {
				ElementsHelper.click(next);
			}
		}
	}

	public static void selectDate(List<WebElement> listDate, String expectedDate) {
		for (WebElement wb : listDate) {
			String actualDate = ElementsHelper.getText(wb);

			if (actualDate.equalsIgnoreCase(expectedDate)) {
				ElementsHelper.click(wb);
				break;
			}
		}
	}
}
