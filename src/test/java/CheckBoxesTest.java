import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTestSetup{
    @Test
            public void checkBoxesTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        Thread.sleep(1000);

        for (int j = 0; j < 2; j++) {
            Thread.sleep(1000);
            WebElement checkbox = allCheckboxes.get(j);

            if (checkbox.isSelected() == false)
                checkbox.click();

            Assert.assertTrue(checkbox.isSelected()== true, "Checkbox is not selected.");
        }

        Thread.sleep(1000);

        }
    }


