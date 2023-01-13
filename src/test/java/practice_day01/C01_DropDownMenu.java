package practice_day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDownMenu {

    // ...Exercise 1...
    WebDriver driver ;

    @Before  //Before test methodundan önce çalışır
    public void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //her locatorun yüklenmesi için max süre belirledik
    driver.manage().window().maximize();

    }

    @After    //yazacağımız test methodundan sobra çalışacak
    public void teardown() {
        driver.close();
    }


    @Test
    public void test1() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Books" secenegini secin
           //dropdown 3 adımda handle edilir
        WebElement ddm = driver.findElement(By.cssSelector("select[id='searchDropdownBox']")); //1.Adım: locate edilir
        Select select = new Select(ddm);  //2.Adım: Select objesi oluşturulmalı
        select.selectByVisibleText("Books");  //3.Adım: Opsiyon seçilir
       // select.selectByIndex(5); //books opsiyonu 5. indexte olduğundan bu şekilde yapılır

        // arama cubuguna "Java" aratın
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        //NOTE: Locate alınırken ilk olarak id'den almamız lazım
        //id class className tagName linkText partialLinkText xpath cssSelector

        // arama sonuclarinin Java icerdigini test edin
        WebElement javaIcermeTest = driver.findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']"));
        boolean test = javaIcermeTest.getText().contains("Java");
        Assert.assertTrue(test);


    }

}
