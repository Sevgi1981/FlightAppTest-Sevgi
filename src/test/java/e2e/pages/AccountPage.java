package e2e.pages;

import com.github.javafaker.Faker;
import e2e.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class AccountPage extends CommonMethods {

    Faker faker = new Faker();
    String userName="";
    String userLastName="";
    String email="";
    String phoneNumber="";
    String password="password1";
    public AccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "Sign")
    private WebElement signUpButton;
    @FindBy(xpath = "//h1[contains(text(),'Sign Up')]")
    private WebElement signUpText;
    @FindBy(css = "input[name='userFirstName']")
    private WebElement firstName;
    @FindBy(css = "input[name='userLastName']")
    private WebElement lastName;
    @FindBy(css = "input[name='userEmail']")
    private WebElement userEmail;
    @FindBy(css = "input[name='userPhoneNumber']")
    private WebElement userPhoneNumber;
    @FindBy(css = "input[name='userPassword']")
    private WebElement userPassword;
    @FindBy(css = "input[name='userPasswordRepeat']")
    private WebElement userPasswordRepeat;
    @FindBy(css = "div[class='form-check row '] label")
    private List<WebElement> gender;
    @FindBy(css= ".btn.btn-primary.mt-3")
    private WebElement signUp;
    @FindBy(css = ".alert.alert-success")
    private WebElement alertMessage;
    @FindBy(xpath = "//div[contains(text(),'Minimum eight characters, at least one uppercase letter, one lowercase letter, one number')]")
    private WebElement wrongPassword;
    @FindBy(partialLinkText = "Login")
    private WebElement loginButtonOnHeader;
    @FindBy(css = ".btn.btn-primary.mt-2")
    private WebElement loginButtonOnBottom;
    @FindBy(xpath = "//div[contains(text(),'Please Enter Phone Number In Format')]")
    private WebElement phoneAlertMessage;


    public void setSignUpButton(){
        click(signUpButton);
    }
    public String setSignUpText(){
        return signUpText.getText();
    }
    public void setFirstName(){
        userName = faker.name().firstName();
        firstName.sendKeys(userName);
    }
    public void setUserLastName(){
        userLastName = faker.name().lastName();
        lastName.sendKeys(userLastName);
    }
    public void setEmail(){
        email=faker.internet().emailAddress();
        userEmail.sendKeys(email);
    }
    public void setPhoneNumber(){
        phoneNumber = faker.phoneNumber().cellPhone().replace("-","");
        userPhoneNumber.sendKeys(phoneNumber);
    }
    public void setPassword(){
        userPassword.sendKeys("password1");
    }
    public void setUserPasswordRepeat(){
        userPasswordRepeat.sendKeys("password1");
    }
    public void setGender(){
        for (WebElement element:
             gender) {
            if (Objects.equals(element.getText(),"Female")){
                element.click();
                click(element);
                System.out.println("radio button for Female is selected");
                break;
            }else {
                System.out.println("Not Selected");
            }
        }
    }
    public void setSignUp(){
        signUp.click();
        click(signUp);
    }
    public String setAlertMessage(){
        Assert.assertTrue(wrongPassword.isDisplayed());
        if (wrongPassword.isDisplayed()){
            userPassword.clear();
            userPassword.sendKeys(password);
            userPasswordRepeat.clear();
            userPasswordRepeat.sendKeys(password);
            click(signUp);
           if (phoneAlertMessage.isDisplayed()){
                userPhoneNumber.clear();
                phoneNumber = faker.phoneNumber().cellPhone().replace("-","");
                userPhoneNumber.sendKeys(phoneNumber);
                click(signUp);
            }
            else {
                System.out.println("All good");
            }
            return alertMessage.getText();
        }else {
            return alertMessage.getText();
        }
    }
    public void setClickLoginOnHeader(){
        click(loginButtonOnHeader);

    }
    public void setValidCredentials(){
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
    }
    public void clickLoginOnBottom(){
        click(loginButtonOnBottom);
    }
    public void verifyAccountName(){
        Assert.assertEquals(userName,homePage.setAccountName());
        System.out.println(userName);
        System.out.println(userLastName);
        System.out.println(email);
        System.out.println(phoneNumber);
    }
    public String getUserEmail(){
        return email;
    }
    public String getUserPhoneNumber(){
        return phoneNumber;
    }
    public String getUserName(){
        return userName;
    }
    public String getUserLastName(){
        return userLastName;
    }






}
