package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {

    @Test
    public void elementScreenshotTest() throws IOException {

        //Techpro education a git
        driver.get("https://www.techproeducation.com");

        //Sosyal medya elemanlarını goruntusunu al
            //1)ekran görntüsünü aldık
        WebElement sosyalMedya = driver.findElement(By.xpath("//*[@data-id='d7545f2']"));
        File image = sosyalMedya.getScreenshotAs(OutputType.FILE); //ekran görüntüsünü aldık
            //2)ekran görüntüsünü kaydet
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        WebElement logo = driver.findElement(By.xpath("//*[@id='NDU1Ojc5MQ==-1']"));
        takeScreenshotOfElement(logo);
    }
}
