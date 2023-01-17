package erolhocapractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P07_Cizim extends TestBase {

    @Test
    public void cizimTest(){

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
        actions.moveToElement(yaziTahtasi).clickAndHold();
        for (int i = 0; i <10 ; i++) {
            actions.moveByOffset(5,5);
        }
            actions.release().build().perform();
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5,-5);

        }
        //    - Çizimden sonra clear butonuna basalım
        driver.findElement(By.xpath("//button[text()='Clear']")).click();


    }
}
