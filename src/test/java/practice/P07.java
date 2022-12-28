package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //       cookies uyarisini kabul ederek kapatin
       // driver.switchTo().alert();

        //       Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslik = driver.getTitle();
        Assert.assertTrue(baslik.contains("Google"));

        //       Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //       Bulunan sonuc sayisini yazdirin
        String[] sonucSayisi = driver.findElement(By.cssSelector("div[id='result-stats']")).getText().split(" ");
        String sonuc  = sonucSayisi[1];
        System.out.println("Bulunan Sonuç Sayısı : "+ sonucSayisi);

        //       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc = sonuc.replaceAll("\\D",""); //replaceAll ile \\D yi kullanarak bütün noktalama işaretlerini kaldırdık
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);

        //       Sayfayi kapatin
        driver.close();
    }

}
