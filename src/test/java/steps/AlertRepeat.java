package steps;

 
import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class AlertRepeat {

	public static void main(String[] args) throws InterruptedException {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
/**
		WebElement al=driver.findElement(By.id("alertButton"));
		al.click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		**/

		WebElement al2 = driver.findElement(By.id("promtButton"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", al2);
		Thread.sleep(2000);

		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		Thread.sleep(2000);

		driver.quit();
	}

}
