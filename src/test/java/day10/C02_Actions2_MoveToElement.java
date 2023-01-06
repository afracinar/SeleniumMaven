package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2_MoveToElement extends TestBase {

    @Test
    public void hoverOverTest(){

        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sag ust bolumde bulunan “Account & Lists” menüsüne git
          //3 ADIMI UYGULUYORUZ
             //1.Adım : actions objesi oluştur
        Actions actions = new Actions(driver);
             //2.Adım : Elementin locator'ını bul
        WebElement menu =  driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
             //3.Adım : Uygun actions methodunu kullan
        actions.moveToElement(menu).perform(); //moveToElement methodu mouse'u hareket ettirir.

        //“Account” secenegine tikka
        driver.findElement(By.linkText("Account")).click();

        //Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }

}
