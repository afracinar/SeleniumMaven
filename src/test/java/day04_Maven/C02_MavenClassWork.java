package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();

        //3.Login alanine “username” yazdirin
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("username");

        //4.Password alanine “password” yazdirin
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.navigate().back();

        //6. Online Banking butonuna basınız sonra Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        Thread.sleep(2000);
        WebElement amount = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("500");

        //8.tarih kismina “2020-09-10” yazdirin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("input[class='btn btn-primary']")).click();

        //10.“The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if (mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        //11.sayfayı kapatın
        driver.close();
    }
}
