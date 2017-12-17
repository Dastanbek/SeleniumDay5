package radiocheckdropdown;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBoxTest {
	WebDriver driver;
	
	@BeforeTest
		public void setUp(){

		System.setProperty("webdriver.chrome.driver", "/Users/dasti/Documents/Libraries/Drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://the-internet.herokuapp.com/checkboxes");
	}
	//=============================================================================================
	@Test(priority=0)
		public void checkBoxTest() throws InterruptedException{
		WebElement one=driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement two=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		System.out.println(driver.getTitle());
		
	//verify that the first one is NOT checked
		assertFalse(one.isSelected());
	//verify that the second one is Checked
		assertTrue(two.isSelected());
		Thread.sleep(3000);
		
		one.click();
		assertTrue(one.isSelected());
		assertTrue(two.isSelected());
		
		two.click();
		assertFalse(two.isSelected());
	}
	//===========================================================================================
	@Test(priority=1)
		public void changeState() throws InterruptedException{
		WebElement one=driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement two=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		Thread.sleep(4000);
				toggle(one, false);
				assertFalse(one.isSelected());
				toggle(one, true);
				assertTrue(one.isSelected());
	}
	//==============================================================================================
	public void toggle(WebElement checkbox, boolean checked){
		//if checked  is true, it means that I want the checkbox checked
		if(checked){ 
			//if checkbox is already selected
			if(checkbox.isSelected()){
				//do nothing
				return;
				//if it is not selected
			}else{
				//click on it
				checkbox.click();
			}
		}else{
			if(checkbox.isSelected()){
				checkbox.click();
			}else{
				return;
			}
		}
	}
	
	@AfterTest
		public void tearDown() throws InterruptedException{
			Thread.sleep(2000);
			driver.quit();
		}								
}
