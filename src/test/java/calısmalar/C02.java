package calısmalar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. "https://www.saucedemo.com/" Adresine gidin

        driver.get("https://www.saucedemo.com/%22");
                //2. Username kutusuna "standard_user" yazdirin
//        Thread.sleep(3000);
                WebElement username = driver.findElement(By.xpath("//[@id='user-name']"));
        username.sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
//        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//[@id='password']"));
        password.sendKeys("secret_sauce");
        //4. Login tusuna basin
//        Thread.sleep(3000);
        WebElement loginPress = driver.findElement(By.xpath("//[@id='login-button']"));
        loginPress.click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstsave =driver.findElement(By.xpath("//[text()='Sauce Labs Backpack']"));
        System.out.println(firstsave.getText());
        firstsave.click();
        //6. Add to Cart butonuna basin

        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        addToCart.click();

        //7. Alisveris sepetine tiklayin
        WebElement sepeteclick =driver.findElement(By.className("shopping_cart_link"));
        sepeteclick.click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement control = driver.findElement(By.cssSelector("div[class='cart_item']"));
        if (control.isDisplayed()){
            System.out.println("Test is passes + there is item in basket");
        }else System.out.println("Test is failed + there is no item in basket");

    }
}

