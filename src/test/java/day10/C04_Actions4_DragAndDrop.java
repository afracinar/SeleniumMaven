package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4_DragAndDrop extends TestBase {

    //dragAndDrop methodu sürükleme işlemini gerçekleştirir.
    // en çok sürükleme için bu method kullanılır.tıklar-sürükler-bırakır
    //2 parametre ile çalışır.kaynak ve hedef

        @Test
    public void dragAndDropTest(){

            //Given user is on https://jqueryui.com/droppable/
            driver.get("https://jqueryui.com/droppable/");

            driver.switchTo().frame(0); //kaynak ve hedef elemetnleri iframe içinde olduğu için ilk olarak iframe içine girmemiz gerkiyor
                                             //iframe sayfa içinde sayfa demektir

            //And user moves the target element(Drag me to my target) in to  destination(Drop here)
            Actions actions = new Actions(driver);

            WebElement kaynak = driver.findElement(By.id("draggable"));
            WebElement hedef = driver.findElement(By.id("droppable"));

            actions.dragAndDrop(kaynak, hedef).perform(); //birinci parametre kaynak ,ikinci parametre hedefimizdir.

        }

        //2.YÖNTEM

    @Test
    public void clickAndHoldTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); //kaynak ve hedef elemetnleri iframe içinde olduğu için ilk olarak iframe içine girmemiz gerkiyor

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        //clickAndHold Webelement üzerinde click yaparak bizden komut bekler
        actions.
                clickAndHold(kaynak). //kaynağı tut
                moveToElement(hedef). //hedefe koy
                release(). //kaynağı bırak
                build(). //önceki methodların ilişkisini kur güçlendir.Kullanılması tercih edilir şart değil uzun kodlarda tercih edilir
                perform(); //işlemi gerçekleştir,uygula

    }

    @Test
    public void moveByOffSetTest(){

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); //kaynak ve hedef elemetnleri iframe içinde olduğu için ilk olarak iframe içine girmemiz gerkiyor

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        WebElement kaynak = driver.findElement(By.id("draggable"));

        Actions actions = new Actions(driver);

        //moveByOffSet() methodlarının içine x,y koordinat değerleri verilir
        actions.
                clickAndHold(kaynak).
                moveByOffset(465,10).
                build().
                perform();




    }
}
