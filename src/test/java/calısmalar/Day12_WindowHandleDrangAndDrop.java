package calısmalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Day12_WindowHandleDrangAndDrop extends TestBase {

    @Test
    public void test(){

        //   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("https://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        String handle = driver.getWindowHandle();

        //Başkentleri ülkeleriyle eşleştirin
        for(int i =1 ; i<8 ; i++){
            WebElement source = driver.findElement(By.id("box"+i));
            WebElement target = driver.findElement(By.id("box"+(100+i)));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source,target).perform();
        }

    }
}
