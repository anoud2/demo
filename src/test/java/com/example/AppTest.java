package com.example;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.logging.Logger;
public class AppTest {

    @Test
    public void openChrome() {

        Logger localLogger = Logger.getLogger(this.getClass().getName());



        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        assertEquals("Google", title);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement p = driver.findElement(By.name("q"));
        WebElement submitButton = driver.findElement(By.name("btnK"));
        p.sendKeys("Selenium");
        submitButton.click();
        p = driver.findElement(By.name("q"));
        p.clear();
        p.sendKeys("foodics");
        p.sendKeys(Keys.ENTER);
        //counts everything 
        WebElement resultsUI = driver.findElement(By.id("rso"));
        List<WebElement> results = resultsUI.findElements(By.xpath("./child::*"));
        
        //page1
        WebElement nav  = driver.findElement(By.id("bres"));
        js.executeScript("arguments[0].scrollIntoView();", nav);
        WebElement nxtbtn = driver.findElement(By.id("pnnext"));
        nxtbtn.click();

        //page 2
        WebElement pageA = driver.findElement(By.id("rso"));
        List<WebElement> resultsA = pageA.findElements(By.xpath("./child::*"));
        int countA = resultsA.size();
        nav  = driver.findElement(By.id("bres"));
        js.executeScript("arguments[0].scrollIntoView();", nav);
        nxtbtn = driver.findElement(By.id("pnnext"));
        nxtbtn.click();
        //page 3
        WebElement pageB = driver.findElement(By.id("rso"));
        List<WebElement> resultsB = pageB.findElements(By.xpath("./child::*"));
        int countB = resultsB.size();
        nav  = driver.findElement(By.id("bres"));
        js.executeScript("arguments[0].scrollIntoView();", nav);
        nxtbtn = driver.findElement(By.id("pnnext"));
       

        assertEquals(countA, countB, "Not equal");
        // to do
        localLogger.info("sup");
    

        driver.quit();
    }

}