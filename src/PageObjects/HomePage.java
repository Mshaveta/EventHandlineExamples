package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import Utility.BasePage;

public class HomePage extends BasePage {

	public HomePage() throws IOException {
		super();
	}

	public void logOut() throws InterruptedException {
		String wlcmLink = tdprop.getProperty("wlcmid");
		String logoutLink = tdprop.getProperty("logoutLink");
		
		//click on welcome link
		clickElement(wlcmLink);
		
		Thread.sleep(2000);
		//click onLogout link
		clickElement(logoutLink);
	}
}
