package TestCases;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.sikuli.script.FindFailed;
import org.xml.sax.SAXException;

import POM.BudvaPage;
import POM.MainPage;
import POM.ResultsPage;
import POM.SearchInBudvaPage;
import Utilities.Base;

public class Sanity extends Base 

{
	
	@BeforeClass
	public static void startSession() throws ParserConfigurationException, SAXException, IOException
	{
		initBrowser(getData("BrowserType"));
		instanceReport();
	}
	
	@Test
	public void test1() throws FindFailed, InterruptedException, IOException, ParserConfigurationException, SAXException 
	{
		initReportTest("Test1- Verify title" ,"Description");
		MainPage.txt_tripAdvisor_title(driver);
		MainPage.txt_box_city(driver).sendKeys("Montenegro");
		MainPage.date_picker_in(driver).click();
		MainPage.chooseDate(driver);
		MainPage.btn_rooms(driver).click();
		MainPage.btn_adults(driver).click();
		MainPage.btn_find_hotels(driver).click();
	}
	
	@Test
	public void test2() throws FindFailed, IOException, ParserConfigurationException, SAXException 
	{
		initReportTest("Test2- Is title displayed?" ,"Description");
		ResultsPage.txt_title_resultsPage(driver);
		((JavascriptExecutor)driver).executeScript("scroll(0,35000)");
		ResultsPage.btn_currency(driver).click();
		ResultsPage.change_currency(driver);
		((JavascriptExecutor)driver).executeScript("scroll(0,0)");
		ResultsPage.link_budvaMunicipality(driver).click();
	}
	
	@Test
	public void test3() throws InterruptedException, FindFailed, IOException, ParserConfigurationException, SAXException 
	{
		initReportTest("Test3- Is WIFI selected?" ,"Description");
		System.out.println(BudvaPage.txt_title(driver).getText());
		BudvaPage.btn_map(driver).click();
		Thread.sleep(2000);
		BudvaPage.change_map(driver);
		Thread.sleep(3000);
		BudvaPage.btn_return_list(driver).click();
		BudvaPage.btn_more(driver).click();
		BudvaPage.btn_wifi(driver).click();
		Thread.sleep(5000);
		BudvaPage.is_wifi_Selected(driver);
		BudvaPage.btn_search(driver).click();
		Thread.sleep(2000);
		BudvaPage.txt_box_search(driver).sendKeys("SvettySteffan");
		BudvaPage.btn_submit_search(driver).click();
	}
	
	@Test
	public void test4() throws IOException, ParserConfigurationException, SAXException
	{
		initReportTest("Test4- Verify couldn't find search" ,"Description");
		SearchInBudvaPage.verifyCouldntFindSearchExist(driver);
//		comOps.verifyElementExist(driver.findElement(By.className("error-heading")),"Sorry—we couldn't find SvettySteffan");
	}
	
	
	
	@After
	public void afterTest()
	{
		finalizeReportTest();
	}
	
	@AfterClass
	public static void closeSession()
	{
		finalizeReport();
		driver.quit();
	}
	
	
}
