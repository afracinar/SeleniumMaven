package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /*
      UTILITIES:
      -Tekrar tekrar kullanacağımız class'ları koyduğumuz paketin adıdır
          -TestBase
          -Driver
          -ExcelUtil
          -Configuration
       -Utilities paketinde testcase (@Test) yazılmaz
       -Sadece tekrar kullanılabilecek destek sınıfları(support class) oluşturulur.Bu sapport class'lar testcaselerin yazılmasını hızlandırır

     */

    @Test
    public void test01() {

        //techproeducation ana sayfasına git ve title'in Bootcamps kelimesini içerdiğini test edin
        driver.get("https://www.techproeducation.com");

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Bootcamps"));


    }
}
