package com.ammar.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.ammar.testbase.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookingFlightTicket {
public static WebDriver driver;
	public static void main(String[] args) {
		try {
			// Step 1 - Setup
			WebDriverManager.firefoxdriver().setup();
			//Step 2 - Launch Firefox Browser
			driver = new FirefoxDriver();
			//Step 3 - Get website url
			driver.get("https://blazedemo.com/");
			// Maximise window
			driver.manage().window().maximize();
			// ImpicitWait Time
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
			// PageloadWait Time
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADWAIT, TimeUnit.SECONDS);
			// For better viewing of Page adding Thread.sleep
			Thread.sleep(5000);
		   // Find Element by Xpath
		   WebElement DeptCity = driver.findElement(By.xpath("/html/body/div[3]/form/select[1]"));
		   //Use Select class constructor
		   Select se1 = new Select(DeptCity);
		   se1.selectByValue("San Diego");
		   Thread.sleep(5000);
		 // Find another Element by Xpath
		   WebElement DestCity = driver.findElement(By.xpath("/html/body/div[3]/form/select[2]"));
		   //Use Select class constructor
		   Select se2 = new Select(DestCity);
		   se2.selectByValue("London");
		   Thread.sleep(5000);
		 // Find Flights
		   driver.findElement(By.xpath("/html/body/div[3]/form/div/input")).click();
		   Thread.sleep(5000);
		  // Select Flight 
		   driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[1]/input")).click();
		   Thread.sleep(5000);
		   // Enter Details for Purchase
		   driver.findElement(By.name("inputName")).sendKeys("Ammar Saifee");
		   Thread.sleep(3000);
		   // Enter Address
		   driver.findElement(By.id("address")).sendKeys("Amakin Mohammediya, Dombivli");
		   Thread.sleep(3000);
		   //Enter City
		   driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Mumbai");
		   Thread.sleep(3000);
		   //Enter State
		   driver.findElement(By.name("state")).sendKeys("Maharashtra");
		   Thread.sleep(3000);
		   // Enter ZipCode
		   driver.findElement(By.id("zipCode")).sendKeys("421203");
		   Thread.sleep(3000);
		   //Select Card type for Payment
		    WebElement CardType = driver.findElement(By.xpath("//*[@id=\"cardType\"]"));
		    // Use select class constructor
		    Select se3 = new Select(CardType);
		    se3.selectByIndex(1);
		    Thread.sleep(3000);
		    // Insert card number
		    driver.findElement(By.xpath("//*[@id=\"creditCardNumber\"]")).sendKeys("4368 8796 1547 5253");
		    Thread.sleep(3000);
		    // Clear default Month and than Re-Enter Card Expiry Month
		    driver.findElement(By.xpath("//*[@id=\"creditCardMonth\"]")).clear();
		    driver.findElement(By.xpath("//*[@id=\"creditCardMonth\"]")).sendKeys("06");
		    Thread.sleep(3000);
		    // Clear default Year and than Re-Enter Card Expiry Year
		    driver.findElement(By.xpath("//*[@id=\"creditCardYear\"]")).clear();
		    driver.findElement(By.xpath("//*[@id=\"creditCardYear\"]")).sendKeys("2025");
		    Thread.sleep(3000);
		    // Enter Name on Card
			driver.findElement(By.id("nameOnCard")).sendKeys("Ammar Saifee");
			Thread.sleep(3000);
			// Tick on Remember me Checkbox 
			driver.findElement(By.xpath("//*[@id=\"rememberMe\"]")).click();
			Thread.sleep(3000);
			// Click on Purchase Flight 
			driver.findElement(By.xpath("/html/body/div[2]/form/div[11]/div/input")).click();
			Thread.sleep(8000);
			//quit browser
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
