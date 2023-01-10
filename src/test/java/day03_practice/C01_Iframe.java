package day03_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    /*
    iframe web sayfası içinde web sayfasıdır
    otomate salak bir yapı olduğu için biz ona web sayfasının içindeki web sayfasına girmesini söylememiz gerekir
     */

    @Test
    public void test(){

        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
           //NOTE: Klavye ve mouse'ın yaptığı işlemleri actions ile yapabiliriz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
           //NOTE:PLay'i doğru locate edip click yapmamıza rağmen videoyu çalıştırmadı.Bunun üzerine html kodlarını inceleyince Play'in aslında iframe
           //içerisinde olduğunu gördük.Bu durumda önce iframe'i locate edip sonra switchTo ile iframe'e geçiş yapmalıyız
        WebElement iframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement playTusu= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        playTusu.click();


        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazisi = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent(); //iframe'den çıktık

        WebElement poweYazisi = driver.findElement(By.xpath("//*[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(poweYazisi.isDisplayed());
    }

}
