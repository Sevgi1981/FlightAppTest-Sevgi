package e2e;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static e2e.utils.CommonMethods.driver;

public class loginAlertButton {
    String username="sevgi";
    char [] password={'c','f'};

    public void Test1(){;


        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));  //  create wait
        Alert alert= wait.until(ExpectedConditions.alertIsPresent()); //create alert with wait method until alert is present
        //Alert.sendKeys(new UsernamePasswordCredentials(username, password));

    }
}
