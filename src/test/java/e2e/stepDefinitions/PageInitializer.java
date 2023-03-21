package e2e.stepDefinitions;

import e2e.pages.APIWorkflow;
import e2e.pages.AccountPage;
import e2e.pages.DataBase;
import e2e.pages.HomePage;

public class PageInitializer {

    public static AccountPage accountPage;
     public static HomePage homePage;
     public static DataBase db;
     public static APIWorkflow api;

    public static void initializePageObjects(){

        accountPage = new AccountPage();
        homePage = new HomePage();
        db = new DataBase();
        api = new APIWorkflow();

    }
}
