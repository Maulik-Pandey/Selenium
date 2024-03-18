package com.amazon.testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;


public class TestAmazon {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.out.println("Chrome is launched...");
    }

    public void getAmazon(){
        driver.get("https://www.amazon.in");

        String expTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

        String actualTitle = driver.getTitle();

        if (expTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Test Case 1 Passed. The title matches");
        }
        else
            System.out.println("Test case 1 fails. The title does not match");
    }

    public void login() {
        WebElement signInLink = driver.findElement(By.id("nav-link-accountList"));
        signInLink.click();

        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("maulik.pandey92@gmail.com");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("Maulik@890");

        WebElement signInButton = driver.findElement(By.id("signInSubmit"));
        signInButton.click();

        System.out.println("Testcase 2 Passed");
    }
    public void searchKeyword(){
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));

        search.click(); search.clear(); search.sendKeys("Samsung S22");

        System.out.println("Testcase 3 Passed");
    }

    public void searchButton(){
        WebElement button = driver.findElement(By.id("nav-search-submit-button"));
        button.click();
        System.out.println("Testcase 4 Passed");
    }
    public void searchCount(){
        List<WebElement> searchResults = driver.findElements(By.tagName("a"));
        System.out.println("Results are: " + searchResults.size());
        System.out.println("Testcase 5 Passed");

    }
    public void firstLink() throws InterruptedException {
        WebElement firstResultLink = driver.findElement(By.linkText("Samsung Galaxy S23 FE 5G (Mint, 8GB, 128GB Storage)"));
        firstResultLink.click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        System.out.println("Testcase 6 Passed");

    }

    public void addCart(){
        Set<String> windows = driver.getWindowHandles();

        int i = 0;
        for(String window : windows){
            i++;
            if (i == 2){
                driver.switchTo().window(window);
                System.out.println(driver.getTitle());
                break;
            }
        }

        WebElement addToCart = driver.findElement(By.id("buy-now-button"));
        addToCart.click();

        System.out.println("Testcase 7 Passed");

    }

    /* public void addDetails(){
        WebElement fullName = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
        fullName.click(); fullName.sendKeys("Maulik Pandey");

        WebElement mobileNumber = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
        mobileNumber.click(); mobileNumber.sendKeys("9045820892");

        WebElement addressLine1 = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
        addressLine1.click(); addressLine1.sendKeys("Singh Colony");

        WebElement addressLine2 = driver.findElement(By.id("address-ui-widgets-enterAddressLine2"));
        addressLine2.click(); addressLine2.sendKeys("9045820892");

        WebElement submit = driver.findElement(By.id("address-ui-widgets-form-submit-button-announce"));
        submit.click();

        System.out.println("Testcase 8 Passed");
    }*/

//    public void takePictures() {
//        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Files.copy(file, new File("/Users/Maulik/College Woodoo/SEM 6/SME/Testing/Screenshots"));
//    }
    public void tearDown() throws Exception{
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Browser is Successfully terminated.\n Testcase 9 Passed");
    }

    public static void main(String[] args) throws Exception{
        TestAmazon test = new TestAmazon();
        test.setup();
        test.getAmazon();
        test.login();
        test.searchKeyword();
        test.searchButton();
        test.searchCount();
        test.firstLink();
        test.addCart();
//        test.addDetails();
        test.tearDown();
    }
}
