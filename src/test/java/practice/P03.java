package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculate under Micro Apps
        driver.findElement(By.xpath("//*[@id='calculatetest']")).click();

        //    Type any number in the first input
        //    Type any number in the second input
        driver.findElement(By.xpath("//*[@id='number1']")).sendKeys("30", Keys.TAB,Keys.TAB,"40",

        // Click on Calculate
        Keys.TAB,Keys.SPACE);

        // Print the result
        WebElement sonucYazisi = driver.findElement(By.cssSelector("span[id='answer']"));
        System.out.println("sonuc Yazisi = " + sonucYazisi.getText());

        // close driver
        driver.close();
    }




}
