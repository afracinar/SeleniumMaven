package day02_practice;

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

public class C01_DropDown {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //implicitlyWait selenium'dan gelir,
       // Thread.sleep ise javadan gelir.imp.max bekleme süresidir.thread.sleep ise ne olusa olsun bbelirleyeceiğimiz süre kadar o kodda bekler
        driver.manage().window().maximize();

    }
    @After
    public void teardown() {
     //   driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement options = driver.findElement(By.cssSelector("select[id='dropdown']"));
        Select select = new Select(options);
        select.selectByIndex(1);
        String sectigimOptionIndex = select.getFirstSelectedOption().getText();
        System.out.println("Sectiğim option ındex ="+sectigimOptionIndex);

        Thread.sleep(3000);
        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        select.selectByValue("2");
        String sectigimizOptionValue = select.getFirstSelectedOption().getText();
        System.out.println("Sectiğimiz option value ="+sectigimizOptionValue);

        Thread.sleep(3000);
        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        select.selectByVisibleText("Option 1");
        String sectigimOptionByVisibleText= select.getFirstSelectedOption().getText();
        System.out.println("Sectigim option by visible text ="+sectigimOptionByVisibleText);

        // Tüm option'ları yazdırın
        List<WebElement> tümOptions = select.getOptions();
        int sayac = 1;
        for (WebElement w : tümOptions){
            System.out.println(sayac+". option = " + w.getText());
        }

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int tümOptionSayisi = tümOptions.size();
        Assert.assertEquals(3,tümOptionSayisi);

    }

}
