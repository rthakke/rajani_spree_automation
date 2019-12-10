package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;

public class LoginTest_POM extends SuiteManager {
    public BasePage basePage;
    public LoginPage loginpage;
    public HomePage homePage;

    @Test
    public void loginTest_POM(){
        basePage = new BasePage();
         loginpage = basePage.clickLoginButton();
         homePage = loginpage.login();

    }



}
