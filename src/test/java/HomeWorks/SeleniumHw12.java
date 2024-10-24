package HomeWorks;

 import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

 
public class SeleniumHw12 {
/**
 * Open chrome browser
Go to https://demo.guru99.com/test/drag_drop.html
Drag the following blocks in different ways
Drag BANK to DEBIT SIDE
Drag SALES to CREDIT SIDE
Drag 5000 to DEBIT SIDE
Drag 5000 to CREDIT SIDE
Close the browser
 * @throws InterruptedException 

 */
	@Test
	public void dragDrop() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		Actions action=new Actions(driver);
		List<WebElement> products=driver.findElements(By.xpath("//div[@id='products']//ul/li/a"));
		
		WebElement debitAccTarget=driver.findElement(By.xpath("//ol[@id='bank']/li"));
		WebElement debitAmtTarget=driver.findElement(By.xpath("//ol[@id='amt7']/li"));
		WebElement sales=driver.findElement(By.xpath("//ol[@id='loan']/li"));

 		for(WebElement prod:products) {
			
			String nameOfProduct=prod.getText();
			
			if(nameOfProduct.equals("BANK")) {
				action.dragAndDrop(prod, debitAccTarget).perform();
				
			}
			else if (nameOfProduct.equals("5000")) {
				action.dragAndDrop(prod, debitAmtTarget).perform();
				debitAmtTarget=driver.findElement(By.xpath("//ol[@id='amt8']/li"));


			}
			else if (nameOfProduct.equals("SALES")) {
				action.dragAndDrop(prod, sales).perform();
			}
			Thread.sleep(3000);
			
		}
 		WebElement perfect=driver.findElement(By.xpath("//div[@class='table4_result']/a"));
 		Assert.assertTrue("Perfect was not displayed",perfect.isDisplayed());
	}
}
