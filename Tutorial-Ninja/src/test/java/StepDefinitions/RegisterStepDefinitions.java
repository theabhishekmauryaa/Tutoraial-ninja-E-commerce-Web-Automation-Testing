package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import genericutility.Base;
import io.cucumber.java.en.*;
import pomrepository.RegisterPage;

public class RegisterStepDefinitions extends Base {

    RegisterPage registerPage;

    @Given("the user is on the registration page")
    public void navigateToRegistrationPage() {
        ClickOnRegister();
        registerPage = new RegisterPage(driver);
    }

    @When("the user enters valid details and submits the form")
    public void enterValidDetails() throws IOException {
        registerPage.getFirstnamefield().sendKeys(FileUtils.readCommonData("firstname"));
        registerPage.getLastnamefield().sendKeys(FileUtils.readCommonData("lastname"));
        registerPage.getEmailfield().sendKeys(FileUtils.readCommonData("emailid"));
        registerPage.getTelephonefield().sendKeys(FileUtils.readCommonData("telephone"));
        registerPage.getPasswordfield().sendKeys(FileUtils.readCommonData("pass"));
        registerPage.getPasswordconfirmfield().sendKeys(FileUtils.readCommonData("passconfirm"));
        registerPage.getPrivacyCheckbox().click();
        registerPage.getContinuebutton().click();
    }

    @Then("the registration should be successful")
    public void verifyRegistrationSuccess() {
        assertTrue(registerPage.getRegistrationsuccess().isDisplayed());
    }

    @When("the user enters details with an existing email and submits the form")
    public void enterExistingEmailDetails() throws IOException {
        registerPage.getFirstnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getLastnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getEmailfield().sendKeys(FileUtils.readCommonData("emailid"));
        registerPage.getTelephonefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPasswordfield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPasswordconfirmfield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPrivacyCheckbox().click();
        registerPage.getContinuebutton().click();
    }

    @Then("an error message should be displayed for using an existing email")
    public void verifyExistingEmailError() {
        assertTrue(registerPage.getExistingemailwarning().isDisplayed());
    }

    @When("the user enters valid details but does not select the privacy checkbox")
    public void skipPrivacyCheckbox() throws IOException {
        registerPage.getFirstnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getLastnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getEmailfield().sendKeys(JavaUtils.TimeStamp() + "@gmail.com");
        registerPage.getTelephonefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPasswordfield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPasswordconfirmfield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getContinuebutton().click();
    }

    @Then("an error message for privacy checkbox must be displayed")
    public void verifyPrivacyCheckboxError() {
        assertTrue(registerPage.getPrivacywarning().isDisplayed());
    }

    @When("the user enters mismatched passwords and submits the form")
    public void enterMismatchedPasswords() throws IOException {
        registerPage.getFirstnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getLastnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getEmailfield().sendKeys(JavaUtils.TimeStamp() + "@gmail.com");
        registerPage.getTelephonefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPasswordfield().sendKeys(FileUtils.readCommonData("pass"));
        registerPage.getPasswordconfirmfield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPrivacyCheckbox().click();
        registerPage.getContinuebutton().click();
    }

    @Then("an error message for mismatched passwords must be displayed")
    public void verifyMismatchedPasswordError() {
        assertTrue(registerPage.getPasswordwarning().isDisplayed());
    }

    @When("the user skips the confirm password and submits the form")
    public void skipConfirmPassword() throws IOException {
        registerPage.getFirstnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getLastnamefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getEmailfield().sendKeys(JavaUtils.TimeStamp() + "@gmail.com");
        registerPage.getTelephonefield().sendKeys(JavaUtils.TimeStamp());
        registerPage.getPasswordfield().sendKeys(FileUtils.readCommonData("pass"));
        registerPage.getPrivacyCheckbox().click();
        registerPage.getContinuebutton().click();
    }

    @Then("an error message for missing confirm password must be displayed")
    public void verifyMissingConfirmPasswordError() throws IOException {
        assertTrue(registerPage.getPasswordconfirmwarning().getText()
                .equalsIgnoreCase(FileUtils.readCommonData("passwordconfirmwarning")));
    }
}
