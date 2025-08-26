package BaseLayer;

import java.time.Duration;
import UtilsLayer.DriverFactory;
import UtilsLayer.PropertiesHelper;
import UtilsLayer.WebDriverImp;

public class BaseClass extends DriverFactory {

	public static void intialization(String browsername) {

		setDriver(browsername);

		WebDriverImp webdriver = new WebDriverImp();
		webdriver.maximize();
		webdriver.implicitlyWait(Duration.ofSeconds(30));
		webdriver.PageLoadTimeouts(Duration.ofSeconds(30));
		webdriver.deleteAllCookies();
		webdriver.addArguments("disable-infobars");
		webdriver.addArguments("disable-notifications");

		String url = PropertiesHelper.getProperty("URL", "config.properties");
		webdriver.get(url);

	}

}
