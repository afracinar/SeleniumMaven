package calısmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
//        3- cookies uyarisini kabul ederek kapatin
//        4Sayfa basliginin "Google" ifadesi icerdigini test edin
        WebElement baslik = driver.findElement(By.xpath("//*[@class='lnXdpd']"));
        if (baslik.isDisplayed()) {
            System.out.println("Passed");
        } else System.out.println("Failed");

//        5Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
//        6Bulunan sonuc sayisini yazdirin
        List<WebElement> sonucSayisi = driver.findElements(By.xpath("//*[@id='result-stats']"));
        for (WebElement w : sonucSayisi) {
            System.out.println(w.getText());
        }
//        7sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        String[] sonuc = sonucSayisi.get(0).getText().split(" ");
        System.out.println(sonuc[1]);
        String sonucReal = sonuc[1].toString();
        String sayi = sonucReal.replaceAll("\\p{Punct}", "");
        System.out.println("sayi =" + sayi);
        int num = Integer.valueOf(sayi);
        if (num > 10000000) {
            System.out.println("Passed");
        } else System.out.println("Failed");


        //8Sayfayi kapatin
        driver.close();

    }
}
