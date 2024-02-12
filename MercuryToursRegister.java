package com.seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class MercuryToursRegister  {
	
	public static void main(String[]args) throws InterruptedException {
		// Specify the path to your firefox executable
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vflei\\Downloads\\geckodriver.exe");

        // Step 1: Launch FireFox browser
        WebDriver driver = new FirefoxDriver();
		 // 1. Launch Firefox browser
        // 2. Navigate to https://demo.guru99.com/test/newtours/
        driver.get("https://demo.guru99.com/test/newtours/");
		//3. Click REGISTER link
        WebElement register = driver.findElement(By.linkText("REGISTER"));
        register.click();
     // 4. Verify the page title is Mercury Tours
        String expectedTitle = "Register: Mercury Tours";
        if (driver.getTitle().contains(expectedTitle)) {
            System.out.println("Page title is Mercury Tours");
        } else {
            System.out.println("Page title is not Mercury Tours");
        }
        /**Enter first name
        6. Enter last name
        7. Enter phone number
        8. Enter email
        9. Enter address
        10. Enter city
        11. Enter state
        12. Enter zip code
        13. Enter username
        14. Enter password
        */
        driver.findElement(By.name("firstName")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Cena");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("userName")).sendKeys("john.Cena@example.com");
        driver.findElement(By.name("address1")).sendKeys("123 Street");
        driver.findElement(By.name("city")).sendKeys("Miami");
        driver.findElement(By.name("state")).sendKeys("FL");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        driver.findElement(By.name("email")).sendKeys("john.Cena@example.com");
        driver.findElement(By.name("password")).sendKeys("JC123jc");
        driver.findElement(By.name("confirmPassword")).sendKeys("JC123jc");
        
     // 16. Click Submit
        driver.findElement(By.name("submit")).click();

     // 17. Wait for confirmation message
       // try {
          //  Thread.sleep(2000); // Wait for 5 seconds
        //} catch (InterruptedException e) {
       //     e.printStackTrace();
       // }

        // Retrieve the confirmation text message
        WebElement confirmationMessage = driver.findElement(By.xpath("//b[contains(text(), 'Thank you for registering')]"));

        // Check if the confirmation message contains "Thank you for registering."
        if (confirmationMessage.isDisplayed() && confirmationMessage.getText().contains("Thank you for registering.")) {
            System.out.println("TESTCASE PASSED");
        } else {
            System.out.println("TESTCASE FAILED");
        }

        // 18. Close the browser
        
        driver.quit();
        
	}

}
