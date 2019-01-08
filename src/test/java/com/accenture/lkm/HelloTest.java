package com.accenture.lkm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HelloTest {

	WebDriver driver;
	WebElement text;
	@BeforeTest
	public void beforeTest() {
		/*	
			Uncomment the below lines to work with firefox browser
			System.setProperty("webdriver.gecko.driver", "resources\\geckodriver32.exe");
			driver = new FirefoxDriver();
		*/
		System.setProperty("webdriver.chrome.driver","resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/jenkins-sample-project/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
	}

	@Test
	public void f() {
		text = driver.findElement(By.xpath("html/body/h2"));		
		Assert.assertEquals(text.getText(), "Hello World!");		
		System.out.println("Test Passed");
	}

	@AfterTest
	public void afterTest() {
		try {
			Thread.sleep(10000);
		}
		catch(InterruptedException ex) {}
		driver.close();
	}


}
