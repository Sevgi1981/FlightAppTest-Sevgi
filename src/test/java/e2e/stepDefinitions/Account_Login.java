package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.Then;

public class Account_Login extends CommonMethods {


    @Then("click login button")
    public void click_login_button() {
        accountPage.setClickLoginOnHeader();
    }
    @Then("Enter email and password")
    public void enter_email_and_password() {
   accountPage.setValidCredentials();
    }
    @Then("click login for provided credentials")
    public void click_login_for_provided_credentials() {
        accountPage.clickLoginOnBottom();
    }
    @Then("verify username on header")
    public void verify_username_on_header() {
        accountPage.verifyAccountName();
    }
}
