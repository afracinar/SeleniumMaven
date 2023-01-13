package practice_day05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void name() {

        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");

        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("(//*[@class='_6ltg'])[2]")).click();

        // isim kutusunu locate ediniz
        WebElement isimKutusu = driver.findElement(By.xpath("//*[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();

        String email = faker.internet().emailAddress(); //hesapta iki sefer aynı emaili istediği için aynı emaili String'e koyduk

        Actions actions = new Actions(driver);
        actions.click(isimKutusu).
                sendKeys(faker.name().firstName()). //faker isim
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()). //faker soyisim
                sendKeys(Keys.TAB).
                sendKeys(email).  //faker email
                sendKeys(Keys.TAB).
                sendKeys(email). //faker aynı e mail
                sendKeys(faker.internet().password()). //faker şifre
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("01").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT).  //3 sefer arrowright yapınca "kadın"a gelir
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }
}
