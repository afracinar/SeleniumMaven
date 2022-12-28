package day01practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions {

    // ...Exercise 2...
    WebDriver driver ;
    @Before  //Before test methodundan önce çalışır
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //her locatorun yüklenmesi için max süre belirledik
        driver.manage().window().maximize();

    }
    @After
    public void teardown() {
      //  driver.close();
    }

    @Test
    public void test() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        // dropdown'dan "Baby" secenegini secin
        WebElement ddm = driver.findElement(By.cssSelector("select[id='searchDropdownBox']")); //1.Adım: locate edilir
        Select select = new Select(ddm);  //2.Adım: Select objesi oluşturulmalı
        select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
        String sectigimOption= select.getFirstSelectedOption().getText();
        System.out.println("Sectiğim option : "+sectigimOption);

        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        List<WebElement> tumOptions = select.getOptions();
        Assert.assertEquals(tumOptions.size(),28);
    }
}
