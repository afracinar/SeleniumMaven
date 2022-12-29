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

import java.time.Duration;

public class C03_RadioButton {

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
        driver.close();
    }

    @Test
    public void test() {

        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");

        // radiobutton elementlerini locate edin
       WebElement options1 =  driver.findElement(By.xpath("//*[@id='vfb-7-1']"));
       WebElement options2 =  driver.findElement(By.xpath("//*[@id='vfb-7-2']"));
       WebElement options3 =  driver.findElement(By.xpath("//*[@id='vfb-7-3']"));

        // option2'yi secin
        options2.click();

        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(options2.isSelected());

        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(options1.isSelected());

        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(options3.isSelected());

    }

}
