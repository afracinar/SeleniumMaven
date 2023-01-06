package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    // Selenium 4 ile geldi.Yeni TAB veya WİNDOW oluşturabiliyoruz.
    @Test
    public void newWindowHandleTest(){

        //1.TechPro Education sayfasının title'ının "TechPro Education" metnini içerdiğini test edin
        driver.get("https://www.techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

        //2. Yeni bir pencerede amazon sayfasını açın ve title'ın "Amazon" metnini içerdiğini test edin
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni window oluşturur ve switch yapar yani oaray geçiş yapar
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        //3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW); //yeni window oluşturur ve switch yapar yani oaray geçiş yapar
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        //Driver nerede ? LinkedIn'de
        //Techpro sayfasına gitmek içinekrar driver.switchTo().window(techProHandle);
        driver.switchTo().window(techProHandle);
        waitFor(3);
        //Driver şuan nerde? TechPro da
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);


    }
}
