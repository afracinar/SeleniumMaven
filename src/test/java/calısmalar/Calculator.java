package calısmalar;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Calculator extends TestBase {

    @Test
    public void calculatorTest(){

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Faker faker = new Faker();
        for (int i = 0; i <2 ; i++) {
            String random = faker.number().digits(1);
            WebElement kutu = driver.findElement(By.xpath("(//*[@class='btn btn-outline-primary'])["+random+"]"));
            kutu.click();
        }

        for (int i = 0; i <1 ; i++) {

            int islem = faker.number().numberBetween(1,4);
            String yeniİslem = String.valueOf(islem);
            WebElement islemHangi = driver.findElement(By.xpath("(//*[@class='operator btn btn-outline-success'])["+yeniİslem+"]"));
            islemHangi.click();
        }

        for (int i = 0; i <2 ; i++) {
            String random = faker.number().digits(1);
            WebElement kutu = driver.findElement(By.xpath("(//*[@class='btn btn-outline-primary'])["+random+"]"));
            kutu.click();
        }

        WebElement esittir = driver.findElement(By.xpath("//*[@class='btn btn-outline-warning']"));
        esittir.click();
        waitFor(5);

        //Sonucu konsola yazdırıp
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='screen']"));
        System.out.println("Sonuç :"+sonuc.getText());

        //Sonucun doğrulamasını yapalım
        Assert.assertTrue(sonuc.isDisplayed());
    }
}
