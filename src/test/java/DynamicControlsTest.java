import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTestSetup{
    @Test
    public void dynamicControlsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        WebElement removeButton = driver.findElement(By.cssSelector("button[type='button']"));

        Assert.assertTrue(checkbox.isDisplayed());
        Assert.assertTrue(removeButton.isDisplayed());

        removeButton.click();

        WebElement message= driver.findElement(By.xpath("//*[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(message.isDisplayed());


        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        wait.until(ExpectedConditions.visibilityOf(addButton));
        Assert.assertTrue(addButton.isDisplayed());


        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-example']/input")));
        assertFalse(input.isEnabled());

        WebElement enableDisableInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-example']/button")));
        enableDisableInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        assertTrue(input.isEnabled());

        enableDisableInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        assertFalse(input.isEnabled());
    }
    }

