import org.testng.annotations.Test;


public class A_Class {
    @Test (groups = { "smoke", "regression" }, priority = 2 )
    public  void A_Class()
    {
        System.out.println("Message from A_Class");
    }
}
