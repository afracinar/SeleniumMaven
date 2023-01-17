package erolhocapractice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P09_Faker extends TestBase {

    /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */

    @Test
    public void fakerTest(){

        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");

        // Formu doldurunuz
        WebElement ilkKutu = driver.findElement(By.xpath("//*[@id='firstName']"));

        Faker faker = new Faker();
        ilkKutu.sendKeys(faker.name().firstName() +
                Keys.TAB,faker.name().lastName()+
                Keys.TAB,faker.internet().emailAddress() +
                Keys.TAB,Keys.ARROW_RIGHT,
                Keys.TAB,faker.phoneNumber().subscriberNumber(10) ,
                Keys.TAB,"20 Jun 2023",Keys.ENTER,
                Keys.TAB,faker.shakespeare().romeoAndJulietQuote(),Keys.TAB,Keys.SPACE);

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        String anaYol = System.getProperty("user.home");
        String dosyaYolu =anaYol + "/Desktop/logo.jpeg.";
        dosyaSec.sendKeys(dosyaYolu);


        WebElement adress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        adress.sendKeys(faker.address().fullAddress(),Keys.TAB,"NCR",Keys.TAB,Keys.ENTER,"Delhi");

        // Sayfayi kapatin
    }
}
