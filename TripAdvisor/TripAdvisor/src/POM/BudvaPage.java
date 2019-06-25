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

public class BudvaPage extends Base
{
	public static WebElement txt_title(WebDriver driver)
	{
		element = driver.findElement(By.id("HEADING"));
		return element;		
	}

	public static WebElement btn_map(WebDriver driver)
	{
		element = driver.findElement(By.id("taplc_map_list_toggle_cta_dusty_hotels_0"));
		return element;		
	}
	
	public static WebElement change_map(WebDriver driver) throws FindFailed
	{
		element = driver.findElement(By.className("mapTypeControls"));
		scrn.click("C:\\SeleniumDrivers\\Sikuli\\Images\\satellite.png");
		return element;		
	}
	
	public static WebElement btn_return_list(WebDriver driver) 
	{
		element = driver.findElement(By.id("taplc_map_list_toggle_cta_dusty_hotels_0"));
		return element;		
	}
	
	public static WebElement btn_more(WebDriver driver) 
	{
		element = driver.findElement(By.xpath("//*[@id='taplc_hsx_lhr_filters_resp_col_0']/div/div[2]/div[2]/div[2]/div[2]/div[2]/span[1]"));
		return element;		
	}
	
	public static WebElement btn_wifi(WebDriver driver) 
	{
		element = driver.findElement(By.xpath("//*[@id='taplc_hsx_lhr_filters_resp_col_0']/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/label"));
		return element;		
	}
	public static WebElement btn_search(WebDriver driver) 
	{
		element = driver.findElement(By.id("taplc_masthead_search_0"));
		return element;		
	}
	
	public static WebElement txt_box_search(WebDriver driver) 
	{
		element = driver.findElement(By.id("mainSearch"));
		return element;		
	}
	
	public static WebElement btn_submit_search(WebDriver driver) 
	{
		element = driver.findElement(By.id("SEARCH_BUTTON_CONTENT"));
		return element;		
	}
	
	public static WebElement is_wifi_Selected(WebDriver driver) throws IOException, ParserConfigurationException, SAXException 
	{
		
		try
		{
			checkBox= driver.findElement(By.xpath("//*[@id='taplc_hsx_lhr_filters_resp_col_0']/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/label")).isSelected();
			System.out.println("CheckBox WIFI selected");
			test.log(LogStatus.PASS, "CheckBox WIFI selected");
		}
		catch (Exception e)
		{
			System.out.println("CheckBox WIFI not selected" + e.getMessage());
			test.log(LogStatus.FAIL, "CheckBox WIFI selected");
			test.addScreenCapture(takeScreenShot());	
			
			fail("CheckBox WIFI not selected");
		}
		return element;		
	}

	

}
