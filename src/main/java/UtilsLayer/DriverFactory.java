package UtilsLayer;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> td = new ThreadLocal<WebDriver>();

	public static WebDriver driver() {
		return td.get();
	}

	public static void setDriver(String browsername) {
//		logger = LogManager.getLogger("GUITest");
//		logger.info("Reading the Application Configuration...");
		
		if (browsername.equalsIgnoreCase("Chrome")) {
			td.set(new ChromeDriver()); 
			// logger.info("Open Chrome Browser...");
		} else if (browsername.equalsIgnoreCase("Edge")) {
			td.set(new EdgeDriver());
//			logger.info("Open Edge Browser...");
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			td.set(new FirefoxDriver());
//			logger.info("Open FireFox Browser...");
		} else if (browsername.equalsIgnoreCase("icognito")) {
			td.set(new ChromeDriver(new ChromeOptions().addArguments("--incognito")));
//			logger.info("Open Incognito Browser...");
		} else if (browsername.equalsIgnoreCase("headless")) {
			td.set(new ChromeDriver(new ChromeOptions().addArguments("--headless")));
//			logger.info("Open Headless Browser...");
		} else {
			System.err.println("Please write Corrent BrowserName");
//			logger.info("Wrong Browser name...");
		}

}

	
}