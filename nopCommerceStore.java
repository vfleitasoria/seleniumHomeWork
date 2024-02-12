package com.seleniumHomework;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
	

	public class nopCommerceStore {

	    public static void main(String[] args) throws InterruptedException {
	        // Set the path to the geckodriver executable (Firefox driver)
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\vflei\\Downloads\\geckodriver.exe");

	       
	        // Initialize FirefoxDriver with options
	        WebDriver driver = new FirefoxDriver();

	        // 8. Launch Firefox browser
	        // 9. Navigate to https://demo.nopcommerce.com/
	        driver.get("https://demo.nopcommerce.com/");
	        Thread.sleep(2000);

	        // 10. Click Register Link
	        WebElement registerLink = driver.findElement(By.linkText("Register"));
	        registerLink.click();

	        // 11. Verify the page title is nopCommerce demo store. Register
	        String expectedTitle = "nopCommerce demo store. Register";
	        if (driver.getTitle().equals(expectedTitle)) {
	            System.out.println("Page title is nopCommerce demo store. Register");
	        } else {
	            System.out.println("Page title is not nopCommerce demo store. Register");
	        }

	        // 12. Fill out Your Personal Details Section
	        // a. Gender
	        WebElement genderRadioButton = driver.findElement(By.id("gender-male"));
	        genderRadioButton.click();

	        // b. First name
	        driver.findElement(By.id("FirstName")).sendKeys("John");
	        Thread.sleep(1000);

	        // c. Last name
	        driver.findElement(By.id("LastName")).sendKeys("Cena");
	        Thread.sleep(1000);

	        // d. Date of birth
	        
	        WebElement dayDropdown = driver.findElement(By.name("DateOfBirthDay"));
	        WebElement dayDropdown1 = driver.findElement(By.name("DateOfBirthMonth"));
	        WebElement dayDropdown2 = driver.findElement(By.name("DateOfBirthYear"));

			// Create an object of select Class
			Select selectObj = new Select(dayDropdown);
			Select selectObj1 = new Select(dayDropdown1);
			Select selectObj2 = new Select(dayDropdown2);

			selectObj.selectByIndex(12);
			Thread.sleep(2000);
			selectObj1.selectByVisibleText("October");
			Thread.sleep(2000);
			selectObj2.selectByVisibleText("1973");
			Thread.sleep(2000);
	        

	        // e. Email
	        driver.findElement(By.id("Email")).sendKeys("john.Cena@example.com");

	        // 13. Enter Company name
	        driver.findElement(By.id("Company")).sendKeys("XYZ Company");

	        // 14. Uncheck Newsletter checkbox
	        WebElement newsletterCheckbox = driver.findElement(By.id("Newsletter"));
	        if (newsletterCheckbox.isSelected()) {
	            newsletterCheckbox.click();
	        }
	        newsletterCheckbox.click();

	        // 15. Enter password
	        driver.findElement(By.id("Password")).sendKeys("JC123jc");

	        // 16. Enter Username
	        driver.findElement(By.id("ConfirmPassword")).sendKeys("JC123jc");

	        // 17. Click register button
	        driver.findElement(By.id("register-button")).click();

	        // 18. Retrieve the confirmation text message
	        WebElement confirmationMessage = driver.findElement(By.className("result"));

	        // Check if the confirmation text message equals to "Your registration completed!!!"
	        if (confirmationMessage.getText().equals("Your registration completed!")) {
	            System.out.println("TESTCASE PASSED");
	        } else {
	            System.out.println("TESTCASE FAILED");
	        }
	       

	        // Close the browser
	        driver.quit();
	    }
	}



