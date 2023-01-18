package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C04_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest(){

        //"https://the-internet.herokuapp.com/dynamic_loading/1" sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //start butonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! yazısının sitede olduğunu test et

           //1.ADIM: FluentWait için bir obje oluşturulur
           Wait<WebDriver> wait = new FluentWait<>(driver).
                   withTimeout(Duration.ofSeconds(30)). //maksimum bekleme süresi
                   pollingEvery(Duration.ofSeconds(3)). //deneme aralıkları : mesela driver siteye gitti bulana kadar belli aralıklarla tıklar.misafirin eve geldiğinde kapıyı tıklaması örneği
                   withMessage("IGNORE EXCEPTİON"). // opsiyoneldir : mesaj yazdırabiliriz.
                   ignoring(NoSuchMethodException.class); //opsiyoneldir : eğer elemanı bulamaz ise exceptionu handle etti

           //2.ADIM : wait objesini kullanarak bekleme problemini çöz
           WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
           String helloWorldText= helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);

    }


}
