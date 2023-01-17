package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    /*
    Actions'lar Selenium'un bir kütüphanesidir
       Actions class'ı kullanarak mouse ve keyboard işlemleri yapılır.Mesela mouse ile sayfayı aşağıya yukarıya kaydırma-sağa sola tıklama..
       2 tip actions vardır:
         Mouse-based actions (mouse ile yapılabilecek her işlem ) : double click,right click-click and hold,drag and drop,moveToElement
         Keyboard-based actions (klavye ile yapılacak işlemler ) : shift,ctrl,alt,tab,kopyala-yapıştır

         1.ADIM : Actions class'ta bir object oluşturulur.Actions selenium'can gelir.
                 Actions actions = new Actions(driver); //yani actions driver'ın yapabileceiği şeyleri yapsın diyoruz driver'ı gömüyoruz

         2.ADIM : Üzerinde çalışmak istediğiniz WebElement ögesini bulunur
                 WebElement element = driver.findElement(locator);

         3.ADIM : perform() kullanılarak bu webelement üzerinde actionn gerçekleştirilir.Örneğin tıklamak için
                 actions.click(element).perform();  (ortadaki methodlar click(element) kısmı değişkendir. actions ve perform() kısımları değişmez sabittir

          NOT: Tüm actions'lar actions() objesi ile başlar perform() methodu ile biter

              NOT : actions class'ını her kullanmak istediğimizde yeniden obje oluşturmamız gerekmez.Aynı obje aynı class'ta olmak şartıyla
                    tekrar tekrar kullanılabilir.Farklı bir sınıfta tekrar oluşturmamız gerekir

              NOT : actions objesi kullanılarak başlayan her komut,çalışmak için "perform()" bekler

              perfom() methodu işi bitir demek

         MOUSE BASE ACTİONS :
         doubleClick() => Webelement'e çift tıklama yapar
         clickAndHold() => Webelement üzerinde click yapılı olarak bizden komut bekler - tıkla ve bekle
         dragAndDrop() => webelementi bir noktadan diğerine sürükler bırakır -tut sürükle bırak
         moveToElement() => mouse'u istediğimiz webelemtin üzerinde tutar
         contextClick() => mouse ile istediğimiz webelemente sağ tıklama yapar
            contexClick(Webelement ) ve contexClick() olmak üzere iki method vardır.Biri parametreli biri parametresiz
            contexClick(Webelement ) => içine locate'ini aldığımız elemnti koyarız ve o elemente sağ tıkyapar
            contexClick() => bu ise driver a an nerenin üzerindeyse oraya sağ tık yapar

         KEYBOARD BASE ACTİONS:

     */

    @Test
    public void rightClickTest(){

        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Kutuya sag tıklayın
           //1.Adım : actions objesi oluşturulur .(actions!=action)
        Actions actions = new Actions(driver);

           //2.Adım : Elementi locate edelim
        WebElement kutu = driver.findElement(By.xpath("//div[@id='hot-spot']"));

           //3.Adım : Kutuya sağa tıklama
             //NOTE: Tüm actions'lar  actions OBJESİYLE BAŞLAR perform() ile BİTER
        actions.contextClick(kutu).perform(); //parametredeki adrese sağ tıklar

        waitFor(3);

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        Assert.assertEquals(driver.switchTo().alert().getText(),"You selected a context menu");

        waitFor(3);

        //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }

}
