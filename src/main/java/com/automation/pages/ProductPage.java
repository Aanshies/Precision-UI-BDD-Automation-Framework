package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Stable locator for products (no ads issue)
    By products = By.xpath("//div[@data-component-type='s-search-result']//h2//a");

    By addToCartBtn = By.id("add-to-cart-button");

    public void selectProduct(int index) {

        // wait for page load
        try { Thread.sleep(5000); } catch (Exception e) {}

        // ✅ get ALL product links (more flexible)
        java.util.List<WebElement> links = driver.findElements(
            By.xpath("//a[contains(@href,'/dp/')]")
        );

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            // ✅ pick only valid product pages
            if (url != null && url.contains("/dp/") && url.contains("amazon")) {

                driver.get(url);
                return;
            }
        }

        throw new RuntimeException("❌ No valid product found");
    }
    
    public void addToCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement addBtn = wait.until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("add-to-cart-button")
            )
        );

        
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", addBtn);

        // small wait
        try { Thread.sleep(2000); } catch (Exception e) {}

        // ✅ click using JS (bypass blocking)
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", addBtn);
    }
}