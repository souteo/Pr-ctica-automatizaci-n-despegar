package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helpers.Helpers;

public class PageMain {

	WebDriver driver;
	By flightsButtonBy;
	By departureFieldBy;
	By arrivalFieldBy;
	By departureDateButtonBy;
	By departureDateSelectBy;
	By arrivalDateSelectBy;
	By passangersNumberBy;
	By firstPlaceBy;
	By classDropBy;
	By submitBtnBy;
	Helpers helper;
	WebDriverWait wait;

	public PageMain(WebDriver driver) {
		this.driver = driver;
		this.helper = new Helpers(driver);
		this.wait = new WebDriverWait(driver,10);
		
		//By elements
		this.flightsButtonBy = By.xpath("/html/body/nav/div[2]/div/div[3]/ul/li[2]/a");
		this.departureFieldBy = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/input");
		this.arrivalFieldBy = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div/input");
		this.departureDateButtonBy = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[2]/input");
		this.passangersNumberBy = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[3]/div/div[7]/div/div/div");
		this.firstPlaceBy = By.className("item");
		this.submitBtnBy = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[4]/div/a");
		this.departureDateSelectBy = By.cssSelector("._dpmg2--available:nth-child(4)");
		this.arrivalDateSelectBy = By.cssSelector("._dpmg2--available:nth-child(19)");
		this.classDropBy = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[4]/div[2]/div/div/select");
	}

	// going to /vuelos
	public void goToFlights() {
		WebElement flightsButtonAux = wait.until(ExpectedConditions.presenceOfElementLocated(flightsButtonBy));
		flightsButtonAux.click();
	}

	// filling "origen" and "destino" fields
	public void fillPlaceField(String from, By placeFieldBy) {
		WebElement placeField = wait.until(ExpectedConditions.presenceOfElementLocated(placeFieldBy));
		placeField.click();
		placeField.sendKeys(from);
		
		WebElement firstPlace = wait.until(ExpectedConditions.presenceOfElementLocated(firstPlaceBy));
		firstPlace.click();
	}
	
	public void fillDeparture(String from) {
		fillPlaceField(from, departureFieldBy);
	}

	public void fillArrival(String to) {
		fillPlaceField(to, arrivalFieldBy);
	}

	// filling "fechas" fields
	public void selectDate() {
		WebElement departureDateButton = driver.findElement(departureDateButtonBy);
		departureDateButton.click();
		
		WebElement departureDateSelect = wait.until(ExpectedConditions.presenceOfElementLocated(departureDateSelectBy));
		departureDateSelect.click();
		
		WebElement arrivalDateSelect = wait.until(ExpectedConditions.presenceOfElementLocated(arrivalDateSelectBy));
		arrivalDateSelect.click();
	}

	// selecting travel class
	public void selectClass(int travelClass) {
		WebElement passangersNumber = wait.until(ExpectedConditions.presenceOfElementLocated(passangersNumberBy));
		passangersNumber.click();

		Select classSelect = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(classDropBy)));
		classSelect.selectByIndex(travelClass);
	}
	
	public void send() {
		WebElement subtimBtn = driver.findElement(submitBtnBy);
		subtimBtn.click();
	}

}
