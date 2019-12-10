package tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class SearchPage extends Login {
    ConfigFileReader config;
    String searchItem;
   @BeforeClass
   public void loginBeforeSearch()
   {
       Login login = new Login();
       login.login("rajanith@gmail.com","spree123");

   }

    @BeforeTest
    public void getSearchItemFromProperties()
    {
        config = new ConfigFileReader();
        searchItem = config.getProperty("searchItem");
    }
    @Test
    public void searchItem()
    {
        DriverManager.driver.findElement(By.id("keywords")).sendKeys(searchItem);
        DriverManager.driver.findElement(By.cssSelector("input.btn.btn-success")).click();
        System.out.println("Searched for an Item");
    }

}
