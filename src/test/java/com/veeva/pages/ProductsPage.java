package com.veeva.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    // Locators
    By pageTitle = By.className("title");
    By productList = By.className("inventory_item");

    By productName = By.className("inventory_item_name");
    By productPrice = By.className("inventory_item_price");
    By addToCartBtn = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
    By cartBadge = By.className("shopping_cart_badge");
    By cartIcon = By.className("shopping_cart_link");

    // Store selected product details
    public String selectedProductName;
    public String selectedProductPrice;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ================= SCENARIO 1 METHODS =================

    public boolean isOnProductsPage() {
        return driver.findElement(pageTitle).getText().equals("Products");
    }

    public boolean areProductsDisplayed() {
        List<?> products = driver.findElements(productList);
        return products.size() > 0;
    }

    // ================= SCENARIO 2 METHODS =================

    public void selectProduct() {
        selectedProductName = driver.findElements(productName).get(0).getText();
        selectedProductPrice = driver.findElements(productPrice).get(0).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}