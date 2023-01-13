package day04practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P1_WindowHandle extends TestBase {

    /*
      WindowHandle
     */
    @Test
    public void test(){

        //*Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //*Sayfa'nin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();

        //*Sayfa title'nin "Amazon" icerdigini test edin
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));

        //*Yeni bir tab oluşturup, acilan tab'da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB); //burada yeni bir sekme açmış olduk
        driver.get("https://techproeducation.com");

        //*Sayfa title'nin 'TECHPROEDUCATION" icerip içermediğini test edin
        String techproTitle = driver.getTitle();
        String arananKelime ="TECHPROEDUCATION";
        Assert.assertFalse(techproTitle.contains(arananKelime));

        //*Yeni bir window oluşturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //*Sayfa title'nin "Walmart" icerip içermediğini test edin
        String walmartTitle = driver.getTitle();
        String arananKelime1 = "Walmart";
        Assert.assertTrue(walmartTitle.contains(arananKelime1));

        //*ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}
