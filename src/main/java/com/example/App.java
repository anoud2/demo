package com.example;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class App {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        //  WebDriver driver = new ChromeDriver();
        //  driver.get("https://www.google.com");
        //  // Find the search input field
        // WebElement searchInput = driver.findElement(By.name("q"));
        // // Enter a keyword
        // // Click the search button
        // WebElement searchButton = driver.findElement(By.name("btnK"));
        // searchButton.click();





        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            // Navigate to Url
            driver.get("https://google.com");
          //  driver.navigate().to("https://selenium.dev");
        } 
        finally {
            driver.quit();
        }

    }
}
   