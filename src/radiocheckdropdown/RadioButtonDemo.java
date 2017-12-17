package radiocheckdropdown;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonDemo {
		
	@Test
		public void hotWire() throws InterruptedException{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "/Users/dasti/Documents/Libraries/Drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//go to website
		driver.get("http://www.hotwire.com");
		//WebElement hotel=driver.findElement(By.xpath("//div[@class='col-xs-3 border-right active']"));
		WebElement hotel=driver.findElement(By.xpath("//label[contains(text(),'Hotels')]"));
		WebElement cars=driver.findElement(By.xpath("//div[@class='col-xs-3 border-right inactive'][1]"));
		WebElement flights=driver.findElement(By.xpath("//div[@class='col-xs-3 border-right inactive'][2]"));
		//print which radio button is checked
		//check hotels radio button
		printWhatsExpeceted(hotel, cars, flights);
		
			assertTrue(hotel.isSelected());
System.out.println();		
		//flights.click();
		System.out.println("The flights option selected.");
		printWhatsExpeceted(hotel, cars, flights);
		
		//verify other one is not checked
			//assertTrue(hotel.isSelected());
		
		
		
		
		
		
	}

	private void printWhatsExpeceted(WebElement hotel, WebElement cars, WebElement flights) {
		System.out.println("IS the hotel option selected?"+ hotel.isSelected());
		System.out.println("IS the cars option selected?"+ cars.isSelected());
		System.out.println("IS the flights option selected?"+ flights.isSelected());
	}
	
}
