package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {


    //Extent reports otomasyon raporları almak için kullanılır
    //Extent report ayrı bir API 'dır.Extent reports selenium dışındada kullanılabilir.
    //Bu API'dan gelen methodlar yardımıyla rapor şablonu oluşturulabilir
    // Extent reports ile alakalı hatırlamamız gereken 3 class: (bunların isimlerini bilmek gerekiyor)
    protected static ExtentReports extentReports;  //şablonu oluşturdu
    protected static ExtentHtmlReporter extentHtmlReporter; //şablonu bize gösterir,projeye ekler
    protected static ExtentTest extentTest; //raporlama işlemini yapar.Logları rapora yazdırır (sout)


    @Test
    public void extentReportsTest(){

        //      REPORT PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";

//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();


        //***********************RAPORU CUSTOMIZE EDEBILIRIZ*************************
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEducation");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takım","Eager");
        extentReports.setSystemInfo("Epic", "Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint No", "Sprint-145");
        extentReports.setSystemInfo("QA","afra");

        //*************************EXTRA RAPOR ISMI VE DOKUMAN ISMI EKLEYEBİLİRİZ*******************
        extentHtmlReporter.config().setDocumentTitle("Techpro Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

        //        ********************************RAPOR AYARLARI BITTI****************************
            //        Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);

        //Extent Test objesini oluşturduk              //1.kısısm zorunlu        //2.kısım zorunlu değil
        extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

        //Tüm ayarlar bitti.Extent Test objesiyle loglama(rapora yazdırma) işlemini yapabiliriz
        driver.get("https://techproeducation.com");
        extentTest.pass("Kullanıcı ana sayfaya gider"); // rapora bilgilendirme mesajı ekledik.burda konsola değil rapora ekleme yapıyoruz


        //lms sayfasına gidelim
        extentTest.pass("Kullanıcı LMS sayfasına gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //test bitti
        extentTest.pass("Test başarıyla gerçekleşti");

        //Raporu göstermek için . driver.close() gibi .raporu gösterir ve kapatır.raporun oluşması için bu adam zorunludur
        extentReports.flush();

    }

}
