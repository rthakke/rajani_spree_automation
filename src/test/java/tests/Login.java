package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class Login extends SuiteManager {
    ConfigFileReader config;

    @Test
    public void Login  ()
    {
        DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys("rajanith@gmail.com");
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys("spree123");
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
