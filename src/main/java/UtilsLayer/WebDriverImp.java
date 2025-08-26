package UtilsLayer;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;

import BaseLayer.BaseClass;
import IHelper.IWebDriver;

public class WebDriverImp extends BaseClass implements IWebDriver {

	@Override
	public void get(String url) {

		driver().get(url);
	}

	@Override
	public void implicitlyWait(Duration duration) {

		driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Override
	public void PageLoadTimeouts(Duration duration) {

		driver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@Override
	public void maximize() {

		driver().manage().window().maximize();
	}

	@Override
	
	public void deleteAllCookies() {
		driver().manage().deleteAllCookies();
		
	}

	@Override
	public void addArguments(String parameter) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments(parameter);
	}

}
