package radiocheckdropdown;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest {

	WebDriver driver;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "/Users/dasti/Documents/Libraries/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@Test
	public void dropDownTest() throws InterruptedException {

		WebElement list = driver.findElement(By.id("dropdown"));
		System.out.println(list.getText());
		
		Select dropdownList = new Select(list);
		dropdownList.getOptions();
		System.out.println(dropdownList.getOptions().size());
		// this is how you print from drop down
		for (WebElement option : dropdownList.getOptions()) {
			System.out.println(option.getText());
		}
		System.out.println();
		// getting the selected option
		WebElement chosenOne = dropdownList.getAllSelectedOptions().get(0);
		System.out.println(chosenOne.getText());
		// print another option
		System.out.println("Selecting Option 1.");
		dropdownList.selectByVisibleText("Option 1");
		// print the selected again
		chosenOne = dropdownList.getAllSelectedOptions().get(0);
		System.out.println("Currently selected: "+ chosenOne.getText());
		assertEquals("Option 1", chosenOne.getText());
		System.out.println();
		;
		Thread.sleep(4000);
		// select by index
		System.out.println("Selecting the third option.");
		dropdownList.selectByIndex(2);
		chosenOne=dropdownList.getAllSelectedOptions().get(0);
		System.out.println(chosenOne.getText());
		System.out.println();
		;
		Thread.sleep(4000);
		// select by Value
		dropdownList.selectByValue("1");
		chosenOne=dropdownList.getAllSelectedOptions().get(0);
		System.out.println(chosenOne.getText());
		assertEquals("Option 1", chosenOne.getText());

	}
}
