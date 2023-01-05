package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
       // driver.quit();
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
}
