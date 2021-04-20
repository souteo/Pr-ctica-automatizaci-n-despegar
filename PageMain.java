package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import helpers.Helpers;

public class PageMain {

	WebDriver driver;
	By flightsButton;
	By departureField;
	By arrivalField;
	By departureDateButton;
	By departureDateSelect;
	By arrivalDateSelect;
	By placesList;
	By passangers;
	By firstPlace;
	By classDrop;
	By submitBtn;
	Helpers helper = new Helpers(driver);

	public PageMain(WebDriver driver) {
		this.driver = driver;
		this.flightsButton = By.xpath("/html/body/nav/div[2]/div/div[3]/ul/li[2]/a");
		this.departureField = By
				.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/input");
		this.arrivalField = By
				.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div/input");
		this.departureDateButton = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[2]/input");
		this.passangers = By
				.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[3]/div/div[7]/div/div/div");
		this.firstPlace = By.className("item");
		this.submitBtn = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[4]/div/a");
	}

	public void goToFlights() {
		// going to /flights
		driver.findElement(flightsButton).click();
		helper.waiting(3);
		this.placesList = By
				.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[2]/input");
	}

	public void fillDeparture(String from) {
		// writing in "from" field
		driver.findElement(departureField).click();
		driver.findElement(departureField).sendKeys(from);
		helper.waiting(3);
		driver.findElement(firstPlace).click();
	}

	public void fillArrival(String to) {
		// writing in "to" field
		driver.findElement(arrivalField).click();
		driver.findElement(arrivalField).sendKeys(to);
		helper.waiting(3);
		driver.findElement(firstPlace).click();
	}

	public void selectDate() {
		// selecting dates in dates field
		driver.findElement(departureDateButton).click();
		helper.waiting(2);
		this.departureDateSelect = By.cssSelector("._dpmg2--available:nth-child(19)");
		driver.findElement(departureDateSelect).click();
		this.arrivalDateSelect = By.cssSelector("._dpmg2--available:nth-child(30)");
		driver.findElement(arrivalDateSelect).click();
		helper.waiting(2);
	}
	
	/*
	public void selectArrivalDate() {
		// selecting dates in dates field
		driver.findElement(arrivalDateButton).click();
		helper.waiting(2);
		driver.findElement(arrivalDateSelect).click();
		helper.waiting(2);
		System.out.println("salimo bien salimoo biennnnn");
	}
	*/

	public void selectClass(int c) {
		// selecting flight class
		driver.findElement(passangers).click();
		helper.waiting(2);
		this.classDrop = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[4]/div[2]/div/div/select");
		helper.waiting(1);
		Select classSelect = new Select(driver.findElement(classDrop));
		classSelect.selectByIndex(c);
		helper.waiting(2);
	}
	
	public void send() {
		driver.findElement(submitBtn).click();
	}
	

}
