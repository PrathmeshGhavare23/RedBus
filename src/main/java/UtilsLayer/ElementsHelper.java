package UtilsLayer;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseLayer.BaseClass;

public class ElementsHelper extends BaseClass {

	public static WebElement waits(WebElement wb) {
		return new WebDriverWait(driver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(wb));
	}

	public static void click(WebElement wb) {
		new WebDriverWait(driver(), Duration.ofSeconds(30))
		.until(ExpectedConditions.elementToBeClickable(wb)).click();
	}

	public static void submit(WebElement wb) {
		new WebDriverWait(driver(), Duration.ofSeconds(30))
		.until(ExpectedConditions.elementToBeClickable(wb)).submit();
	}

	public static void clear(WebElement wb) {
		waits(wb).clear();
	}

	public static void sendkeys(WebElement wb, String value) {
		waits(wb).sendKeys(value);
	}

	public static String getText(WebElement wb) {
		return waits(wb).getText();
	}

	public static String getAttribute(WebElement wb, String attribute) {
		return waits(wb).getDomAttribute(attribute);
	}

	public static boolean DisplayStatus(WebElement wb) {
		return waits(wb).isDisplayed();
	}

	public static boolean EnabledStatus(WebElement wb) {
		return waits(wb).isEnabled();
	}

	// check Element Selected status
	public static boolean SelectedStatus(WebElement wb) {
		return waits(wb).isSelected();
	}
	
	public static String CaptureCurrentURL() {
		return driver().getCurrentUrl();
	}
	
	public static String CaptureCurrentTitle() {
		return driver().getTitle();
	}
	
	
	

}
