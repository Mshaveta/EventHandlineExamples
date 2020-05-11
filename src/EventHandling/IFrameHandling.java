package EventHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameHandling {
static WebDriver driver;
	
	@BeforeClass
	public  void launch() {
		String driverPath = System.getProperty("user.dir") 
				+ "\\src\\Browser_Drivers\\chromedriver_80.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
	}
	
	@Test(enabled=false)
	public void getIntoIFrame() {
		//by webElement
		
		WebElement  elm = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(elm);
		//By Index No
		//driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test Iframe Demo");
		
		// getout from an iframe
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
	}
	
	
	@Test
	public void multipleIFrame() {
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		WebElement  elm = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(elm);
		
	
		WebElement  elm1 = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(elm1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test Iframe Demo");
		driver.switchTo().parentFrame();
	}
}
