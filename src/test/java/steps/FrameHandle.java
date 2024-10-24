package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class FrameHandle {
	/**
	 	* // Go to https://the-internet.herokuapp. com/nested_frames
		// Go to the frame with name frameset-middle
		// Go to the frame with index 1
		// Verify the that text of the body is MIDDLE
	 * @throws InterruptedException 
	 */
	@Test
	public void frame() throws InterruptedException {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
		
		//AS WEB ELEMENT
		WebElement frame1=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(frame1);
		
		WebElement bodyTextArea=driver.findElement(By.xpath("//body[@id='tinymce']"));
		bodyTextArea.clear();
		bodyTextArea.sendKeys("NEW TEXT");
		
		Thread.sleep(3000);
		/*
		//WITH INDEX NUMBER
		driver.switchTo().frame(0);
		
		//WITH NAME
		driver.switchTo().frame("nameofFrame");
		*/
	}
	
	@Test 
	public void nestedFrames() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
			
		driver.switchTo().frame("frame-top");
 		
		//Second nested Frame
		driver.switchTo().frame("frame-middle");
		
		WebElement middle=driver.findElement(By.id("content"));
		Assert.assertTrue(middle.isDisplayed());
		
	}
 
}
