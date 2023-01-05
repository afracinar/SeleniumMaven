package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {


    @Test
    public void handleWindowTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // Ilk sayfanin ID'SINI ALALIM
        String window1Handle = driver.getWindowHandle();

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String window1Text = driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText, window1Text);

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);
        //Click Here butonuna basın.
        driver.findElement(By.xpath("(//*[@target='_blank'])[1]")).click();
        Thread.sleep(3000);
        // BU NOKTADA 2 PENCERE ACIK VE IKINCISINE GECIS YAPMAK ISTIYORUM
        // BUNUN ICIN driver.getWindowHandles() ILE TUM PENCERELERIN ID'LERINI ALALIM
        Set<String> allWindowHandles = driver.getWindowHandles();// {window1Handle, window2Handle}
        System.out.println(allWindowHandles);
        for (String eachHandle : allWindowHandles) {
            // EGER LISTEDEKI ID WINDOW1'E ESIT DEGILSE OTOMATIK OLARAK WINDOW2'YE(BIR SONRAKINE) ESITTIR.
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);//Burdaki eachHandle window2 handle'ina esittir.
                break;
            }
        }
        // BU NOKTADA DRIVER 2. PENCEREDE
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());
        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3")).getText());
        String window2Handle = driver.getWindowHandle();
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2500);
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet", driver.getTitle());
        Thread.sleep(2500);
        // 2. windowa tekrar gecelim
        driver.switchTo().window(window2Handle);
        Thread.sleep(2500);
        // 1. windowa tekrar gecelim
        driver.switchTo().window(window1Handle);
    }
}
