package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

public class C04_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest(){

        //"https://the-internet.herokuapp.com/dynamic_loading/1" sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //start butonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        //Hello World! yazısının sitede olduğunu test et

           //1.ADIM: FluentWait için bir obje oluşturulur
           Wait<WebDriver> wait = new FluentWait<>(driver);

    }


}
