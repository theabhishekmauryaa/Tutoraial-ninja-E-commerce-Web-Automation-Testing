package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import genericutility.Base;
import io.cucumber.java.en.*;
import pomrepository.MainPage;

public class SearchSteps extends Base {
    MainPage mp;

    @Given("I am on the main page")
    public void i_am_on_the_main_page() {
        mp = new MainPage(driver);
        // Add logic to ensure user is on the main page if necessary
    }

    @When("I search for a valid product name")
    public void i_search_for_a_valid_product_name() throws IOException {
        mp.getSearchbox().click();
        mp.getSearchbox().sendKeys(FileUtils.readCommonData("searchproduct"));
        mp.getSearchbutton().click();
    }

    @Then("the product should be displayed")
    public void the_product_should_be_displayed() {
        assertTrue(mp.getIphone().isDisplayed());
    }

    @When("I search for a non-existing product name")
    public void i_search_for_a_non_existing_product_name() throws IOException {
        mp.getSearchbox().click();
        mp.getSearchbox().sendKeys(JavaUtils.TimeStamp());
        mp.getSearchbutton().click();
    }

    @Then("a \"Product not found\" message should be displayed")
    public void a_product_not_found_message_should_be_displayed() {
        assertTrue(mp.getProductnotfound().isDisplayed());
    }

    @When("I search without entering a product name")
    public void i_search_without_entering_a_product_name() {
        mp.getSearchbox().click();
        mp.getSearchbox().sendKeys("");
        mp.getSearchbutton().click();
    }

    @Then("the search box should have the placeholder text")
    public void the_search_box_should_have_the_placeholder_text() throws IOException {
        assertTrue(mp.getSearchbox().getAttribute("placeholder").equals(FileUtils.readCommonData("placeholdersearchbox")));
    }

    @When("I search for a product and click the compare link")
    public void i_search_for_a_product_and_click_the_compare_link() throws IOException {
        mp.getSearchbox().click();
        mp.getSearchbox().sendKeys(FileUtils.readCommonData("searchproduct"));
        mp.getSearchbutton().click();
        mp.getProductcomparelink().click();
    }

    @Then("the product comparison page should be displayed")
    public void the_product_comparison_page_should_be_displayed() {
        assertTrue(mp.getProductcomparepage().isDisplayed());
    }
}
