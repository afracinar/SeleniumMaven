package calısmalar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day12_HoverOver extends TestBase {

    @Test
    public void test(){

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("https://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverKutu =driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOverKutu).perform();
        waitFor(2);

        //3. "Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();

        //4. Popup mesajini yazdirin
        System.out.println("Alet mesajı :"+driver.switchTo().alert().getText());
        waitFor(2);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        waitFor(2);

        //6. "Click and hold" kutusuna basili tutun

        WebElement clickAndHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        clickAndHold.sendKeys(Keys.PAGE_DOWN);
        actions.clickAndHold(clickAndHold).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold kutusunda çıkan yazı :"+clickAndHold.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement  doubleClickMe = driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClickMe).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın


    }

}
