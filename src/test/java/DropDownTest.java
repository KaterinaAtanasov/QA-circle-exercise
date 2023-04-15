import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDownTest extends BaseTestSetup{
    @Test
    public void dropDownMenuTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select dropdownOptions = new Select(dropdown);
        dropdownOptions.getOptions();
        dropdownOptions.selectByValue("1");
        String selectedOption = dropdownOptions.getFirstSelectedOption().getText();
        Assert.assertEquals("Option 1", selectedOption);

        Thread.sleep(250);
    }
}
