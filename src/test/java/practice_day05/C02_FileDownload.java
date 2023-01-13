package practice_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    //selenium websayfasına otomate edebilir.bilgisayarı otomate edemez.indirilen dosyaları selenium test edemez,testi java ile yapabiliriz

    @Test
    public void test() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
            //          "C:\Users\CINAR\Downloads\some-file.txt"  dosya yolu

            // String dosyaYolu = "C:\\Users\\CINAR\\Downloads\\some-file.txt";   ==> bu kısım dinamik değil o yüzden aşağıda parçalayark yaptık
        String farklıKisim = System.getProperty("user.home"); //her pc de bu kısım farklıdır
        String ortakKisim = "\\Downloads\\some-file.txt";
        String dosyaYolu2 =farklıKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }
}
