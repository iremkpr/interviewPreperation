package steps;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigsReader;
import utils.Constants;

public class TableHandle {
	@Test
	public void table() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
		
		List<WebElement> rows=driver.findElements(By.xpath("//table/tbody//tr"));
		System.out.println("Row Size: "+rows.size());
		
		List<WebElement> allElements=driver.findElements(By.xpath("//table/tbody//tr/td"));
		System.out.println("Number of all elements: "+allElements.size());
		
		List<WebElement> columns=driver.findElements(By.xpath("//table/tbody/tr/td[@class='bold']"));
		
		for (int i = 1; i <= rows.size(); i++) {
			for(int j=1;j<=columns.size(); j++) {
				WebElement cell=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(" |"+cell.getText()+"| ");
			}
		System.out.println();	
		}
		
		
		driver.quit();
	}
	@Test
	public void table2Test() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(ConfigsReader.getProperty("url"));
		
		List<WebElement> columns=driver.findElements(By.xpath("//table[@id='table2']/thead//th"));
		System.out.println("Columns="+columns.size());
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
		System.out.println("Rows="+rows.size());
		
		for (int i = 1; i < columns.size(); i++) {
			WebElement col=driver.findElement(By.xpath("//table[@id='table2']//thead//th["+i+"]/span"));
			System.out.print(col.getText()+" | ");

		}
		System.out.println();
		
		for(int i=1;i<=rows.size();i++) {
			for(int j=1;j<columns.size();j++) {
				WebElement cell=driver.findElement(By.xpath("//table[@id='table2']/tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(cell.getText()+" | ");
			}
			System.out.println();
		}
		
	}
}
