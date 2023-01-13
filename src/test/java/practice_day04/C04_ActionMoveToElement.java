package practice_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C04_ActionMoveToElement extends TestBase {

    @Test
    public void test(){

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String sayfa1Handle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
        WebElement dilSecenek = driver.findElement(By.xpath("(//*[@class='nav-line-2'])[1]"));
        actions.moveToElement(dilSecenek).perform();

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[text()='Change country/region.'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Turkey (Türkiye)");

          //dropdown opsiyon listesi "go to website" elementine basmamıza engel olduğu için herhangi bir yere click yapıp drop down opsiyon listesini kapattık
        driver.findElement(By.xpath("(//*[@class='a-text-bold'])[3]")).click();


        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//*[@id='icp-save-button']")).click();

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        Set<String > windowHandleSeti = driver.getWindowHandles();
        System.out.println("Sayfa 1 Handle değeri :" + sayfa1Handle);
        System.out.println(windowHandleSeti); //tüm sayfaların handle değerleri


        String sayfa2Handle = "";
        for (String w : windowHandleSeti) {
            if(!w.equals(sayfa1Handle)){
                sayfa2Handle=w; //sayfa 2 nin handle değerini bulduk
            }

        }

        driver.switchTo().window(sayfa2Handle);

        String sayfa2Title = driver.getTitle();
        System.out.println(sayfa2Title);
        Assert.assertTrue(sayfa2Title.contains("Elektronik"));
    }
}
