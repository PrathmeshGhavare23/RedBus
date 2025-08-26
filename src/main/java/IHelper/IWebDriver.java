package IHelper;

import java.time.Duration;

public interface IWebDriver {

	void get(String url);
	
	void maximize();

	void implicitlyWait(Duration duration);

	void PageLoadTimeouts(Duration duration);
	
	void addArguments(String parameter);
	
	void deleteAllCookies();
}
