package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementExceptions extends TestBase {

    /*
       INTERWİEVVV
       -5 adet selenium'da aldığın exceptiondan bahset ?
          NoSuchElemenTeXCEPTİONS
          TimeOutException
          NullPointerException
          StaleElementReferenceException
          WebDriverException
       -Hangi çeşit wait tercih edersin
       -Neden onu tercih edersin?
       -Senkronizasyon problemini nasıl çözersin
     */

    /*
    NoSuchElementException:
      Yanlış locator
      Popup,Iframe,Yeni Pencere
      Sayfa dolmada problemler ve yavaşlamalar
      Saklı olan element

      Çözüm:
      locatorın doğruluğu kontrol edilir
      manuel test ile iframe,yeni pencere,alert gibi elementlerin varlığını kontrol et
      wait(bekleme) problemi olabilir.implictly bekeleme süresini çözmüyor.Explicit wait ya da fluent wait kullanılır.

     */

    public void noSuchElementTest(){

        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER); //yanlış locate aldık
                                                                                             //nosuchelement exception alırız
    }
}
