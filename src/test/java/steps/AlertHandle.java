package steps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class AlertHandle {

	@Test
	public void handling() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
		
		WebElement a1=driver.findElement(By.id("btnAlert"));
		a1.click();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement a2=driver.findElement(By.id("btnDelayedAlert"));
		a2.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		
		WebElement confirm=driver.findElement(By.id("btnConfirm"));
		confirm.click();
		Alert alert3=driver.switchTo().alert();
		alert3.accept();
		
		WebElement confirmed=driver.findElement(By.id("confirmed"));
		Assert.assertTrue("confirmed text wasnt displayed",confirmed.isDisplayed());
	
		WebElement btnPrompt=driver.findElement(By.id("btnPrompt"));
		btnPrompt.click();
		Alert alert4=driver.switchTo().alert();
		alert4.sendKeys("trial");
		alert4.accept();

		WebElement message=driver.findElement(By.id("message"));
		Assert.assertTrue("confirmed text wasnt displayed",message.isDisplayed());

//message
		//btnPrompt
	}

}
