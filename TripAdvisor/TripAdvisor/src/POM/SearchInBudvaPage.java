package POM;

import static org.junit.Assert.fail;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Base;

public class SearchInBudvaPage extends Base
{
	public static WebElement txt_search_budva(WebDriver driver) 
	{
		element = driver.findElement(By.id("search_result"));
		return element;		
	}
	
	public static WebElement verifyCouldntFindSearchExist(WebDriver driver) throws IOException, ParserConfigurationException, SAXException 
	{
		try
		{
			element = driver.findElement(By.id("search_result"));
			System.out.println("Couldn't find search exist");
			test.log(LogStatus.PASS, "Couldn't find search exist");
		}		
		catch (Exception e)
		{
			System.out.println("Couldn't find search not exist!!!" +e.getMessage());
			test.log(LogStatus.FAIL, "Couldn't find search not exist");
			test.addScreenCapture(takeScreenShot());
			test.log(LogStatus.FAIL, test.addScreenCapture(takeScreenShot()));
			fail("Elemenet not exist");			
		}
		return element;
	}

}
