package calısmalar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Practice extends TestBase {

    WebElement dropDown;
    @Test
    public void test1() {

        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
         dropDown = driver.findElement(By.xpath("//*[@name='url']"));
        Select select = new Select(dropDown);
        List<WebElement> tümDropDown = select.getOptions();
        for (WebElement w : tümDropDown) {
            System.out.println(w.getText());

        }


        //dropdown menude 40 eleman olduğunu doğrulayın
    /*    System.out.println(tümDropDown.size());
        int excepted = 40;
        if (tümDropDown.size() == 40) {
            System.out.println("Dropdown'da 40 eleman var");
        } else System.out.println("test is failed");
*/

    }


   @Test
           public void test2(){

       //dropdown menuden elektronik bölümü seçin
       Select select = new Select(dropDown);
       select.selectByVisibleText("Electronics");

       //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
       driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//*[text()='1-16 of 148 results for']"));
        String [] ss = sonuc.getText().split(" ");
       System.out.println("Bulunan sonuç sayısı :"+ ss[2]);

       //sonuc sayisi bildiren yazinin iphone icerdigini test edin
       String sonucYazisi = sonuc.getText();
       Assert.assertTrue(sonucYazisi.contains("iphone"));

       //ikinci ürüne relative locater kullanarak tıklayin
       //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

        }






        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        //dropdown’dan bebek bölümüne secin
        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        //sonuç yazsının puset içerdiğini test edin
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }

