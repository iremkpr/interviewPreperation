package steps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class test2 {
	public static void main(String[] args) throws InterruptedException {
	/*// Go to https://amazon.com
// select books from the search dropdown.
// type Harry potter
// and click on Search
// check "Kindle Unlimited Eligible" checkbox on the left*/
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
 	
		Thread.sleep(5000);
		Select select=new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
		select.selectByVisibleText("Books");
		
		WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("Harry potter");
		
		WebElement submit=driver.findElement(By.id("nav-search-submit-button"));
		submit.click();
		
		Thread.sleep(1000);
		WebElement checkbox=driver.findElement(By.xpath("//span[text()='Kindle Unlimited Eligible']/..//label"));
		checkbox.click();
		Thread.sleep(2000);
		driver.quit();
	}
}
