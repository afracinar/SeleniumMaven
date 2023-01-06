package day09;


import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    /* COOKİES : ÇEREZLER ==>sitelerde olan dosyaların bizim alışkanlıklarımızı kolaylaştırmak için kullanılır.Güvenlik zaafı değildir
     Browser'larda geçici oluşan  bilgi dosyalarıdır.
     Cookies bilgisayarımızda geçici olarak depolanır.
     Cookies,kişisel bilgiler de dahil olmak üzere birçok bilgi içerebilir
     Web siteleri,ancak sizin izin verdiğiniz bilgilere erişebilir ( şifre kaydedilsin mi vs..)
     Bu web sayfaları sizin izin vermediğiniz bilgilere erişemez ya da bilgisayarınızdaki diğer doyaları görüntüleyemez
     Yapacağımız otomate ile cookie'ler geçici olarak handle edilir

     Cookies automate edebiliriz

     driver.manager(). methodu ile cookie'leri
                       -listeleyebilir -->getCookies
                       -isim ile çağırabilir -->getCookieNamed
                       -yeni cookie ekleyebiliriz -->addCookie
                       -var olan isimleri silebilir -->deleteCookieNamed
                       -var olan tüm cookie'leri silebiliriz -->deleteAllCookies
     */

    @Test
    public void handleCookiesTest(){

        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);

        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Sayfada:"+ allCookies.size()+" adet cookie var");

        //2.tüm cookie'leri yazdıralım
           //lambda ile : allCookies.stream().forEach(t-> System.out.println(t.getName()));


        for (Cookie w :allCookies){
            System.out.println("COOKİE"+w); //cookie'nin tüm bilgilerini yazdırır
            System.out.println("COOKİE İSİMLERİ: "+w.getName()); //cookie'nin ismini yazdırır
        }

        //3. Bir Cookie yi smiyle bul
        System.out.println("COOKİEYİ İSMİYLE ÇAĞIRIYORUZ: "+driver.manage().getCookieNamed("i18n-prefs=USD"));


        //4. Yeni bir cookie ekle           //               value'si
        Cookie favoriCookiem = new Cookie("cikolatam","antep-fistikli-Cikolata"); //Cookie objesi oluştuduk
        driver.manage().addCookie(favoriCookiem);
        System.out.println(driver.manage().getCookies().size()); //eklenip eklenmediğini görmek için tekrar yazdırdık

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-token");
        waitFor(2);

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(4);
        System.out.println("Tüm cookieleri sildim.yeni cookie sayısı :"+driver.manage().getCookies().size());
    }

}
