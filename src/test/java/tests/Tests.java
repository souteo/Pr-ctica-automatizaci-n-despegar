package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import helpers.Helpers;
import pages.PageMain;

public class Tests {
	private WebDriver driver;
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.despegar.com.ar/");
		Helpers helper = new Helpers(driver);
		helper.waiting(5);
		
	}
	@Test
	public void primerTest() {
		PageMain main = new PageMain(driver);
		
		main.goToFlights();
		
		main.fillDeparture("buenos aires");
		
		main.fillArrival("paris");
		
		main.selectDate();

		main.selectClass(1);
		
		main.send();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
