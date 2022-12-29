package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void dismissAlertTest() throws InterruptedException {


        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(2000);

        //2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        // uyarıdaki Cancel butonuna tıklayın v
        driver.switchTo().alert().dismiss(); //cancel a tıklayacağımız için dissmiss e tıkladık

        //ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String resultMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText(); //gerçek değer
        String expectedResult = "You clicked: Cancel"; //beklenen değer
        Assert.assertEquals(resultMesaj,expectedResult);
    }

}
