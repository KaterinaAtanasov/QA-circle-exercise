import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RedirectLink extends BaseTestSetup{
    @Test
       public void redirectLinkTest(){
        driver.get("https://the-internet.herokuapp.com/redirector");

        WebElement clickRedirect = driver.findElement(By.id("redirect"));
        clickRedirect.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("status_codes"));

        String pageTitle = driver.findElement(By.xpath("//h3[contains(text(),'Status Codes')]")).getText();
        Assert.assertEquals(pageTitle,"Status Codes");

        WebElement statusCode200 = driver.findElement(By.xpath("//a[contains(@href,'status_codes/200')]"));
        statusCode200.click();
        wait.until(ExpectedConditions.urlContains("status_codes/200"));
        WebElement pageStatusCode200 = driver.findElement(By.xpath("//p[contains(text(),'This page returned a 200 status code.')]"));
        Assert.assertTrue(pageStatusCode200.isDisplayed());

        WebElement clickHereButton = driver.findElement(By.xpath("//a[contains(@href,'/status_codes')]"));
        wait.until(ExpectedConditions.elementToBeClickable(clickHereButton));
        clickHereButton.click();
        Assert.assertEquals(pageTitle,"Status Codes");

        }

    }

