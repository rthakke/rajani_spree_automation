package pages;

import org.openqa.selenium.support.PageFactory;
import util.ConfigFileReader;
import util.DriverManager;

public class HomePage {

    public void homePage()
    {

        PageFactory.initElements(DriverManager.driver,this);

    }
}
