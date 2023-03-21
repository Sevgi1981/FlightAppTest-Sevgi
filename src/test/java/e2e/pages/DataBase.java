package e2e.pages;

import e2e.utils.CommonMethods;
import e2e.utils.DBUtils;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase extends CommonMethods {

    public DataBase(){
        PageFactory.initElements(driver,this);
    }

    public void verifyDB() throws SQLException {
        DBUtils.createDBConnection();
        ResultSet resultSet= DBUtils.runQuery("select * from users");
        resultSet.last();
        String verifyEmail=resultSet.getString("user_email");
        String verifyName = resultSet.getString("user_first_name");
        String verifyLastName = resultSet.getString("user_last_name");
        String verifyPhoneNumber = resultSet.getString("user_phone_number");
        System.out.println(verifyEmail);
        System.out.println(verifyName);
        System.out.println(verifyLastName);
        System.out.println(verifyPhoneNumber);
        System.out.println(accountPage.getUserEmail());
        System.out.println(accountPage.getUserName());
        System.out.println(accountPage.getUserLastName());
        System.out.println(accountPage.getUserPhoneNumber());
        Assert.assertEquals(accountPage.getUserEmail(),verifyEmail);
        Assert.assertEquals(accountPage.getUserName(),verifyName);
        Assert.assertEquals(accountPage.getUserLastName(),verifyLastName);
        Assert.assertEquals(accountPage.getUserPhoneNumber(),verifyPhoneNumber);
        DBUtils.closeDatabase();

    }
}
