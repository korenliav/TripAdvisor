package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.sikuli.script.Screen;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base 
{
	public static WebDriver driver;
	public static WebElement element;
	public static Screen scrn = new Screen();
	public static Boolean title;
	public static Boolean checkBox;
	public static CommonOps comOps = new CommonOps();
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());		
	public static String getData (String nodeName) throws ParserConfigurationException, SAXException, IOException
	
	{
	File fXmlFile = new File("C:\\Users\\User\\Documents\\Automation\\TripAdvisorProject\\TripAdvisor.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile); 
	doc.getDocumentElement().normalize();
	return doc.getElementsByTagName(nodeName).item(0).getTextContent();
	}
	
	public static void initBrowser(String browserType) throws ParserConfigurationException, SAXException, IOException
	{
		switch (browserType.toLowerCase())
		{
		case "firefox":
			driver = initFFDriver();
			break;
		case "ie":
			driver = initIEDriver();
			break;
		case "chrome":
			driver = initChromeDriver();
			break;	
		case "edge":
			driver = initEdgeDriver();
			break;		
		}
		driver.manage().window().maximize();
		driver.get(getData("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	}
	
	public static WebDriver initFFDriver() throws ParserConfigurationException, SAXException, IOException
	{
		System.setProperty("webdriver.gecko.driver", getData("FFDriverPath"));
		WebDriver driverff = new FirefoxDriver();
		return driverff;
	}
	
	public static WebDriver initIEDriver()
	{
		System.setProperty("webdriver.ie.driver","C:\\SeleniumDrivers\\IEDriverServer_x64_3.5.1\\IEDriverServer.exe");
		WebDriver driverie = new InternetExplorerDriver();
		return driverie;
	}
	
	public static WebDriver initChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver initEdgeDriver()
	{
		System.setProperty("webdriver.edge.driver","C:\\SeleniumDrivers\\MicrosoftEdgeDriver\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}
	
	public static void instanceReport() throws ParserConfigurationException, SAXException, IOException
	{
		extent = new ExtentReports(getData("ReportFilePath") + getData("ReportFileName") + timeStamp + ".html", true);
		extent.addSystemInfo("Host name" , "Liav PC");
	}
	
	public static void initReportTest(String testName , String testDescription)
	{
		test = extent.startTest(testName , testDescription);
	}
	
	public static void finalizeReportTest()
	{
		extent.endTest(test);
	}
	
	public static void finalizeReport()
	{
		extent.flush();
		extent.close();
	}
	
	public static String takeScreenShot() throws IOException, ParserConfigurationException, SAXException
	{
		String screenShotPath = getData("ReportFilePath") + "screenShot_" + getRandomNumber() + ".png";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(screenShotPath));
		return screenShotPath;
	}
	
	public static int getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt(999999) + 1000;
	}
}
