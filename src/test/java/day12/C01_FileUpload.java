package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

       /*    FILE UPLOAD (DOSYA YÜKLEME)
       Dosya yükleme işlemini anlamak için önce manuel olarak test yapılmalı.
       Daha sonra dosya,dosyanın bulunduğu yer (path) kullanılarak yüklenebilir

       Selenium masaüstü application'larını otomate edemez !!! Java ile yapabiliriz

       sendKeys() methodu ile dosyaları upload(yükleme) ederiz
       methodun içine dosyanın yolunu yapıştururuz
        */

    @Test
    public void fileUploadTest(){

        // "https://the-internet.herokuapp.com/upload" adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalım
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));

        //yüklemek istediğiniz dosyayı seçelim
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/logo.jpeg";

        /*
          chooseFile butonuna yüklemek istediğim dosyanın path'ini göndererek dosyayı seçmiş olduk,yükleme yapmadık sadece seçtik
          yüklemeyi upload butonuna tıklayarak yapacağız
         */
        chooseFileButton.sendKeys(dosyaYolu);

        //upload butonuna basalım
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin görüntülendiğini test edelim
        String uplodedYazisi = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        Assert.assertEquals(uplodedYazisi,"File Uploaded!");
    }
}
