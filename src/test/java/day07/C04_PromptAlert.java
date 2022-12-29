package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {

    @Test
    public void test() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        Thread.sleep(2000);

        //3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Afra");
        Thread.sleep(2000);

        // OK butonuna tıklayın ve
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // result mesajında isminizin görüntülendiğini doğrulayın.
        String actual = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actual.contains("Afra"));
        Thread.sleep(2000);

    }
}
