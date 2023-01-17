package erolhocapractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P08_RenkDegistirme extends TestBase {

    //slayder'lar için genelde dragAndDropBy methodu kullanılır

    @Test
    public void renkTest(){

        //     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
            //sayfada iframe olduğu için oraya geçtik
        WebElement iframe = driver.findElement(By.xpath("//*[@src='/resources/demos/slider/colorpicker.html']"));
        driver.switchTo().frame(iframe);

        //     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement slayder2 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));

        Actions actions = new Actions(driver);
        WebElement slayder3 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));

        actions.dragAndDropBy(slayder2,-170,0); //x kordinatında olduğu için y 0 olur
        actions.dragAndDropBy(slayder3,-80,0); //x kordinatında olduğu için y 0 olur
        actions.dragAndDropBy(slayder2,300,0).release().build().perform(); //x kordinatında olduğu için y 0 olur



        //     -Sarı olduğunu test edelim
        //-Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 254, 0);']"));
        assert sari.isDisplayed();

    }
}
