package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExists {

    /*
    Selenium ile windows uygulamalarını test edemiyoruz.Selenium masaüstünde olan şeyleri test edemez,selenium website ile alakalıgapılır
    Ama test için JAVA kullanabiliriz
    PC de bir dosya olup olmadığını(exist) kontrol etmek için Java'yı kullanabiliriz

    -System.getProperty("user.dir"); ==> içinde bulunulan klasörün yolunu(path) verir
    -System.getProperty("user.home"); ==> bilgisayarımızda bulunulan user klasörünü verir
    -Files.exists(Paths.get(filePath)); ==> Bilgisyarınızda dosyanın olup olmadığını kontrol eder
     */

    @Test
    public void isExistsTest(){

        //Masaüstünde bir doyanın olup olmadığını test edin

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);

        String userHome = System.getProperty("user.home");
        System.out.println(userHome);

        //logo.jpeg indirip masaüstüne indirin
           //Logo masaüstünde: C:\Users\CINAR

        String dosyaYolu = userHome + "/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExists = Files.exists(Paths.get(dosyaYolu)); //dosya var ise true yok ise false verir
        Assert.assertTrue(isExists);
    }
}
