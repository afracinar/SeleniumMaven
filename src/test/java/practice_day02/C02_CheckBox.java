package practice_day02;

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

public class C02_CheckBox {

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

        // checkbox elementlerini locate edin
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id='vfb-6-0']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id='vfb-6-1']"));
        WebElement checkBox3 = driver.findElement(By.xpath("//*[@id='vfb-6-2']"));

        // checkbox1 ve checkbox3  secili degil ise secin
        if(!checkBox1.isSelected() && !checkBox3.isSelected()){
            checkBox1.click();
            checkBox3.click();
        }

        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());

        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checkBox2.isSelected());
    }
}
