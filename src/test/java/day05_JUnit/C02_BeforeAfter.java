package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
Before : her test methodundan önce bir sefer çalışır
After : her test methodundan sonra bir sefer çalışır
before after lar her testte çalışır
 */
public class C02_BeforeAfter {

    @Before
    public void setUp() {
        System.out.println("Her Test Methodundan önce çalışır");
    }

    @After
    public void tearDown() {
        System.out.println("Her Test Methodundan sonra çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk test");

    }

    @Test
    public void test02(){
        System.out.println("İkinci test");
    }
}