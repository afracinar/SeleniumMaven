package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    //-"amazon.com" adresine gidelim
    //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
    //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
    //-Ardindan "trendyol.com" adresine gidelim
    //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
    //-Bi onceki web sayfamiza geri donelim
    //-sayfayi yenileyelim
    //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1) -"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com");

        //2) -bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String baslik = driver.getTitle();
        String url = driver.getCurrentUrl();
        System.out.println("baslik = " + baslik);
        System.out.println("url = " + url);

        //3) -title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(baslik.contains("spend") && url.contains("spend"));  //manuel olarak içermediğini gördüğümüz için assertfalse dedik

        //4) -Ardindan "trendyol.com" adresine gidelim
        driver.get("https://trendyol.com");

        //5) -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
       String trenfyolBaslik = driver.getTitle();
       Assert.assertTrue(trenfyolBaslik.contains("Sitesi")); //manuel olarak "Sitesi" kelismesini icerip icermedigini kontrol ettik.içerdiği için assertTrue dedik

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.quit();





    }
}
