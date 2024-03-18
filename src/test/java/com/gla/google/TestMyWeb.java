package com.gla.google;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class TestMyWeb {

    WebDriver driver;
    Alert alert;
    WebDriverWait wait;

    public void setup() {
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    public void multiBrowser() throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.findElement(By.linkText("Google")).click();
        wait.until(ExpectedConditions.alertIsPresent());


        alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Thread.sleep(5000);


        driver.findElement(By.linkText("Yahoo")).click();
        Set<String> windows = driver.getWindowHandles();

        int i = 0;
        for(String window : windows){
            i++;
            if (i == 3){
                driver.switchTo().window(window);
                System.out.println(driver.getTitle());
                break;
            }
        }
    }
    public void getMyWeb() throws Exception {
        driver.get("file:///Users/Maulik/College Woodoo/SEM 6/SME/Testing/MyWeb.html");

        alert = driver.switchTo().alert();

        String alertText = alert.getText();

        System.out.println("order num is: " + alertText);

        Thread.sleep(5000);

        alert.accept();
    }

    public void getCar(){
        Select car = new Select(driver.findElement(By.id("cars")));
        car.selectByVisibleText("Ford");
    }
    public void tearDown() throws Exception{
        Thread.sleep(5000);
        driver.quit();
        System.out.println("Browser is Successfully terminated");
    }

    public static void main(String[] args) throws Exception {
        TestMyWeb test = new TestMyWeb();
        test.setup();
        test.getMyWeb();
        test.multiBrowser();
        test.getCar();
        test.tearDown();

    }
}
