package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import PageObjects.LoginPage;

public class LoginTest extends LoginPage {
	 
	public LoginTest() throws IOException {
		super();
	}

	@BeforeSuite	
	public void setUp() throws IOException 
	{
		 browserLaunch();
	}
	
	@Test(priority=1)
	public void loginToApp() throws IOException, InterruptedException {
		loginWithInValidCred();
		Thread.sleep(2000);
		
		String wlcmLink = tdprop.getProperty("wlcmid");
		boolean elmStatus = isElmPresent(wlcmLink);//true
		Assert.assertTrue(elmStatus,"Element Present on Page!!");
		
	}
	
//	@AfterSuite
//	public void teardown() {
//		driver.quit();
//		
//	}
}
