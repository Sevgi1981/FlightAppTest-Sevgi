package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Account_SignUp extends CommonMethods {

    @Given("User navigates to website and verify title as {string}")
    public void user_navigates_to_website_and_verify_title_as(String actualTitle) {
        Assert.assertEquals(actualTitle,homePage.getTitle());
    }
    @When("User verify Home Page header title as {string}")
    public void user_verify_home_page_header_title_as(String actualSearchFlightTitle) {
         Assert.assertEquals(actualSearchFlightTitle,homePage.getFlightText());
    }
    @Then("User clicks signup button and verifies signup page header as {string}")
    public void user_clicks_signup_button_and_verifies_signup_page_header_as(String actualSignUpHeaderTitle) {
          accountPage.setSignUpButton();
          Assert.assertEquals(actualSignUpHeaderTitle,accountPage.setSignUpText());
    }
    @Then("User fill up signup form")
    public void user_fill_up_signup_form() {
        accountPage.setFirstName();
        accountPage.setUserLastName();
        accountPage.setEmail();
        accountPage.setPhoneNumber();
        accountPage.setPassword();
        accountPage.setUserPasswordRepeat();
        accountPage.setGender();


    }
    @Then("User clicks signup button")
    public void user_clicks_signup_button() {
        accountPage.setSignUp();
    }
    @Then("User verify success message as {string}")
    public void user_verify_success_message_as(String actualAlertMessage) {
        Assert.assertEquals(actualAlertMessage,accountPage.setAlertMessage());
    }
}
