package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {

    /*

    Otomasyon test yaparken seleniu ile otomatik olarak ekran görüntüsü alabiliriz
    Seleniumdan gelen TakeScreenshot apiinden gelen getScreenshotAs methodu kullanılır
    Görüntünün nereye kaydedileceğini,adlandırmasını biz belirleyebiliriz
    Selenium 3 te tüm sayfanın fotoğrafını alıyorduk.selenium 4 te ise sadece istediğimiz elementin görüntüsünü alabilir hale geşdik
    selenium 4 ile sadece belirli bir elementin ekran görüntüsü alınabilir
    ReUsable methoda ekleyeceğimiz methotlar yardımıyla bu işlem kolaylıkla yapılabilir

    Tüm sayfanın görüntüsünü almak için

    1.adım
      Bir TakeScreenshot objesi oluşturup driverimizi TakeScreenshot'a cast yapalım
           TakeScreenshot ts = (TakeScreenshot) driver;

    2.Adım:
       Kaydettiğimiz ekran görüntüsünü projede istediğimiz yere kaydedebilmek için path ile yeni bir File oluşturalım
            File logoResmi = new File("")
    3.adım
      WebElement üzerinden getScreenshotAs() methodunu çağıralım

    4.adım:
     Geçici resmi saklamak istediğimiz dosyaya kopyalayalım
     */


    /* Hocanın Notu:
       Selenium'da tüm ekran görüntüsü nasıl alınır?
          -Tüm ekran görüntüsü Selenium'dan gelen getScreenshotAs() methodu ile alınır.
          -getScreenshotAs methodu selenium'daki TakeScreenshot api'ından gelir

     */

    @Test
    public void fullPageScreenshotTest() throws IOException {

        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

             //1.Ekran görüntüsünü getScreenshotAs methodu ile alıp File olusturalım
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);   //görüntüyü aldık
             //2.Almış olduğumuz ekran görüntüsünü belirlediğim bir path'e kaydettik
          //NOTE:Kayıt ismini dinamik yapmak için date objesi kullandık
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"image.png"; //burada aldığımız ss'i nereye kaydedeceğimi söylüyoruz
        File hedef = new File(path);
             //3.Görüntü ile dosyamı birleştirip kaydet
        FileUtils.copyFile(goruntu,hedef);

           //-“QA” aramasi yap
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("QA", Keys.ENTER);
        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”
        String expected= "Search Results for: QA";
        String text= driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));

        //Reusable method yardımıyla ekran görüntüsünü alalım
        takeScreenShotOfPage();

    }
}
