package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {

    //assertTrue(True)--->Passed
    //assertTrue(False)--->Failed
    //
    //assertFalse(False)--->Passed
    //assertFalse(True)--->Failed

    //SORU:
    //https://www.amazon.com adresine gidin  --befor içinde oluşturduk
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //=> Sayfa başlığının “Amazon” oldugunu test edin
    //=> Amazon resminin görüntülendiğini (isDisplayed()) test edin
    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //wrongTitleTest  => Sayfa basliginin “amazon” olmadigini dogrulayin
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    @Test
    public void test1() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitle.contains(expectedTitle));  //if-else yerine assert kullandık
    }

    @Test
    public void test2() {
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }
    @Test
    public void test3() {
        WebElement sayfaResmi = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        Assert.assertTrue(sayfaResmi.isEnabled());
    }

    @Test
    public void test4() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }

}
