package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
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
    //index numarasını parametre olarak alır ve o indexli pencereye geçiş yapar
    //bu method ile yeni açılan sayfanın index'i yazılır
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    //yukarıdaki 2 methodun ismi de aynı çünkü içindeki parametrelerin data type'ı farklı


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
}
