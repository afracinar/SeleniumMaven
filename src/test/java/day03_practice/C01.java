package day03_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("https://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
           //driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();  ==> burası ilk etapta seçili geldiği için tekrarlocate almaya gerek yok
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText()); //alert üzerindeki yazıyı konsola yazdırdık
        driver.switchTo().alert().accept(); //allert tamam'a bastık

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        Thread.sleep(2000);

        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        Thread.sleep(2000);
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

        Thread.sleep(2000);
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("Afra");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello Afra How are you today"
        String consol= driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println(consol);

        //    aseertion these message
        Assert.assertEquals("Hello Afra How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());
    }
}
