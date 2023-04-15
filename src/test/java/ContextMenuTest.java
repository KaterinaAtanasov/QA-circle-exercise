import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContextMenuTest extends BaseTestSetup {
    @Test
    public void contextMenuTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement contextMenu = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver).contextClick(contextMenu);
        action.build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        Assert.assertEquals("You selected a context menu", alertText.trim());

        alert.accept();

        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        Assert.assertFalse(isAlertPresent(),"The alert is still present after accepting it.");
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }
}
