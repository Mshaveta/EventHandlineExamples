package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.HomePage;

public class HomeTest extends HomePage {
	public HomeTest() throws IOException {
		super();
	}

	@Test(priority=2)
	public void logOutApp() throws InterruptedException {
		logOut();
	}
}
