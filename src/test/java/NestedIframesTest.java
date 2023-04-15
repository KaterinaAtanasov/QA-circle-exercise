import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NestedIframesTest extends  BaseTestSetup{
    @Test
    public void nestedIframeTest(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftFrame= driver.findElement(By.tagName("body"));
        String leftFrameText = leftFrame.getText();
        Assert.assertEquals(leftFrameText,"LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame=driver.findElement(By.tagName("body"));
        String middleFrameText= middleFrame.getText();
        Assert.assertEquals(middleFrameText,"MIDDLE");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.tagName("body"));
        String rightFrameText = rightFrame.getText();
        Assert.assertEquals(rightFrameText,"RIGHT");

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomFrame = driver.findElement(By.tagName("body"));
        String bottomFrameText = bottomFrame.getText();
        Assert.assertEquals(bottomFrameText,"BOTTOM");


        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        WebElement topFrame = driver.findElement(By.tagName("frame"));
        String topFrameText = topFrame.getText();
        Assert.assertNotNull(topFrameText,"Element with %s locator is not present");


    }
}
