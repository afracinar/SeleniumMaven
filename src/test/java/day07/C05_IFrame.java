package day07;

import org.junit.Test;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    /*
         iframe bir html tag ıdır
         Sayfa içinde sayfa kullanmak için kullanılır

     */

    @Test
    public void iframeTest(){

       driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

       //Iframe nedir?
        //https://testcenter.techproeducation.com/index.php?page=iframe
        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

    }
}
