package testdata;

import org.testng.annotations.DataProvider;

public class LoginCredentials {
    @DataProvider(name = "loginCredentials")
    public static  Object[][] credentials()
    {

        return new Object[][] {{"rajanith@gmail.com","spree123"},{"test123@gmail.com","test123"},{"test1233@gmail.com","test1233"}};
    }
}
