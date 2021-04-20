package helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Helpers {
	private WebDriver driver;
	public Helpers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void waiting(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
