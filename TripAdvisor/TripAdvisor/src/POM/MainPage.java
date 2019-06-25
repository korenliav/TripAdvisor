package POM;

import static org.junit.Assert.assertEquals;
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


public class MainPage extends Base
{
	public static WebElement txt_tripAdvisor_title(WebDriver driver) throws IOException, ParserConfigurationException, SAXException
	{
		try
		{
			element = driver.findElement(By.xpath("//*[@id='taplc_trip_search_home_default_0']/div[1]"));
			String actualTitle = driver.findElement(By.xpath("//*[@id='taplc_trip_search_home_default_0']/div[1]")).getText();
			assertEquals("Latest reviews. Lowest prices.", actualTitle);
			System.out.println("The title is correct");
			test.log(LogStatus.PASS, "Element exist- The title is correct");
		}		
		catch (AssertionError e)
		{
			System.out.println("Element not exist!!! -The title is not correct " +e.getMessage());
			test.log(LogStatus.FAIL, "Element not exist");
			test.addScreenCapture(takeScreenShot());	
			test.log(LogStatus.FAIL, test.addScreenCapture(takeScreenShot()));
			fail("Elemenet not exist -The title is not correct");
		}
		return element;		
	}
	
	public static WebElement txt_box_city(WebDriver driver)
	{
		element = driver.findElement(By.className("typeahead_input"));
		return element;		
	}
	
	public static WebElement date_picker_in(WebDriver driver)
	{
		element = driver.findElement(By.className("picker-inner"));
		return element;		
	}
	
	public static WebElement chooseDate(WebDriver driver) throws FindFailed, InterruptedException
	{
		element = driver.findElement(By.className("picker-inner"));
		scrn.click("C:\\SeleniumDrivers\\Sikuli\\Images\\17.PNG");
		Thread.sleep(1000);
		scrn.click("C:\\SeleniumDrivers\\Sikuli\\Images\\27.PNG");
		return element;		
	}
	
	public static WebElement btn_rooms(WebDriver driver)
	{
		element = driver.findElement(By.className("traveler_info_text"));
		return element;		
	}
	
	public static WebElement btn_adults(WebDriver driver)
	{
		element = driver.findElement(By.className("ui_selector"));
		return element;		
	}
	
	public static WebElement btn_close(WebDriver driver)
	{
		element = driver.findElement(By.className("close-text"));
		return element;		
	}
	
	public static WebElement btn_find_hotels(WebDriver driver)
	{
		element = driver.findElement(By.id("SUBMIT_HOTELS"));
		return element;		
	}

}
