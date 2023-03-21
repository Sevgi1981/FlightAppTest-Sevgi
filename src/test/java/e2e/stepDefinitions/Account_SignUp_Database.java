package e2e.stepDefinitions;

import e2e.utils.CommonMethods;
import io.cucumber.java.en.Then;

import java.sql.SQLException;

public class Account_SignUp_Database extends CommonMethods {



    @Then("Verify user is created in Database")
    public void verify_user_is_created_in_database() throws SQLException {
       db.verifyDB();
    }
}
