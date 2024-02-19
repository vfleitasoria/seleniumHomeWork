package com.seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class iFrameHW2 extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		// 1. Launch chrome browser

		setUp();

		// 2. Navigate to https://demo.automationtesting.in/Frames.html

		driver.get("https://demo.automationtesting.in/Frames.html");

		// 3. Enter Accessing Iframe in the text field.

		driver.switchTo().frame("SingleFrame");

		// Enter text in the Single iframe

		WebElement singleIframeTextbox = driver.findElement(By.xpath("//input[@type='text']"));

		singleIframeTextbox.sendKeys("Accessing Iframe");

		// 4. Wait 2 seconds

		Thread.sleep(2000);

		// 5. Click Iframe with in an Iframe

		driver.switchTo().defaultContent();

		WebElement innerIframeTextbox = driver.findElement(By.xpath("/html/body/section/div[1]/div"));

		driver.switchTo().frame("InnerFrame");

		// 6. Enter Iframe is easy in the text field

		innerIframeTextbox.sendKeys("Iframe is easy");

		driver.switchTo().defaultContent();

		// 7. Click Home link

		WebElement homeLink = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		homeLink.click();

		// Retrieve the page title
		String title = driver.getTitle();
		
		System.out.println(title);

		// Verify the page title and print the result

		if (title.equals("Index")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");

		}

		// 9. Close the browser.

		tearDown();

	}
}