package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class LoginPage extends SuiteManager {

    ConfigFileReader config;
    public LoginPage()
    {
        PageFactory.initElements(DriverManager.driver,this);
        config = new ConfigFileReader();
    }

    @FindBy(id = "spree_user_email")
    private WebElement username;

    @FindBy(id = "spree_user_password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement clickLoginButton;

    public HomePage login()
    {
        username.sendKeys(config.getProperty("username"));
        password.sendKeys(config.getProperty("password"));
        clickLoginButton.click();
        return new HomePage();
    }
}
