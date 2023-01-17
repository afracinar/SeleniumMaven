package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {

    /*
    TestBase, testlerden önce ve sonra tekrar tekrar kullandığımız kodları içermektedir.(Before ve After methodları==>destek yani support methodları)
    İçerisindeki methodları kullanabilmek için "extends" yapıyoruz (inheritance).Bu sayede test class'ımızda sadece test case'ler bulunmaktadır
    Utilities package'da TestBase'i oluştururz
        -setUp Method
        -reports (Raporlar)
        -tearDown method
    TestBase class'ı abstract yapabiliriz(abstaract yaparsak child class'lar parenttaki methodları kullanmaya mecbur bırakıırız),
          extends yaparak kullanabiliriz.abstract yapmamızın sebebi bu sınıfın objesini oluşturmak istemiyoruz
                                          TsetBase testBase = new TestBase(); --> YAPILAMAZ
    Oluşturduğumuz driver'in farklı package'lardan kullanabilmek için PROTECTED yaparız
    TestBase kullanabilmemiz için methodları tekrar tekrar yazmamaktır.Framwork'u daha kullanışı hale getirmek için kullanırız

     */

    //driver objesini oluştur.Driver ya public ya da protected olmalıdır.Sebebi child class'lardan çağırılabilir olması için,
                                                                         //başka package'lerde kullanmak için
    protected static WebDriver driver;

    //    setUp
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    //    tearDown
    @After
    public void tearDown() {
        waitFor(5);
     //   driver.quit();
    }

    //    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet") ==>yeni açılan sayfanın title'ı yazılır
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }
        }
        driver.switchTo().window(origin);
    }


    //windowNumber sıfır (0)'dan başlıyor.
    //index numarasını parametre olarak alır ve o indexli pencereye geçiş yapar.mesela 3. pencereye geçiş yapmak istiyorsak 2 yazarız indexi 2 olur
    //bu method ile yeni açılan sayfanın index'i yazılır
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    //yukarıdaki 2 methodun ismi de aynı olabilir çünkü içindeki parametrelerin data type'ı farklı.bu overload methoddur


    /*   HARD WAIT: bu methodu oluşturmamızın sebebi : thread.sleep de exception atmak zorunda kalıyoruz ve daha kafa karıştırıcı 3 sn için 3000 yazıyoruz
      //bir şey tekrar tekrar kullanılıyorsa kısa dahi olsa reusable method oluşturmak gerekir.
     @param : second
 */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }
    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }
    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }
    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }
    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }
    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }
    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source,target).perform();
    }
    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source,x,y).perform();
    }

    //   SCREENSHOTS
    public void takeScreenShotOfPage() throws IOException {
//        1. Take screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }

    //    SCREENSHOT ELEMENT
    public void takeScreenshotOfElement(WebElement element) throws IOException {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));
    }
}
