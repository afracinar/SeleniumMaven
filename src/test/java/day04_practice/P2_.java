package day04_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Arrays;

public class P2_ extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //    - https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        String ilkWindow = driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@width='560']")));
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
         driver.get("https://amazon.com/");
        String amazonWindow = driver.getWindowHandle();


        //    - iphone aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String[] aramaSonuc= driver.findElement(By.xpath("//*[text()='1-16 of over 1,000 results for']")).getText().split(" ");
        System.out.println("Arama sonuç sayısı: "+aramaSonuc[3]);

        //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkWindow);
        System.out.println("İlk Window Url :"+driver.getCurrentUrl());

        //    - amazon sayfasını kapatalım
        driver.switchTo().window(amazonWindow);
        driver.close();

        //    - Sonra diğer sekmeyide kapatalım
          //burada test base'deki after methodunu çalıştırır
    }
}
