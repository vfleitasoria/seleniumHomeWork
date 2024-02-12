package com.seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRMLogin {

    public static void main(String[] args) {
        // Specify the path to your firefox executable
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vflei\\Downloads\\geckodriver.exe");

        // Step 1: Launch FireFox browser
        WebDriver driver = new FirefoxDriver();

        // Step 2: Navigate to the login page
        String url = "https://ntkhr.noortecktraining.com/web/index.php/auth/login";
        driver.get(url);

        // Step 3: Enter username
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("ntk-admin");

        // Step 4: Enter password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Ntk-orange!admin.123");

        // Step 5: Click Login Button
        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

        // Step 6: Retrieve the Header Text and Verify the header is Dashboard
        WebElement headerElement = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
       
        String headerText = headerElement.getText();
        
        if (headerText.equals("Dashboard")) {
            System.out.println("Header verification successful. Header text is 'Dashboard'.");
        } else {
            System.out.println("Header verification failed. Header text is not 'Dashboard'.");
        }

        // Step 7: Close the browser
        driver.quit();
    }
}
