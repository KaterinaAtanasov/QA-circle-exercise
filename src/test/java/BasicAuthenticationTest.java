import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BasicAuthenticationTest extends BaseTestSetup{
    @Test
    public void basicAuthenticationTest() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String successfulMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(successfulMessage, "Congratulations! You must have the proper credentials.");
        Thread.sleep(250);
    }


}
