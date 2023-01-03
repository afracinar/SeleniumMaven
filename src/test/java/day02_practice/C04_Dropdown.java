package day02_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C04_Dropdown extends TestBase {

    @Test
    public void test01 () {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Dropdown menuyu yazdıralım (select objesini kullanmadan)
        List<WebElement> dropdown= driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        dropdown.forEach(t-> System.out.println(t.getText())); //lambda ile yazdırılması

        //Select objesi kullanarak
        // WebElement dropdown1 =driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        // Select select = new Select(dropdown1);
        // for (WebElement w: select.getOptions()){
        //    System.out.println(w.getText());
       // }


        //Dropdown menuden "baby" seçelim
        //arama bölümünden "milk" aratalım
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,
                "Milk",Keys.ENTER);



    }
}
