import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentTest extends BaseTestSetup{
    @Test
    public void dynamicContentTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_content");

        By rowsTexts = By.xpath("//div[@class='large-10 columns']");
        By rowsImages = By.xpath("//div[@class='large-2 columns']/img");

        List<WebElement> listTextsElements = driver.findElements(rowsTexts);
        List<WebElement> listImagesElements = driver.findElements(rowsImages);

        List<String> listTexts = new ArrayList<>();
        for (WebElement element : listTextsElements
        ) {
            listTexts.add(element.getText());
        }

        List<String> listImages = new ArrayList<>();
        for (WebElement element : listImagesElements
        ) {
            listImages.add(element.getAttribute("src"));
        }

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(@href, 'static')]"));
        clickHere.click();

        List<WebElement> listTextsAfter = driver.findElements(rowsTexts);
        List<WebElement> listImagesAfter = driver.findElements(rowsImages);

        for (int i = 0; i < listTextsAfter.size(); i++) {
            Assert.assertNotEquals(listTexts.get(i), listTextsAfter.get(i).getText());
        }

        for (int i = 0; i < listImagesAfter.size(); i++) {
            Assert.assertNotEquals(listImages.get(i), listImagesAfter.get(i).getAttribute("src"));
        }

        Thread.sleep(2000);
    }
}
