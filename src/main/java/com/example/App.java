package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {

    public static void main(String[] args) {

        // ----------------------------
        // Chrome configuration (HEADLESS for Linux/Jenkins)
        // ----------------------------
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        // Selenium Manager will automatically handle ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // ----------------------------
            // Open website
            // ----------------------------
            driver.get("https://practicetestautomation.com/practice-test-login/");

            Thread.sleep(2000);

            // ----------------------------
            // Login steps
            // ----------------------------
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            Thread.sleep(2000);

            // ----------------------------
            // Print result
            // ----------------------------
            System.out.println("Page Title after login: " + driver.getTitle());

            // Optional: verify success message
            String successMsg = driver.findElement(By.className("post-title")).getText();
            System.out.println("Login Result: " + successMsg);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
