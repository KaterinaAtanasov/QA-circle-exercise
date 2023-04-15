import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HoverOnElementsTest extends BaseTestSetup{
    @Test
    public void hoverOnElementsTest(){
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement firstFigure = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        actions.moveToElement(firstFigure).perform();
        String firstUser = driver.findElement(By.xpath("//h5[contains(text(),'name: user1')]")).getText();
        Assert.assertNotNull(firstUser,"Element with %s is not present");
        Assert.assertEquals(firstUser,"name: user1");

        WebElement secondFigure = driver.findElement(By.xpath("//div[@class='figure'][2]"));
        actions.moveToElement(secondFigure).perform();
        String secondUser = driver.findElement(By.xpath("//h5[contains(text(),'name: user2')]")).getText();
        Assert.assertNotNull(secondUser,"Element with %s is not present" );
        Assert.assertEquals(secondUser,"name: user2");

        WebElement thirdFigure = driver.findElement(By.xpath("//div[@class='figure'][3]"));
        actions.moveToElement(thirdFigure).perform();
        String thirdUser = driver.findElement(By.xpath("//h5[contains(text(),'name: user3')]")).getText();
        Assert.assertNotNull(thirdUser,"Element with %s is not present");
        Assert.assertEquals(thirdUser,"name: user3");
    }
}
