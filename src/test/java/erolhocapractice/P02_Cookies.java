package erolhocapractice;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookies extends TestBase {

    /*                                Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    @Test
    public void test(){

        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");

        //Sayfadaki cookie lerin sayısını yazdırınız
       Set<Cookie> cookies=  driver.manage().getCookies();
        System.out.println("Toplam cookie sayısı :"+cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie w : cookies){
            System.out.println("cookie değeri :"+w);
            System.out.println("cookie ismi :"+ w.getName());
        }

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("pasta","cilekli-muzlu");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("Toplam YENİ cookie sayısı :"+cookies2.size());
        for (Cookie ww : cookies2){
            System.out.println(ww.getName() + ":" + ww.getValue());
        }

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri silelim
        Set<Cookie> cookies3 = driver.manage().getCookies(); //güncelleme yaptık
        driver.manage().deleteAllCookies();

    }
}
