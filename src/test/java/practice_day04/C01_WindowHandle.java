package practice_day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_WindowHandle extends TestBase {

    @Test
    public void test(){

        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);
        String window1 = driver.getWindowHandle();

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB); //yeni tab açtık
        driver.get("https://www.amazon.com"); //yeni a.ılan tab'da amazona gittik
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER); //nutellayı arattık


        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click(); //ilk çıkan resme click yaptık

        // 4- yeni tab'da acilan urunun basligini yazdirin
        String urunBasligi = driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
        System.out.println("Yeni tabdaki ürün başlığı :"+ urunBasligi);

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(window1);
        String window1URL = driver.getCurrentUrl();
        System.out.println("İlk sayfa url :"+window1URL);
    }
}
