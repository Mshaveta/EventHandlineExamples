package EventHandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertHandling {

	static WebDriver driver;
	
	@BeforeClass
	public  void launch() {
		String driverPath = System.getProperty("user.dir") 
				+ "\\src\\Browser_Drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void alertBox() throws InterruptedException {
		driver.findElement(By.partialLinkText("Alert with OK")).click();
		driver.findElement(By.xpath("//button[contains(text(),'button to display an  alert box')]"))
							 .click();
		
		Alert alt = driver.switchTo().alert();
		String expMsg = "I am an alert box!";
		String actualAltMsg = alt.getText();
		
		System.out.println(actualAltMsg);
		Assert.assertEquals(actualAltMsg, expMsg,"Doesn't Match!!!");
		Thread.sleep(3000);
		//click on OK button
		alt.accept();
	}
	
	@Test
	public void confirmBox() throws InterruptedException {
		driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
		driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]"))
							 .click();
		Alert alt = driver.switchTo().alert();
		Thread.sleep(3000);
		alt.dismiss();
	}
	
	@Test
	public void promptBox() throws InterruptedException {
		driver.findElement(By.partialLinkText("Alert with Textbox")).click();
		driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"))
							 .click();
		Alert alt = driver.switchTo().alert();
	
		Thread.sleep(4000);
		alt.sendKeys("Hi All....I'm Prompt Box field");
		alt.accept();
	}
	
	 
			
	

}
