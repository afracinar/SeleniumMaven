package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
    time out = zaman aşımı
    TimeOutException süreyle alakalı ve expilicit wait sorunudur.
    expilicit wait kullanıldığında ve element bulunamadığında alınabilecek bir exceptiondur
    implicit wait kullanıldığı zaman ve eleman bulunamadığı zaman timeıutexception alınamaz.nosuchelementexception alınır

    Explicit wait ve yanlış locator = TimeOutException alınır
    Explicit wait var,locator doğru ama süre yeterli değil = TimeOutException
    Explicit wait var,locator doğru,süre yeterli ama iframe var = TimeOutException

    implicit wait te timeoutexception alınmaz

    Çözüm:
      locator kontrol edilir
      süreyi arttırırız
      farklı explicit wait çeşitleri kullanılabilir.mesela sayfa geçişlerini beklemek için javascript executor daki waiter kullanabiliriz
     */

        /*
TimeOutException explicit wait kullandimda ve locator bulunamadiginda alirim
 */
        @Test
        public void timeOutExceptionTest(){
            driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
//        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA"+ Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:
        }
    }

