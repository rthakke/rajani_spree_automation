package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import suite.SuiteManager;
import testdata.LoginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

public class Login extends SuiteManager {
    ConfigFileReader config;
    String username;
    String password;

   /* @BeforeTest
    public void getLoginFromProperties(){
         config = new ConfigFileReader();
         username = config.getProperty("username");
         password = config.getProperty("password");
    }

    */

    @Test (dataProvider = "loginCredentials",dataProviderClass = LoginCredentials.class)
    public void login  (String username,String password)
    {
        int size = DriverManager.driver.findElements(By.linkText("Logout")).size();
        if(size > 0)
        {
            DriverManager.driver.findElement(By.linkText("Logout")).click();
        }


        DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(username);
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(password);
        DriverManager.driver.findElement(By.name("commit")).click();
        String st = DriverManager.driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();

        //verify login successful message
        if(DriverManager.driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed()) {

            System.out.println("Login Successful");
        } else{

            System.out.println("Login failed");
        }

    }
}
