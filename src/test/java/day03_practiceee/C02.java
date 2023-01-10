package day03_practiceee;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02 extends TestBase {

    @Test
    public void test(){

        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);  //iframe ' e geçiş yaptık
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();

        // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id='nature']//img"));
        emojiler.stream().forEach(t->t.click());  //lambda ile tüm webelementlere tıkladık

     /* for each ile yapımı
          for (WebElement w: emojiler) {
                w.click();
           }
      */

        // parent iframe e geri donun
        driver.switchTo().defaultContent();
          // driver.navigate().refresh();  ==> rrefresh yaparak sayfayı yenileriz ve en başa döndürürüz yani iframe'den çıkmış oluruz

        // formu doldurun,(Formu istediğiniz metinlerle doldurun)
          //driver.findElement(By.xpath("//*[@id='text']")).sendKeys("afra");
        List<WebElement> list = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> veriler = new ArrayList<>(Arrays.asList(
                "afra","çınar","selenium","lambda","java","sql","gitgithub","fsd","fggs","hfhgj","gfgdfgf","hgfhg","werwr"));

        for (int i = 0; i < list.size(); i++) {
            list.get(i).sendKeys(veriler.get(i));
        }

        //  apply button a basin
        driver.findElement(By.xpath("//*[@id='send']")).click();
    }
}
