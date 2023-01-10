package day03_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

    @Test
    public void test(){

        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        WebElement baslik = driver.findElement(By.xpath("//div/h3"));
        Assert.assertTrue(baslik.isEnabled());
        System.out.println("Başlık :"+ baslik.getText());

        // TextBox'a 'Merhaba Dunya' yazin.
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear(); //var olan yazıyı sildik.silmeseydik olan yazının yanına yazar
        textBox.sendKeys("Merhaba Dunya");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().defaultContent(); //iframe'den çıktık
        WebElement elemantalYazisi = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(elemantalYazisi.isDisplayed());
        System.out.println("Textbox altında bulunan yazi :"+ elemantalYazisi.getText());
    }
}
