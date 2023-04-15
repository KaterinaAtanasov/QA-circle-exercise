import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.testng.Assert;

public class DragAndDropJqueryui extends BaseTestSetup{
    @Test
    public void dragAndDropJqueryui(){
        driver.get("https://jqueryui.com/droppable/");
        WebElement iFrame = driver.findElement(By.xpath("//*[@class='demo-frame']"));

        driver.switchTo().frame(iFrame);

        WebElement dropFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dragTo = driver.findElement(By.xpath("//div[@id='droppable']"));

        WebElement droppedTxt = driver.findElement(By.xpath("//div[@id='droppable']/p"));

        Assert.assertEquals(droppedTxt.getText(), "Drop here");

        Action action = actions.dragAndDrop(dropFrom, dragTo).release(dropFrom).build();

        action.perform();

        droppedTxt = driver.findElement(By.xpath("//div[@id='droppable']/p"));

        Assert.assertEquals(droppedTxt.getText(), "Dropped!");
        driver.switchTo().defaultContent();
    }
    }

