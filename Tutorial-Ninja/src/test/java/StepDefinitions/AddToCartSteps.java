package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;

import genericutility.Base;
import pomrepository.CartPage;
import pomrepository.MainPage;
import pomrepository.ProductComparisonPage;
import io.cucumber.java.en.*;

public class AddToCartSteps extends Base {
    MainPage mainPage;
    CartPage cartPage;
    ProductComparisonPage comparisonPage;
    Actions actions;

    @Given("I am on the product page")
    public void i_am_on_the_product_page() throws IOException {
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        actions = new Actions(driver);
        actions.scrollToElement(cartPage.getProduct()).perform();
        cartPage.getProduct().click();
    }

    @When("I add the product to the cart")
    public void i_add_the_product_to_the_cart() {
        mainPage.getAddtocartbutton().click();
        mainPage.getShoppingcartlink().click();
    }

    @Then("the product should be added to the cart successfully")
    public void the_product_should_be_added_to_the_cart_successfully() {
        assertTrue(cartPage.getCheckout().isDisplayed());
    }

    @Given("I am logged into my account")
    public void i_am_logged_into_my_account() throws IOException, InterruptedException {
        // Implement the login steps
        LoginToAccount();
    }

    @Given("I have added a product to the wishlist")
    public void i_have_added_a_product_to_the_wishlist() throws IOException {
        mainPage.getSearchbox().click();
        mainPage.getSearchbox().sendKeys(FileUtils.readCommonData("searchproduct"));
        mainPage.getSearchbutton().click();
        cartPage.getProduct().click();
        cartPage.getWishlist().click();
    }

    @When("I add the product from the wishlist to the cart")
    public void i_add_the_product_from_the_wishlist_to_the_cart() {
        cartPage.getWishlistlink().click();
        assertTrue(cartPage.getWishlistproduct().isDisplayed());
    }

    @Given("I search for a product")
    public void i_search_for_a_product() throws IOException {
        mainPage = new MainPage(driver);
        mainPage.getSearchbox().click();
        mainPage.getSearchbox().sendKeys(FileUtils.readCommonData("searchproduct"));
        mainPage.getSearchbutton().click();
    }

    @When("I add the product to the cart from the search result page")
    public void i_add_the_product_to_the_cart_from_the_search_result_page() {
        mainPage.getAddtocartsearchpage().click();
        mainPage.getShoppingcartlink().click();
    }

    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        actions = new Actions(driver);
    }

    @When("I add a product from the features section to the cart")
    public void i_add_a_product_from_the_features_section_to_the_cart() {
        actions.scrollToElement(cartPage.getProduct()).perform();
        cartPage.getProduct().click();
        mainPage.getAddtocartbutton().click();
        mainPage.getShoppingcartlink().click();
    }

    @Given("I add the product to the comparison list")
    public void i_add_the_product_to_the_comparison_list() {
        mainPage.getCompareproductbutton().click();
        comparisonPage = new ProductComparisonPage(driver);
        actions.scrollToElement(comparisonPage.getProductcomparisonlink()).perform();
        comparisonPage.getProductcomparisonlink().click();
    }

    @When("I add the product to the cart from the comparison page")
    public void i_add_the_product_to_the_cart_from_the_comparison_page() {
        actions.scrollToElement(comparisonPage.getAddtocartbutton()).perform();
        comparisonPage.getAddtocartbutton().click();
        mainPage.getShoppingcartlink().click();
    }
}
