package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Account_SignUp_API extends CommonMethods {


    @Given("User add request Payload")
    public void user_add_request_payload() {
        api.setAPIBody();

    }
    @When("User send request")
    public void user_send_request() {
     api.sendRequest();
    }
    @Then("User verifies status code is {int}")
    public void user_verifies_status_code_is(Integer statusCode) {
     api.verifyPayload(statusCode);
    }
    @Then("User Login with UI by given credentials from API")
    public void user_login_with_ui_by_given_credentials_from_api() {
       api.loginWithUI();
    }

}
