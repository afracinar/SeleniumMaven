package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_ExpilicitWait extends TestBase {

    // wait'lerle ilgili reusable method oluşturduk

    @Test
    public void expicitWaitTest(){

        //"https://the-internet.herokuapp.com/dynamic_loading/1" sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //start butonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! yazısının sitede olduğunu test et
   //     WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']//h4"));
    //    Assert.assertEquals(helloWorld.getText(),"Hello World!");

        //IMPLICIT WAIT ILE TEST CASE CALIŞMADI çünkü eleman hemen gözükmedi yavaş bir şekilde görünür hale geldi bu yüzden IMPLICIT WAIT yeterli gelmedi
        //ÇÖZÜM EXPLİCİT WAİT'TE

        //2 ADIMDA EXPLİCİT WAİT OLUŞTURULUR

          //1: WebDriverWait objesi oluşturulur.2 parametre ile çalışır.aynı sınıf içinde bu obje tekrar tekrar kullanılabilir
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

          //2: wait objesini kullanarak bekleme problemini çözmeye çalış
        WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals(helloWorldText,"Hello World!");
    }
}
