package pageObject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightTabPage {

	public WebDriver driver;

	public FlightTabPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	File p = new File("src/main/java/resources/TestData.xls");
	String path = p.getAbsolutePath().toString();

	@FindBy(xpath = "//a[@data-name='flights']")
	WebElement flightTab;

	@FindBy(id = "flightSearchRadio-2")
	WebElement oneWayRdBtn;

	@FindBy(xpath = "//div[@id='s2id_location_from']")
	WebElement frombx;

	@FindBy(xpath = "(//div[@id='chat-widget-container']/following-sibling::div//input)[1]")
	WebElement fromSearchbx;

	@FindBy(xpath = "//div[@id='s2id_location_to']")
	WebElement tobx;

	@FindBy(xpath = "(//div[@id='chat-widget-container']/following-sibling::div//input)[2]")
	WebElement toSearchbx;

	@FindBy(id = "FlightsDateStart")
	WebElement depDate;

	@FindBy(name = "fadults")
	WebElement nAdults;

	@FindBy(name = "fchildren")
	WebElement nChildren;

	@FindBy(name = "cabinclass")
	WebElement cabinDD;

	@FindBy(xpath = "//form[@name='flightmanualSearch']//button[contains(text(),'Search')]")
	WebElement searchBtn;

	public WebElement flightTab() {

		return flightTab;

	}

	public WebElement oneWayRdBtn() {

		return oneWayRdBtn;

	}

	public WebElement frombx() {

		return frombx;

	}

	public WebElement fromSearchbx() {

		return fromSearchbx;

	}

	public WebElement tobx() {

		return tobx;

	}

	public WebElement toSearchbx() {

		return toSearchbx;

	}

	public WebElement depDate() {

		return depDate;

	}

	public WebElement nAdults() {

		return nAdults;

	}

	public WebElement nChildren() {

		return nChildren;

	}

	public WebElement cabinDD() {

		return cabinDD;

	}

	public WebElement searchBtn() {

		return searchBtn;

	}

}
