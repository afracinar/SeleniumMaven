package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {
    /*
    birden fazla pencerenin açılacağı durumlarda ilk aşamada windowhandle yapmak gerekir
     */

    @Test
    public void windowHandleTest() throws InterruptedException {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

           //NOTE: birden fazla pencerenin açılacağı durumlarda ilk aşamada windowhandle yapmak gerekir
           String window1Handle =driver.getWindowHandle();  //birinci pencerenin id'sini almış oluyoruz

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expectedWindow1Text="Opening a new window";
        Assert.assertEquals(actualWindow1Text,expectedWindow1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitleWindow1 = driver.getTitle();
        String exceptedWindow1Title = "The Internet";
        Assert.assertEquals(actualTitleWindow1,exceptedWindow1Title);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
       waitFor(3);
            //bu aşamadan sonra 2.pencere açılır ve 2.pencerede işlem yapmak istediğimden o pencereye switchTo (geçiş) yapmalıyız


          //bizim yazdığımız java koduna göre ilk açılan pencerenin index'i 0,ikinci pencerenin index'i 1'dir
        switchToWindow(1); //2.window'a geçiş yaptık.driver artık 2. window'da

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualWindow2Title = driver.getTitle();
        String exceptedWindow2Ttitle="New Window";
        Assert.assertEquals(actualWindow2Title,exceptedWindow2Ttitle);





    }
}
