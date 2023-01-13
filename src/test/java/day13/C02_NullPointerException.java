package day13;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C02_NullPointerException {

    /*
      NullPointerException:
      Değişkenleri oluşturup instantiate etmediğimiz zaman alırız
      Örneğin
      WebDriver driver; deyip new ChromeDriver() demezsek nullpointerException alırız

      Çözüm:
      Değişkeni instanitante etmeliyiz.yani new Keywordu kullanmalıyız
     */

    //NullPointerException
    //Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
    //Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
    //Solution:
    //Degiskeni instantiate et

    WebDriver driver;
    @Test
    public void nullPointerExceptionTest(){

        driver.get("https://www.techproeducation.com");

    }
}
