package com.ammar.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.ammar.testbase.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wikipedia_Dropdown {
public static WebDriver driver;
	public static void main(String[] args) {
		try {
			// Step 1 Setup
			WebDriverManager.firefoxdriver().setup();
			// Step 2 Lauch firefox browser
			driver = new FirefoxDriver();
			//Step 3 get website url
			driver.get("https://www.wikipedia.org/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOADWAIT, TimeUnit.SECONDS);
			Thread.sleep(5000);
			//Select language hindi from dropdown
			
			WebElement language = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
			//use select method to select language Polski
			//select is a parametrized method
			Select se = new Select(language);
			//select by index or value or text
			se.selectByVisibleText("Polski");
			//select language Hindi
			Thread.sleep(5000);
			se.selectByValue("hi");
			Thread.sleep(5000);
			
			//select all the values from Dropdown
			 List <WebElement> Dropdownlist = driver.findElements(By.tagName("option"));
			 System.out.println("Total languages are " + Dropdownlist.size());
			 System.out.println("First language in list is " + Dropdownlist.get(0).getText());

			 for (int i = 0; i<Dropdownlist.size(); i++)
			 {
				 System.out.println(i + " language in list is " + Dropdownlist.get(i).getText());
			 }
	
			//quit browser
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
