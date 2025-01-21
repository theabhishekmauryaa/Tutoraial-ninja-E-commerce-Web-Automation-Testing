package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import genericutility.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomrepository.HomePage;
import pomrepository.LogInPage;

public class loginStepDefinition extends Base {
    WebDriver driver = Base.getDriver();
    HomePage homepage;
    LogInPage login;

    @Given("I open the application")
    public void i_open_the_application() {
        driver.get("https://yourwebsite.com"); // Replace with actual URL
        homepage = new HomePage(driver);
    }

    @When("I enter valid email and password")
    public void i_enter_valid_email_and_password() throws IOException {
        homepage.getMyaccountdropdown().click();
        homepage.getLogin().click();
        login = new LogInPage(driver);
        login.getEmailfield().sendKeys(FileUtils.readCommonData("email"));
        login.getPasswordfield().sendKeys(FileUtils.readCommonData("password"));
    }

    @When("I enter invalid email and password")
    public void i_enter_invalid_email_and_password() throws IOException {
        homepage.getMyaccountdropdown().click();
        homepage.getLogin().click();
        login = new LogInPage(driver);
        login.getEmailfield().sendKeys("invalidemail@example.com");
        login.getPasswordfield().sendKeys("wrongpassword");
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        login.getLoginbtn().click();
    }

    @Then("I should see my account page")
    public void i_should_see_my_account_page() throws IOException {
        Assert.assertEquals(login.getEditYourAccountLinkText().getText(), FileUtils.readCommonData("accountcreated"));
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() throws IOException {
        Assert.assertEquals(login.getWarningmessage().getText(), FileUtils.readCommonData("warningmessage"));
    }
}
