package day04practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P3_ extends TestBase {

    @Test
    public void test(){

        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear(); //içindeki metni temizledik
        textBox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());

        // Elemental Selenium linkine tıklayın
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        // Açılan sayfada sayfa başlığını yazdırınız
        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        // Source labs linkine tıklayın
        // Açılan sayfada sayfa başlığını yazdırınız
        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        // ilk sekmeyi kapatalım

    }
}
