import org.testng.annotations.Test;


public class B_Class {

    @Test (priority=2 , groups = { "smoke"})
    public void B_Class()
    {
System.out.println("Message from Class B priority 2");
    }

    @Test (priority=1)
    public void C_Class()
    {
        System.out.println("Message from Class B priority 1");
    }
}
