package day15;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReports2 extends TestBase {

    protected static ExtentReports extentReports;  //şablonu oluşturdu
    protected static ExtentHtmlReporter extentHtmlReporter; //şablonu bize gösterir,projeye ekler
    protected static ExtentTest extentTest; //raporlama işlemini yapar.Logları rapora yazdırır

    @BeforeClass
    public static void extentReportsSetUp(){

        //      REPORT  PATH
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

        //Extent Test objesini oluşturduk
        extentTest = extentReports.createTest("Extent Report Login Test","Smoke Test Raporu");

    }

    @Test
    public void extentReportsTest(){
        extentTest.pass("PASS");
        extentTest.info("BİLGİLENDİRME NOTU");
        extentTest.fail("FAILED");
        extentTest.warning("UYARI MESAJI");
        extentTest.skip("ATLAMA MESAJI");
        extentTest.fatal("ÇÖKÜŞ HATASI");
    }

    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush(); //raporun görünmesini sağlar
    }
}
