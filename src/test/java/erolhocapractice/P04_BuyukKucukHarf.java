package erolhocapractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04_BuyukKucukHarf extends TestBase {

    @Test
    public void test(){

        //google sayfasına gidelim
        driver.get("https://google.com");

        //büyük küçük olacak şekilde HeLlO yazdıralım
        WebElement aramaÇubugu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaÇubugu.sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o");

    }
}
