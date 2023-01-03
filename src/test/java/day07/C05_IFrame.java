package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {
    /*
        Interwiev soruları***
          ***Bir sayfadaki toplam iframe sayısımı nasıl buluruz?
            İframe'ler iframe tag'ı kullanılarak oluşturulur
             1.yol = driver.findElements(By.tagName("iframe"));
             2.yol = driver.findElements(By.xpath("//iframe"));

          ***Tekrardan anasayfaya nasıl dönülür?
            2 farklı yol vardır:
          parentFrame veysa default.Content methodları kullanılarak geçiş yapılabilir
          parentFrame ve default.Content,öncelikle her ikiside iframe'in dışına çıkmamızı sağlar.Farkları:
            defaultContent() methodu ile direkt anasayfaya atlatır
            parentFrame ise bir üst seviyeye atlatır

          ***Bir testcase'in fail alma sebepleri neler olabilir?
            1)locator yanlış alınmış olabilir (en fazla alınan sebep) Çözüm:Locator'ı tekrar locate etmeliyiz
            2)Wait/Syncronization/Bekleme problemi  Çözüm: implicitWait de yeterli süre olduğundan emin oluruz.Süreyi arttırabiliriz veya
              Explicit wait kullanılabilir.(daha sonra göreceğiz)
            3)Iframe Çözüm:switch to iframe
            4)Alert Çözüm: switch to alert
            5)New Window (yeni pencere) Çözüm: switch to window

     */

    /*
       //Iframe nedir?
         iframe bir html tag ıdır
         Sayfa içinde sayfa kullanmak için kullanılır
         Bir web sayfasına yerleştirilmiş başka bir web sayfasıdır
         Iframe genellikle bir Web sayfasına dökuman,video veya interaktif media gibi başka bir kaynaktan içerik eklemek  için kullanılır.

         Sayfada Iframe varsa nasıl bit problem oluşur?
           eğer varsa,Iframe içindeki elemanı driver doğrudan göremez.switchTo methodu ile iframe e geçmenin 3 yolu vardır.

         Iframe 3 farklı şekilde switchTo yapılır: driver.switchTo().frame(...);
            1)ıframe in id si veya name i varsa o kullanılır
            2)index ile kullanabiliriz.birinci ıframe in index i 0 dır.index çok tercih edilmez.
            3)webelement ile kullanılabilir. (driver.findElement(By.xpath....)

         Iframe'den çıkmak için 2 komut vardır:
             1)diver.switchTo().parentFrame(); ==> bir üst seviyrdeki frame'e çıkartır
             2)driver.switchTo.defaultContent(); ==> en üstteki frame'e çıkmak için kullanılır .yani ilk anasayfaya gider

          inceleme yapacağımız yere "//iframe" yazarsaksayfada iframe olup olmadığını görürüz

     */

    @Test
    public void iframeTest(){

        //https://testcenter.techproeducation.com/index.php?page=iframe
       driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String blackBorderTest =  driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(blackBorderTest.contains("black border"));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
          //'Applications lists' elementi iframe'in içinde.iframe switchTo yapmamız şart
        driver.switchTo().frame(0); //index 0'dan başlar.ilk iframe'e switchTo() yapacağımız için 0 dedik
        String icMetin = driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
        String expectedText1= "Applications lists";
        Assert.assertEquals(expectedText1,icMetin);

        //Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
        driver.switchTo().defaultContent(); //iframe den çıkmış olduk
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println("footerText = " + footerText);
        Assert.assertTrue(footerText.contains("Povered By"));

    }
}
