package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {

    @Test
    public void testWindowHandles(){

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle=driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        WebElement aramaMotoru = driver.findElement(By.xpath("//*[@id='searchData']"));
        aramaMotoru.clear();
        aramaMotoru.sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='lazy cardImage'])[1]")).click();

        String sayfa2Handle="";
        Set<String> handels = driver.getWindowHandles();
        for (String w : handels) {
            if (!w.equals(sayfa1Handle)){
                sayfa2Handle = w;
            }
        }

        driver.switchTo().window(sayfa2Handle);

        // Basligin 'Oppo' icerdigini test edin.
        String baslikOppo = driver.findElement(By.xpath("//h1[@class='proName']")).getText();
        Assert.assertTrue(baslikOppo.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println("İlk sayfa title :"+ driver.getTitle());


    }
}
