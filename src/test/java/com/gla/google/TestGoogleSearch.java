package com.gla.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class TestGoogleSearch {

    WebDriver driver;

    public void setup(){
        driver = new ChromeDriver();
        System.out.println("Browser is launched...");
    }

    public void getGoogle(){
        driver.get("https://www.google.com");

        String expTitle = "Google";

        String actualTitle = driver.getTitle();

        if (expTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("Test Case Passed. The title matches");
        }
        else
            System.out.println("Test case fails. The title does not match");
    }

    public void searchKeyword(){
        WebElement search = driver.findElement(By.name("q"));

        search.click(); search.clear(); search.sendKeys("Ram Mandir");
    }

    public void searchButton(){
        WebElement button = driver.findElement(By.name("btnK"));
        button.click();
    }
    public void searchCount(){
        List<WebElement> searchResults = driver.findElements(By.tagName("a"));
        System.out.println(searchResults.size());
//        return searchResults.size();
    }
    public void firstLink() throws InterruptedException {
        WebElement firstResultLink = driver.findElement(By.cssSelector("div.g a"));
        firstResultLink.click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        driver.navigate().back();
    }

    public void tearDown() throws Exception{
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Browser is Successfully terminated");
    }

    public static void main(String[] args) throws Exception{
        TestGoogleSearch test = new TestGoogleSearch();
        test.setup();
        test.getGoogle();
        test.searchKeyword();
        test.searchButton();
        test.searchCount();
        test.firstLink();
        test.tearDown();
//        System.out.println(test.searchCount());
    }
}
