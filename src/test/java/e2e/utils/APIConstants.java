package e2e.utils;

import io.restassured.RestAssured;

public class APIConstants {
    public static final String BaseUri = RestAssured.baseURI = ConfigReader.getPropertyValues("url");

    public static final String signUp=BaseUri+"/api/auth/signup";
    public static final String signOut=BaseUri+"/api/auth/signout";
    public static final String refreshToken=BaseUri+"/api/auth/refreshtoken";
    public static final String login=BaseUri+"/api/auth/login";

    public static final String Content_Type_Value="Content-Type";
    public static final String Header_Content_Type="application/json";

}
