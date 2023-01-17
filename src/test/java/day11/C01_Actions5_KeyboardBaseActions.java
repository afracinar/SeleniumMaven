package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5_KeyboardBaseActions extends TestBase {

    /*
       KEYBOARD BASE ACTİONS :KLAVYE AKSİYONLARI
        Actions class'ından kullanacağımız methodları ile klavye tuşları kontrol edilir

        3 method kullanabilrizi:

        sendKeys() => Ögeye bir dizi anahtar gönderir
        keyDown() => Klavyede tuşa basma işlemi gerçekleştirir
        keyUp() => Klavyede tuşu serbest bırakma işlemi gerçekleştirir

        NOT: KeyDown() methodundan sonra o işlemi iptal etmek için KeyUp() methodu kullanılır.Yani bir KeyDown kullanırsak
        o tuşa basılı olarak işlem yapar,KeyUp kullanmadığımız sürece de tuşa basılı kalmaya devam eder
     */

    //Create a method keyboardActions
    @Test
    public void keyboardActions(){

        //Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        //‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
                                       //(SHIFT tuşuna basılı tutarak yazınca büyük harfle yazıyor)
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.
                keyDown(aramaKutusu, Keys.SHIFT). //arama kutusunun üstünde shift tusuna bas
                sendKeys("iPhone X fiyatlari"). //shifte basılıyken yazı yaz
                keyUp(aramaKutusu,Keys.SHIFT). //shift'e artık basma
                build(). //birden fazla actions methodu kullanıldığında build methodu tercihen kullanılabilir
                perform();

        //‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK) Ve ENTER tusuna bas
        aramaKutusu.sendKeys(" cok pahali!"+Keys.ENTER); //burada actions class'a ihtiyacımız yok


    }

}
