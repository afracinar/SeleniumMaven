package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
         @BeforeClass ve @AfterClass notasyonları sadece static methodlar için çalışır
         @Before Class ve @AfterClass kullanırsak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
         en son @AfterClass'ı çalıştırırız.
         Ama sadece @Before ve @After kullanırsak her test için @Before ve @After'ı kullanır

     */

    @BeforeClass
    public static void setUp() {
        System.out.println("Bütün tedstlerden önce çalışır");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Bütün testlerden sonra çalışır");

    }
    @Before
    public void setUp01() {
        System.out.println("Her testten önce çalışır");
    }

    @After
    public void tearDown02() {
        System.out.println("Her testten sonra çalışır");
    }


    @Test
    public void test1() {
        System.out.println("ilk test");
    }

    @Test
    public void test2() {
        System.out.println("ikinci test");

    }

    @Test
    @Ignore
    public void test3() {
        System.out.println("Üçüncü test");

    }
}