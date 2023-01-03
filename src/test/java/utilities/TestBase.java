package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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

}
