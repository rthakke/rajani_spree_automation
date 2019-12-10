package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import suite.SuiteManager;
import util.DriverManager;

public class BasePage extends SuiteManager {

    WebDriverWait wait = new WebDriverWait(DriverManager.driver, 10);

    public BasePage()
    {
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(css = "#link-to-login")
    private WebElement loginbutton;

    public LoginPage clickLoginButton()
    {
        wait.until(ExpectedConditions.visibilityOf(loginbutton)).click();

        return new LoginPage();
    }

}
