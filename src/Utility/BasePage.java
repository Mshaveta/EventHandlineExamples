package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	public static WebDriver driver;// null
	public Properties prop,tdprop;
	String browser_name, dPath, appUrl;// scope- default (within same pkg)

	public BasePage() throws IOException {
		// 1. to access the .prop file
		String propFilePath = System.getProperty("user.dir") + "\\src\\TestData\\config.properties";
		FileInputStream fis = new FileInputStream(propFilePath);

		prop = new Properties();
		prop.load(fis);
		browser_name = prop.getProperty("browserName");
		dPath = prop.getProperty("driverPath");
		appUrl = prop.getProperty("app_url");
		
		
		//2. Toread the testdat.prop file
		String tdPropFilePath = System.getProperty("user.dir") + "\\src\\TestData\\testData.properties";
		FileInputStream tdfis = new FileInputStream(tdPropFilePath);

		tdprop = new Properties();
		tdprop.load(tdfis);
	}

	public void browserLaunch() {
		if (browser_name.equalsIgnoreCase("chrome")) {
			String driverPath = System.getProperty("user.dir") + "\\src\\" + dPath;
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();// driver--null--< chrome instance
		} else if (browser_name.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir") + "\\src\\" + dPath;
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();// driver--null
		} else {
			System.out.println("Wrong Browser name");
		}
		driver.get(appUrl);// null.get()
	}

	private By getLocator(String lname, String locVal) {
		By by = null;
		lname = lname.toLowerCase();
		switch (lname) {
		case "id":
			by = By.id(locVal);
			break;
		case "name":
			by = By.name(locVal);
			break;
		case "linktext":
			by = By.linkText(locVal);
			break;
		case "partiallinktext":
			by = By.partialLinkText(locVal);
			break;
		case "xpath":
			by = By.xpath(locVal);
			break;
		case "cssselector":
			by = By.cssSelector(locVal);
			break;
		case "tagname":
			by = By.tagName(locVal);
			break;
		case "classname":
			by = By.className(locVal);
			break;
		default:
		}
		return by;
	}

	public void sendData(String loc_name, String locVal, String testData) {
		driver.findElement(getLocator(loc_name, locVal)).sendKeys(testData);
	}

	public void sendData(String element) { //id###username###pwd
		String[] elm_arr = element.split("###");
		String locName = elm_arr[0];// id
		String locVal = elm_arr[1];// txtUsername
		String testData = elm_arr[2];
		driver.findElement(getLocator(locName, locVal)).sendKeys(testData);

	}

//	public void accessWebElm(String element) {
//		String[] elm_arr = element.split("###");
//		 
//		String locName = elm_arr[0];//id
//		String locVal = elm_arr[1];//txtUsername
//		if(elm_arr.length<=2) {
//			driver.findElement(getLocator(locName,locVal)).click();
//		}else {
//			String testData = elm_arr[2];
//			driver.findElement(getLocator(locName,locVal)).sendKeys(testData);
//		}
//		
//	}

	public void clickElement(String locName, String locVal) {
		driver.findElement(getLocator(locName, locVal)).click();
	}

	// 1 way
	public void clickElement(String element) {
		String[] elm_arr = element.split("###");
		String locName = elm_arr[0];// id
		String locVal = elm_arr[1];// txtUsername
		driver.findElement(getLocator(locName, locVal)).click();
	}

	public void clearElement(String locName, String locVal) {
		driver.findElement(getLocator(locName, locVal)).clear();
	}

	public boolean isElmPresent(String element) {
		String[] elm_arr = element.split("###");
		String locName = elm_arr[0];// id
		String locVal = elm_arr[1];// txtUsername
		boolean res = driver.findElement(getLocator(locName, locVal)).isDisplayed();
		return res;
	}

}
