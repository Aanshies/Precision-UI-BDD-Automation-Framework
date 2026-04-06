package com.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    By cartItemName = By.className("inventory_item_name");
    By cartItemPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public String getCartItemPrice() {
        return driver.findElement(cartItemPrice).getText();
    }
}