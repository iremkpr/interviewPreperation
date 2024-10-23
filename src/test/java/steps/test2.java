package steps;

 
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class test2 {
	public static void main(String[] args) throws InterruptedException {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
		
		WebElement female=driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
		female.click();
		Thread.sleep(1000);
	
		
		List<WebElement> hobbies=driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div[2]//label"));
		for(WebElement hobby:hobbies) {
			if(hobby.isEnabled()) {
				hobby.click();
			}
		}
		Thread.sleep(3000);

		
		if(driver!=null) {
			driver.quit();
		}
		
 	}
}
