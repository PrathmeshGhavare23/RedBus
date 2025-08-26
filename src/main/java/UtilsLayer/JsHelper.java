package UtilsLayer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import BaseLayer.BaseClass;

public class JsHelper extends BaseClass {

	private static JavascriptExecutor js() {
		return (JavascriptExecutor) driver();

	}

	public static void click(WebElement wb) {
		js().executeScript("arguments[0].click();", ElementsHelper.waits(wb));
	}

	public static void clickUsingId(String id, WebElement wb) {
		js().executeScript("document.getElementById('" + id + "').click();");
	}

	public static void sendKeys(WebElement wb, String value) {
		js().executeScript("arguments[0].value= '" + value + "';", ElementsHelper.waits(wb));
	}

	public static void sendkeysUsingId(String id, WebElement wb, String value) {
		js().executeScript("document.getElementById('" + id + "').value ='" + value + "';");
	}

	public static void scrollDown(WebElement wb) {
		js().executeScript("arguments[0].scrollIntoView();", wb);
	}

	public static void scrollheight() {
		js().executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
}
