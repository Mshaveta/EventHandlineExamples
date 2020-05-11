package PageObjects;

import java.io.IOException;

import Utility.BasePage;

public class ForgetPwdPage extends BasePage {

	public ForgetPwdPage() throws IOException {
		super();
		 
	}
	
	public void displayHeading() throws InterruptedException {
		
		System.out.println("Heading");
		
		Thread.sleep(1000);
		System.out.println("driver value-"+driver);
		driver.navigate().back();
	}	

}
