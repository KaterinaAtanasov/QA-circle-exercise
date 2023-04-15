import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WindowsTest extends BaseTestSetup{
    @Test
    public void windowsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String firstWindow = driver.getWindowHandle();

        WebElement newWindow = driver.findElement(By.xpath("//a[contains(@href,'/windows/new')]"));
        newWindow.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!firstWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(200);
        //       wait.until(ExpectedConditions.titleIs("New Window"));
        wait.until(ExpectedConditions.urlContains("/windows/new"));
        String expectedUrl = "https://the-internet.herokuapp.com/windows/new";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Actual page is not the same as expected", expectedUrl, actualUrl);
        String newPageTitle = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        Assert.assertNotNull("New window is not present", newPageTitle);
        Assert.assertEquals(newPageTitle, "New Window");

        driver.switchTo().window(firstWindow);
        Thread.sleep(200);

    }
}
