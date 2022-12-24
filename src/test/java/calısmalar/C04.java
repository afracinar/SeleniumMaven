package calısmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void teardown() {
        //  driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        //    Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");

        //    Then new butonuna basar
        driver.findElement(By.xpath("//*[text()='New']")).click();

        //    And editor firstname kutusuna "<firstName>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_first_name']")).sendKeys("afirstName");

        //    And editor lastname kutusuna "<lastName>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_last_name']")).sendKeys("lastName");

        //    And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_position']")).sendKeys("position");

        //    And editor office kutusuna "<office>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_office']")).sendKeys("office");

        //    And editor extension kutusuna "<extension>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_extn']")).sendKeys("extn");

        //    And editor startdate kutusuna "<startDate>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_start_date']")).sendKeys("2022-12-24");
        //    And editor salary kutusuna "<salary>" bilgileri girer
        driver.findElement(By.cssSelector("input[id='DTE_Field_salary']")).sendKeys("1627");
        //    When Create tusuna basar
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[class='btn']")).click();
        //    Then Kullanıcının eklendiğini doğrular.
        WebElement dogrulama = driver.findElement(By.id("row_58"));
        Assert.assertTrue(dogrulama.isDisplayed());

        //    And Eklediği kullanıcı kaydını siler
        WebElement satir = driver.findElement(By.cssSelector("tr[id='row_58']"));
        satir.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        driver.findElement(By.cssSelector("button[class='btn']")).click();

        //    Then Kullanıcinin silindiğini doğrular.

        List<WebElement> isimler = driver.findElements(By.cssSelector("th[class='sorting sorting_desc']"));
       for (WebElement w : isimler){
           Assert.assertFalse(w.equals("afirstname"));
       }

        //    */

    }


}

