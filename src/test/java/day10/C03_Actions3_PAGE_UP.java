package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3_PAGE_UP extends TestBase {

    //sayfayı ne kadr aşağıya veya yukarıya sürükleyeceğini bilemeyiz bu dezavantajdır.js ile limit koyabiliriz
    //PAGE_DOWN : sayfayı aşağı sürekle
    //PAGE_UP : sayfayı yukarı ittir
    //Method : scrollUpDown()
    @Test
    public void scrollUpDown(){

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);

     /*
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
     */
        actions.
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform(); //bu şekilde arka arkaya da kullanılabilir.

       //ARROW_DOWN PAGE_DOWN'dan daha az mesafe alır.
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        //Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.ARROW_UP).perform(); //arrow_up biraz daha az mesafe ile yukarı çıkarır


    }
}
