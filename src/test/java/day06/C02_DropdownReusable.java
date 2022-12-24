package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {

    //  REUSABLE METHOD: Dropdown için tekrar tekrr kullanabileceğimiz bir method oluşturalım

    WebDriver driver ;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    public void selectFromDropdown(WebElement dropdown,String secenek){
      // selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"2005"); -->yıldan 2005 i seçenecek
        // selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")),"January"); -->aydan january'i seçecek
        // selectFromDropdown(driver.findElement(By.xpath("//select[@id='day']")),"12");

        //Gönderilen dropdown elementinin tüm options'ları alınır
      List<WebElement> options =  dropdown.findElements(By.tagName("option")); //tüm option tag'li elementleri alıyor
        for (WebElement eachOption : options){
            if (eachOption.getText().equals(secenek)){
                eachOption.click();
                break;
            }
        }

    }

    }
