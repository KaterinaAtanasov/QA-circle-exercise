import org.junit.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AddRemoveElementsTest extends BaseTestSetup {

    @Test
    public void AddRemoveElementsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        WebElement addElements = driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
        int clickCount = 0;
        while (clickCount < 5) {
            addElements.click();
            clickCount++;
        }
        Assert.assertEquals(clickCount,5,"The Add button was clicked " + clickCount + " times instead of 5 times.");

        List<WebElement> deleteElements = driver.findElements(By.xpath("//button[contains(text(),'Delete')]"));
        int deleteCount = 0;
        for (WebElement deleteButton : deleteElements) {
            deleteButton.click();
            deleteCount++;
        }
        Assert.assertEquals(deleteCount,5,"The Delete button was clicked " + clickCount + " times instead of 5 times.");

        Thread.sleep(200);
    }
}
