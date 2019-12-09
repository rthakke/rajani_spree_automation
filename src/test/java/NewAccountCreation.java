import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class NewAccountCreation {
    @Test
    public void CreateNewAccount() {

    System.setProperty("webdriver.chrome.driver","/Users/techops/Downloads/chromeDriver");
    WebDriver driver = new ChromeDriver();
    driver.get("https://spree-vapasi-prod.herokuapp.com");
    //Thread.sleep(5000);
        System.out.println(("Started Create Account Script"));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
    driver.findElement(By.id("link-to-login")).click();
    driver.findElement(By.linkText("Create a new account")).click();
    int i=100;
        UUID email_id= UUID.randomUUID();
    driver.findElement(By.id("spree_user_email")).sendKeys("test"+email_id+"@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("test1gmailcom");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("test1gmailcom");
        driver.findElement(By.name("commit")).click();
        // driver.manage().timeouts().implicitlyWait(5000,TimeUnit.SECONDS);

        String Login_Success = driver.findElement(By.cssSelector("div.alert.alert-notice")).getText();
        System.out.println(Login_Success);
        if (Login_Success == "Welcome! You have signed up successfully.")

            System.out.println("Account created and Logged in Successfully.");

        System.out.println("Trying to click My Account link in Home page");
        String myAccount = driver.findElement(By.partialLinkText("Account")).getText();
        if(myAccount == "My Account");
        System.out.println("Logged in Successfully");
        driver.findElement(By.partialLinkText("Account")).click();
        System.out.println("Clicked on My Account link in Home page");
        System.out.println("Completed CreateAccount script");
       // driver.close();

}
}
