package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    /*
       Actions class'ı kullanarak mouse ve keyboard işlemleri yapılır.Mesela mous ile sayfayı aşağıya yukarıya kaydırma-sağa sola tıklama
       2 tip actions vardır:
         Mouse-based actions (mouse ile yapılabilecek her işlem ) : double click,right click-click and hold,drag and drop
         Keyboard-based actions (klavye ile yapılacak işlemler ) : shift,ctrl,alt,tab,kopyala-yapıştır

         1.ADIM : Actions class'ta bir object oluşturulur.Actions selenium'can gelir.
                 Actions actions = new Actions(driver);
         2.ADIM : Üzerinde çalışmak istediğiniz WebElement ögesini bulunur
                 WebElement element = driver.findElement(locator);
         3.ADIM : perform() kullanılarak bu webelement üzerinde actionn gerçekleştirilir.Örneğin tıklamak için
                 actions.click(element).perform();  (ortadaki methodlar click(element) kısmı değişkendir. actions ve perform() kısımları değşmez sabittir
          NOT: Tüm actions'lar actions() objesi ile başlar perform() methodu ile biter

              NOT : actions class'ını her kullanmak istediğimizde yeniden obje oluşturmamız gerekmez.Aynı obje tekrar tekrar driver objesi gibi kullanılabilir
              NOT : actions objesi kullanılarak başlayan her komut,çalışmak için perform() bekler

         MOUSE BASE ACTİONS :
         doubleClick() => Webelement'e çift tıklama yapar
         clickAndHold() => Webelement üzerinde click yapılı olarak bizden komut bekler
         dragAndDrop() => webelementi bir noktadan diğerine sürükler bırakır
         moveToElement() => mouse'u istediğimiz webelemtin üzerinde tutar
         contextClick() => mouse ile istediğimiz webelemente sağ tıklama yapar

         KEYBOARD BASE ACTİONS:

     */

    @Test
    public void rightClickTest(){

        //Method: rightClick
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
           //1.Adım : actions objesi oluşturulur
        Actions actions = new Actions(driver);
           //2.Adım : Elementi locate edelim
        WebElement kutu = driver.findElement(By.xpath("//div[@id='hot-spot']"));
           //3.Adım : Kutuya sağa tıklama
        actions.contextClick(kutu).perform(); //parametredeki adrese sağ tıklar

        waitFor(3);

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");

        waitFor(3);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }

}
