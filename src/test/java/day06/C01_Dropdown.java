package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    /*
        Developer dropdown oluştururken hangi html tag'ını kullanır?-select
        dropdown oluşturmak için select tag ı kullanılır.
        dropdown otomate edilirken select tag'ı kullanılır
    html de multipe varsa birden fazla seçenek seçilmesini sağlar
    dropdowndan element seçmek için 3 adım vardır
    1:) locate etmek gerekiyor
        WebElement ddm = driver.findElement()
    2:)yeni bir selecy objesi oluşturulur ve daha önce locate ettiğimiz webelement'i parametre olarak yeni objeye ekleyin
      Select options =  new Select(ddm)
      Select seleniumdan gelen bir classtır
    3:)Select class'ından kullanabaileceiğmiz
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void selectByIndexTest() {
        //Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken

        //1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));

        // Dogum yilini ayini ve gununu su sekilde secer 2000, January, 10
        //2. SELECT OBJESİ OLUŞTUR
        Select yearDropdown = new Select(year);
        //3. Select objesini kullanarak 3 farklı şekilde seçim yapılabilir :byindex,byvalue,byvisibleText
        yearDropdown.selectByIndex(22); //SEÇENEK SIRASI : 0 yazılırsa ilk seçeneği seçer,array gibi.2000 yılı 23.sırada 22 yazarız

        //Ay seçimi byValue ile
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDropdown = new Select(month);
        monthDropdown.selectByValue("0");  //selectByValue'da "attribute'ı value" olanın değerini alırız.January seçeneğinin value'si 0 olduğu için 0 dedik

        //Gün seçimi  visibleText ile  (visitibleText en çok kullanılanlardandır)
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByVisibleText("10");
    }

    @Test
    public void printAllTest() {


        //Tüm eyalet isimlerini konsola yazdıralım
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> tümEyaletler = stateDropdown.getOptions(); //getOptions() List<WebElement> döndürür
        for (WebElement w : tümEyaletler) {  //her elemenanın data type'ı WebElemnet'tir
            System.out.println(w.getText());
        }
        //lambda ile ==> tümEyaletler.stream().forEach(t-> System.out.println(t.getText()));
    }
        @Test
        public void getSelectedOptionsTest(){
        //State dropdownındaki varsayılan seçili seçeneğin "Select a State" olduğunu verify edelim
            WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
            Select stateDropdown = new Select(state);
            String varsayılanText = stateDropdown.getFirstSelectedOption().getText();

            Assert.assertEquals("Select a State",varsayılanText);


        }



        /*
            1. What is dropdown? Dropdown nedir?
               Dropdown liste oluşturmak için kullanılır
            2. How to handle dropdown elements? Dropdown nasıl otomate edilir?
               3 aşamada otomate edilir.İlk önce dropdown'ı locate ederiz.İkinci olarak Select objesi oluştururz.son alarak select objesi ile istediğimiz
               seçeneği seçeriz
              NOTE: Select objesi oluşturma nedenim dropdown'ların select class'ı ile oluşturulmasıdır

            3. Tüm dropdown seçeneklerini nasıl print ederiz(konsolda yazdırırz)?
                tüm dropdown elementlerini getOptions() methodu ile listeye koyarız sonra seçenekleri loop ile yazdırabiliriz
            4. Bir seçeneğin seçili olduğunu otomate etmek için ne yapılır?
               Ornek: Gun oalrak 10' u seçtik ama ya seçilmediyse?
               getFirstSelectedOption() seçili olan seçeneği return eder.
               isDisplayed elementin varlığına bakar

         */


    }




