package POM;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.Base;

public class ResultsPage extends Base
{
	public static WebElement txt_title_resultsPage(WebDriver driver) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			title= driver.findElement(By.id("taplc_trip_planner_h1_0")).isDisplayed();
			System.out.println("Title displayed");
			test.log(LogStatus.PASS, "Element exist- The title is displayed");
		}
		catch (Exception e)
		{
			System.out.println("the title not displayed" + e.getMessage());
			test.log(LogStatus.FAIL, "Element not exist");
			test.addScreenCapture(takeScreenShot());
			test.log(LogStatus.FAIL, test.addScreenCapture(takeScreenShot()));
			fail("Elemenet not exist -The title is not correct");
		}
		return element;		
	}
	
	public static WebElement link_budvaMunicipality(WebDriver driver)
	{
		element = driver.findElement(By.className("geo_name"));
		return element;		
	}
	
	public static WebElement change_currency(WebDriver driver) throws FindFailed
	{
		element = driver.findElement(By.className("currency_symbol"));
		scrn.click("C:\\SeleniumDrivers\\Sikuli\\Images\\USD.PNG");
		return element;	
	}
	
	public static WebElement btn_currency(WebDriver driver)
	{
		element = driver.findElement(By.className("currency_symbol"));
		return element;		
	}
}
