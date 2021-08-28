package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	public static WebDriver	driver;
	@BeforeSuite
	public static void setUp() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=en-ca");
	      driver = new ChromeDriver(options);
	    
	    driver.get("https://www.google.com/");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void searchForGoogle()

	
	{
		String ExpectTestData="Selenium";
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(ExpectTestData);
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']/center/input[1]")).submit();
		
		// ASSertion
		
		String actualRes1=driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[2]/span/span/em")).getText();
		
		SoftAssert softassert = new SoftAssert();
		
		//softassert.assertEquals(ExpectTestData, actualRes1);
		//softassert.assertEquals(ExpectTestData, actualRes1+"1" );
 
        		
        		
        	softassert.assertEquals(ExpectTestData, actualRes1+"2");
        	softassert.assertEquals(ExpectTestData, actualRes1+"1" );    
        		
        		softassert.assertAll();
		

}

		
		
	}

