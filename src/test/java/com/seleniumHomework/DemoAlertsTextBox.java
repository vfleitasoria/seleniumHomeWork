package com.seleniumHomework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoAlertsTextBox {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vflei\\Downloads\\chromedriver.exe");

        // Step 1: Launch FireFox browser
        WebDriver driver = new ChromeDriver();

       
        // 2. Navigate to https://demo.automationtesting.in/Alerts.html
        driver.get("https://demo.automationtesting.in/Alerts.html");

        // 3. Verify the page title is Alerts
        String expectedTitle = "Alerts";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Page title is Alerts");
        } else {
            System.out.println("Page title is not Alerts");
        }

        // 4. Click Alert with Textbox
        // a. Click Click the button to demonstrate the prompt box button
        WebElement alertWithTextboxButton = driver.findElement(By.xpath("//button[text()='display Confirm Box ']"));
        alertWithTextboxButton.click();

        // b. Enter your name in the Alert Text field.
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Vladimir Fleitas");

        // c. Click Ok button
        alert.accept();

        // d. Verify the message displayed under Click the button to demonstrate the prompt box
        WebElement promptBoxMessage = driver.findElement(By.id("demo1"));
        String promptBoxText = promptBoxMessage.getText();
        if (promptBoxText.contains("Vladimir Fleitas")) {
            System.out.println("Prompt Box contains 'Vladimir Fleitas'");
        } else {
            System.out.println("Prompt Box does not contain 'Vladimir Fleitas'");
        }

        // 5. Refresh the page.
        driver.navigate().refresh();

        // 6. Click Alert with OK & Cancel
        // a. Click Click the button to display a confirm box button
        WebElement confirmBoxButton = driver.findElement(By.xpath("//button[text()='display Confirm Box ']"));
        confirmBoxButton.click();

        // b. Enter your name in the Alert Text field.
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.sendKeys("Vladimir Fleitas");

        // c. Verify the text in alert contains Press a Button !
        String alertText = confirmAlert.getText();
        if (alertText.contains("Press a Button")) {
            // ii. If false, then click OK
            confirmAlert.dismiss();
        } else {
            // i. If true, then click Cancel
            confirmAlert.accept();
        }

        // d. Verify the message displayed under Click the button to display a confirm box button
        WebElement confirmBoxMessage = driver.findElement(By.id("demo2"));
        String confirmBoxText = confirmBoxMessage.getText();
        if (confirmBoxText.contains("Vladimir Fleitas")) {
            System.out.println("Confirm Box contains 'Vladimir Fleitas'");
        } else {
            System.out.println("Confirm Box does not contain 'Vladimir Fleitas'");
        }

        // 7. Close the browser
        driver.quit();
    }
}
