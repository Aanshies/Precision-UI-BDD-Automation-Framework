package com.veeva.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.veeva.base.BaseTest;
import com.veeva.pages.CartPage;
import com.veeva.pages.LoginPage;
import com.veeva.pages.ProductsPage;
import com.veeva.utils.JsonReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    // ================= SCENARIO 1 =================

    @Given("User is on SauceDemo login page")
    public void user_is_on_sauce_demo_login_page() {
        
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUsername(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("password"));
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be on products page")
    public void user_should_be_on_products_page() {
        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isOnProductsPage(), "❌ Not on Products Page");
    }

    @Then("Products should be displayed")
    public void products_should_be_displayed() {
        assertTrue(productsPage.areProductsDisplayed(), "❌ Products not visible");
    }

    // ================= SCENARIO 2 =================

    @When("User selects a product")
    public void user_selects_a_product() {
        productsPage = new ProductsPage(driver);
        productsPage.selectProduct();
    }

    @When("User adds product to cart")
    public void user_adds_product_to_cart() {
        productsPage.addToCart();
    }

    @Then("Cart count should be 1")
    public void cart_count_should_be_1() {
        assertEquals(productsPage.getCartCount(), "1", "❌ Cart count mismatch");
    }

    @When("User opens cart")
    public void user_opens_cart() {
        productsPage.openCart();
    }

    @Then("Correct product should be displayed in cart")
    public void correct_product_should_be_displayed_in_cart() {
        cartPage = new CartPage(driver);
        assertEquals(cartPage.getCartItemName(), productsPage.selectedProductName,
                "❌ Product name mismatch");
    }

    @Then("Product price should be correct")
    public void product_price_should_be_correct() {
        assertEquals(cartPage.getCartItemPrice(), productsPage.selectedProductPrice,
                "❌ Product price mismatch");

        
    }
   

    @When("User enters credentials for {string}")
    public void user_enters_credentials_for(String userType) {

        String username = JsonReader.getValue(userType, "username");
        String password = JsonReader.getValue(userType, "password");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
}