package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {

    /*
    Authentication herhangi bir internet kullanıcısının uygulamanın ya da programın söz konusu sisteme dahil olup olamayacağını belirleyen doğrulama
    sistemini ifade eder.
    Uygulama anasayfasındaki kullanıcı adı ve password istemek de bir Authentication'dur
    Authentication allert'e çok benzer ama allertdeğildir
    allert'te inceleme yapılamazdı

    //Authentication URL : https://username:password@URL
     */

    @Test
    public void basicAuthenticationTest(){

        //1.)https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        //2.)asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //URL              : https://username:password@URL
                                   //admin   :  admin@https:/
        //Username    : admin
        //password    : admin

        //AUTHENTICATION URL'miz : https://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        waitFor(3);

        //Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini doğrulayın
        String actualText = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(actualText.contains("Congratulations!"));
    }

}
