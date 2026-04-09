package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartCount = By.id("nav-cart-count");

    public void goToCart() {
        driver.findElement(By.id("nav-cart")).click();
    }

    // ✅ better validation (cart count)
    public boolean isProductAdded() {
        String count = driver.findElement(cartCount).getText();
        return Integer.parseInt(count) > 0;
    }

    // ✅ subtotal
    public String getSubtotal() {
        return driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
    }

    // ✅ total (FIXED METHOD)
    public String getTotal() {
        return driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']")).getText();
    }
}