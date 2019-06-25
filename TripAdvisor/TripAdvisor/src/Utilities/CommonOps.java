package Utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.LogStatus;

public class CommonOps extends Base
{
	public WebElement verifyElementExist(WebElement elem, String expectedValue) throws IOException, ParserConfigurationException, SAXException 
	{
		try
		{
			String actual = elem.getText();
			assertEquals(expectedValue,actual);
			element = driver.findElement(By.className("error-heading"));
//			element = driver.findElement(By.id("search_result"));
			System.out.println("Element exist");
			test.log(LogStatus.PASS, "Element exist");
		}		
		catch (Exception e)
		{
			System.out.println("Element not exist!!!" +e.getMessage());
			test.log(LogStatus.FAIL, "Element not exist");
			test.addScreenCapture(takeScreenShot());	
			fail("Elemenet not exist");
		}
		return element;
	}
}
