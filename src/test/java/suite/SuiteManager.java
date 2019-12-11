package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import util.ConfigFileReader;
import util.DriverManager;

import java.net.MalformedURLException;

public class SuiteManager {
    DriverManager driverManager;

    private static ConfigFileReader config = new ConfigFileReader();

    @BeforeSuite (alwaysRun = true)
    public void startDriver() throws MalformedURLException {
        driverManager = new DriverManager();

    }

    @AfterSuite
    public void quitDriver(){

        driverManager.driver.quit();
    }

     @BeforeClass
    public void launchUrl() {
       // DriverManager.driver.manage().window().maximize();
        String baseUrl = config.getProperty("base_url");
        System.out.println("Base Url  " + baseUrl);
        //DriverManager.driver.get(baseUrl);
         driverManager.driver.get(baseUrl);
    }
}
