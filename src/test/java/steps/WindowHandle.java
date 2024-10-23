package steps;

 import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class WindowHandle {
	@Test
	public void windHand() throws InterruptedException {
		// Open https://neotech.vercel.app/windows
		// Click on the button that opens NeoTech Academy page
		// Switch the focus back and forth 10 times
		// Hint: You switch the two handles that you have in the set
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
		
		String defaultWind=driver.getWindowHandle();
		
		WebElement google=driver.findElement(By.id("tabButton"));
		google.click();
		Set<String> windows=driver.getWindowHandles();
		
		for(String w:windows) {
			if(w!=defaultWind) {
				driver.switchTo().window(w);
				}
		}
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(defaultWind);
		
		WebElement neotechbutton=driver.findElement(By.id("windowButton"));
		neotechbutton.click();
		
		Set<String> windsSet=driver.getWindowHandles();
		for(String s:windsSet) {
			if(s!=defaultWind) {
				driver.switchTo().window(s);
			}
		}
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(defaultWind);
		
		WebElement tinywind=driver.findElement(By.id("messageWindowButton"));
		tinywind.click();
		Set<String> windowsSet=driver.getWindowHandles();
		for(String s:windowsSet) {
			if(s!=defaultWind) {
				driver.switchTo().window(s);
			}
		}
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(defaultWind);
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.quit();
	}
}
