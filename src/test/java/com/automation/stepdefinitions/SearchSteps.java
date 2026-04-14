package com.automation.stepdefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.base.BaseTest;
import com.automation.pages.AmazonHomePage;
import com.automation.pages.CartPage;
import com.automation.pages.ProductPage;
import com.automation.pages.SearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseTest {

    AmazonHomePage homePage;
    SearchResultsPage resultsPage;
    ProductPage productPage;
    CartPage cartPage;
    
    private static final Logger log = LogManager.getLogger(SearchSteps.class);

    @Given("User is on Amazon homepage")
    public void user_on_homepage() {
    	log.info("Opening Amazon homepage");
        homePage = new AmazonHomePage(driver);
    }

    @When("User searches for {string}")
    public void search_product(String product) {
    	log.info("Searching for product: " + product);
        homePage.searchProduct(product);
        resultsPage = new SearchResultsPage(driver);
    }

    @Then("User should see search results related to {string}")
    public void validate_results(String product) {
    	log.info("Validating search results for: " + product);
        Assert.assertTrue(resultsPage.isProductDisplayed(product));
    }

    @When("User selects first product")
    public void select_product() {
    	log.info("Selecting product from results");

        productPage = new ProductPage(driver);

        // ✅ go to 3rd product (index 2)
        productPage.selectProduct(0);
    }

    @Then("User adds product to cart")
    public void add_to_cart() {
    	log.info("Adding product to cart");

        productPage.addToCart();
    }

    @Then("Product should be added to cart")
    public void validate_cart() throws InterruptedException {
    	log.info("Validating cart details");

        cartPage = new CartPage(driver);
        
        // ✅ go to cart page
        cartPage.goToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
        
        // ✅ validate count
        log.info("Checking cart count");
        Assert.assertTrue(cartPage.isProductAdded());
        System.out.println("Cart Count: " + driver.findElement(By.id("nav-cart-count")).getText());
        
        // ✅ validate subtotal not empty
        String subtotal = cartPage.getSubtotal();
        log.info("Subtotal value: " + subtotal);
        Assert.assertFalse(subtotal.isEmpty());

        // ✅ validate total not empty
        String total = cartPage.getTotal();
        log.info("Total value: " + total);
        Assert.assertFalse(total.isEmpty());
        
        log.info("Test completed successfully");

        
    }
}