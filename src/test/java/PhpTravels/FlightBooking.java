package PhpTravels;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.FlightTabPage;
import resources.Base;
import resources.ReadExcelFile;

public class FlightBooking extends Base

{

	@Test
	public void HomePage() throws IOException {

		driver = initializedriver();

		driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Actions a = new Actions(driver);
		File p = new File("src/main/java/resources/TestData.xls");
		String path = p.getAbsolutePath().toString();
		ReadExcelFile excel = new ReadExcelFile();

		FlightTabPage fp = new FlightTabPage(driver);
		Assert.assertTrue(fp.flightTab().isDisplayed());
		fp.flightTab().click();
		Assert.assertTrue(fp.oneWayRdBtn().isSelected());

		Assert.assertTrue(fp.frombx().isDisplayed());
		fp.frombx().click();
		fp.fromSearchbx().sendKeys(excel.getDataFromCell(path, "Flight", 0, 1));
		
		WebElement fromOpt = driver.findElement(By.xpath("//div[contains(text(), '"+excel.getDataFromCell(path, "Flight", 1, 1)+"')]"));  
		Assert.assertTrue(fromOpt.isDisplayed());
		fromOpt.click();

		Assert.assertTrue(fp.tobx().isDisplayed());
		fp.tobx().click();
		fp.toSearchbx().sendKeys(excel.getDataFromCell(path, "Flight", 2, 1));
		WebElement toOpt = driver.findElement(By.xpath("//div[contains(text(), '"+excel.getDataFromCell(path, "Flight", 3, 1)+"')]"));  
		Assert.assertTrue(toOpt.isDisplayed());
		toOpt.click();
		
		Assert.assertTrue(fp.depDate().isDisplayed());		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script1 = "document.getElementById('FlightsDateStart').removeAttribute('readonly')";
		js.executeScript(script1);
		fp.depDate().sendKeys(excel.getDataFromCell(path, "Flight", 4, 1));
		
		Assert.assertTrue(fp.nAdults().isDisplayed());
		String script2 = "document.getElementsByName('fadults')[0].removeAttribute('readonly')";
		js.executeScript(script2);
		fp.nAdults().clear();
		fp.nAdults().sendKeys(excel.getDataFromCell(path, "Flight", 5, 1));
			
		Assert.assertTrue(fp.nChildren().isDisplayed());
		String script3 = "document.getElementsByName('fchildren')[0].removeAttribute('readonly')";
		js.executeScript(script3);
		fp.nChildren().clear();
		fp.nChildren().sendKeys(excel.getDataFromCell(path, "Flight", 6, 1));
		
		String script4 = "document.getElementsByName('cabinclass')[0].setAttribute('style', 'display')";
		js.executeScript(script4);
		Select cabinClass = new Select(fp.cabinDD());
		cabinClass.selectByVisibleText(excel.getDataFromCell(path, "Flight", 7, 1));
		
		Assert.assertTrue(fp.searchBtn().isDisplayed());
		fp.searchBtn().click();
		
		
	}

}
