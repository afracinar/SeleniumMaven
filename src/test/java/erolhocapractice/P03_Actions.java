package erolhocapractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {

    /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
    Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */

    @Test

    public void test(){

    //http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

   // Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        WebElement box = driver.findElement(By.id("div2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(box).perform();
        waitFor(3);

  //  Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
       WebElement buton =  driver.findElement(By.xpath("//*[@name='dblClick']"));
       actions.doubleClick(buton).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(),"Double Clicked !!");

   // Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

   // Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
      WebElement drag =  driver.findElement(By.xpath("//*[@id='draggable']"));
      WebElement drop =  driver.findElement(By.xpath("//*[@id='droppable']"));
      actions.dragAndDrop(drag,drop).release().perform();

      Assert.assertEquals(drop.getText(),"Dropped!");


    }
}
