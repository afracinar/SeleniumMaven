package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void table1Print(){

        //https://the-internet.herokuapp.com/tables adresine gidin
        driver.get("https://the-internet.herokuapp.com/tables");

        //Table1 i print edin
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("Table1 verileri:");
        System.out.println(table1);

           //2.yol
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }

    }

    @Test
    public void row3Print(){

        //3.Row datalarını print edin
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> row3Element = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        row3Element.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void sonRow(){

        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonRow = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
       sonRow.forEach(t-> System.out.println(t.getText()));

    }
    @Test
    public void test(){

        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(t-> System.out.println(t.getText()));
    }

}
