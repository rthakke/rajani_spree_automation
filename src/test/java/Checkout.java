//import apple.laf.JRSUIConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Checkout {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","/Users/techops/Downloads/chromeDriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi-prod.herokuapp.com");
        //Thread.sleep(5000);
        System.out.println("Started Checkout script");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.linkText("Create a new account")).click();
        int i=100;
        UUID email_id= UUID.randomUUID();
        driver.findElement(By.id("spree_user_email")).sendKeys("test"+email_id+"@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("test1gmailcom");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("test1gmailcom");
        driver.findElement(By.name("commit")).click();
        String myAccount = driver.findElement(By.partialLinkText("Account")).getText();
        if(myAccount == "My Account");
        System.out.println("Logged in Successfully");

        driver.findElement(By.id("keywords")).sendKeys("Bag");
        driver.findElement(By.cssSelector("input.btn.btn-success")).click();
        System.out.println("Searched for an Item");

        driver.findElement(By.xpath("//div[@id='products']/div[2]")).click();
        System.out.println("selected second product from the search results");

        driver.findElement(By.id("add-to-cart-button")).click();
        String product_selected = driver.findElement(By.cssSelector("h1.product-title.mt-2")).getText();

        driver.findElement(By.id("checkout-link")).click();
        System.out.println("Clicked on checkout");

        driver.findElement(By.id("link-to-cart")).click();
        String product_in_cart=driver.findElement(By.xpath("//tbody[@id='line_items']/tr/td[2]/h4/a")).getText();

        if (product_in_cart.equals(product_selected))
            System.out.println("Product has been checkedout successfully");

        System.out.println("Closing the driver");
        driver.close();
    }
}
