package com.seleniumHomework;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Hooks;

public class iFrameHW extends Hooks{
	
	public static void main (String[]args) throws InterruptedException {
		
		setUp();
		 
	//	 2. Navigate to https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html 
		 
		 driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		 
		 Thread.sleep(2000);
		 
	//	 3. Click org.openqa.selenium 
		 
		 WebElement openSelenium = driver.findElement(By.cssSelector("a[href='org/openqa/selenium/package-summary.html']"));
		 
		 openSelenium.click();
		 
		 Thread.sleep(2000);
		 
	//	4. Click Alert 
		 
		 WebElement openAlert = driver.findElement(By.cssSelector("a[href='Alert.html']"));
		 
		 openAlert.click();
		 
		 Thread.sleep(2000);
		
			//  Once we have all the window IDs, then we can iterate/loop through the set and
			//  ineteract/switch back & forth
		
		 
			Set<String> allWindows = driver.getWindowHandles();

			System.out.println("Window IDS: " + allWindows);
	
			for (String window : allWindows) {

				System.out.println("Window ID: " + window);

				// switch control to one of the window
				driver.switchTo().window(window);

				// now retreive page titel

				String pageTitle = driver.getTitle();
				
				System.out.println(pageTitle);
				if(pageTitle == "Interface Alert") {
					System.out.println("TESTCASE PASSED ");
				}else {
					System.out.println("TESTCASE FAILED" );
					
				}
				
					
				Thread.sleep(2000);
				
				driver.switchTo().defaultContent();
				
				// 6. Under Package section, locate org.openqa.selenium.chrome and click.
				
				WebElement seleniumChrome = driver.findElement(By.cssSelector("a[href='org/openqa/selenium/chrome/package-summary.html']"));
				
				seleniumChrome.click();
				
				// 7. Click ChromeDriver
				
				WebElement chromeDriver = driver.findElement(By.xpath("//*[@id=\"class-summary\"]/div[2]/div[7]/a"));
				
				chromeDriver.click();
				
				// 8. Retrieve the text message and check if the text message equals to Class ChromeDriver
		        //     a. If it does then print TESTCASE PASSED
		        //     b. Otherwise print TESTCASE FAILED
				
               String pageTitle2 = driver.getTitle();
				
				System.out.println(pageTitle2);
				if(pageTitle2 == "Class Chrome Driver") {
					System.out.println("TESTCASE PASSED ");
				}else {
					System.out.println("TESTCASE FAILED" );
					
				}
				Thread.sleep(2000);
				
				tearDown();
	}

}

	
	}

/**
Scenario: Handling Iframe
    1. Launch chrome browser

    2. Navigate to https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html

    3. Click org.openqa.selenium

    4. Click Alert

    5. Retrieve the text message and check if the text message equals to Interface Alert
          a. If it does then print TESTCASE PASSED
          b. Otherwise print TESTCASE FAILED

    6. Under Package section, locate org.openqa.selenium.chrome and click.


    7. Click ChromeDriver

    8. Retrieve the text message and check if the text message equals to Class ChromeDriver
         a. If it does then print TESTCASE PASSED
         b. Otherwise print TESTCASE FAILED

    9. Close the browser.
*/