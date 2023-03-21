package e2e.pages;

import e2e.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonMethods {

    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[.='Search Flight']")
    private WebElement searchFlightText;
    @FindBy(id = "dropdownMenuLink")
    private WebElement accountName;



    public String getTitle(){
        return driver.getTitle();
    }
    public String getFlightText(){
        return searchFlightText.getText();
    }
    public String setAccountName(){
        return accountName.getText();
    }
}
