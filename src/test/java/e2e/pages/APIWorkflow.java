package e2e.pages;

import com.github.javafaker.Faker;
import e2e.utils.APIConstants;
import e2e.utils.APIPayloadConstants;
import e2e.utils.CommonMethods;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class APIWorkflow extends CommonMethods {

    Faker faker = new Faker();
    AccountPage accountPage = new AccountPage();
    String userName="";
    String userLastName="";
    String userEmail="";
    String userPhoneNumber="";
    String userPassword="Password1";
    String userGender="";
    String userImage="";

    RequestSpecification requestSpecification;
    Response response;

    public APIWorkflow(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "input[name='userEmail']")
    private WebElement userEmail1;
    @FindBy(css = "input[name='userPassword']")
    private WebElement userPassword1;
    public void setAPIBody(){
        userName=faker.name().firstName();
        userLastName=faker.name().lastName();
        userEmail=faker.internet().emailAddress();
        userPhoneNumber=faker.phoneNumber().cellPhone().replace("-","");
        userGender="MALE";
        userImage=null;

        requestSpecification=given()
                .header(APIConstants.Content_Type_Value,APIConstants.Header_Content_Type)
                .body(APIPayloadConstants.signUp(userName,userLastName,userEmail,userPhoneNumber,userPassword,userGender,userImage));
    }
    public void sendRequest(){
        response=requestSpecification.post(APIConstants.signUp);
    }
    public void verifyPayload(Integer status){
        System.out.println(response.body().prettyPrint());
        response.then().assertThat().statusCode(status);
        String responseFirstName=response.body().jsonPath().getString("userFirstName");
        Assert.assertEquals(responseFirstName,userName);
    }
    public void loginWithUI(){
        accountPage.setClickLoginOnHeader();
        userEmail1.sendKeys(userEmail);
        userPassword1.sendKeys(userPassword);
        accountPage.clickLoginOnBottom();

    }
}
