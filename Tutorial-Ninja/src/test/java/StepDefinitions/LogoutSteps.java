package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import genericutility.Base;
import io.cucumber.java.en.*;
import pomrepository.HomePage;

public class LogoutSteps extends Base {
    HomePage hp;

    @Given("I am logged in to my account")
    public void i_am_logged_in_to_my_account() throws IOException {
        LoginToAccount(); // Ensure user is logged in
        hp = new HomePage(driver);
    }

    @When("I click on the My Account dropdown and select Logout")
    public void i_click_on_the_my_account_dropdown_and_select_logout() {
        hp.getMyaccountdropdown().click();
        hp.getLogout().click();
    }

    @Then("I should be logged out successfully")
    public void i_should_be_logged_out_successfully() {
        assertTrue(hp.getLoggedOut().isDisplayed());
    }

    @When("I click on the Logout option from the right-bottom corner")
    public void i_click_on_the_logout_option_from_the_right_bottom_corner() {
        hp.getLogOutListOption().click();
    }
}
