package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        // EXCEL'DEN DOSYA OKUMA ADIMLARI : WORKBOOK (EXCEL DOYASI) > WORKSHEET (SAYFA) > ROW (SATIR) > CELL (SÜTUN)

        String path = "./src/test/java/resources/Capitals.xlsx"; //yolun önüne "./" konulur
        //        String path =".\\src\\test\\java\\resources\\Capitals.xlsx";//WINDOWS

        //DOSYAYI AÇ
        FileInputStream fileInputStream = new FileInputStream(path); //dosyaya ulaştık

        //EXCEL DOSYASINI AÇ YANİ WORKBOOK AC
        Workbook woorkbook = WorkbookFactory.create(fileInputStream);

        //SHEET(SAYFAYI) AC
        //Sheet sheet = woorkbook.getSheetAt(1); //index kullanarak sayfaya gideriz.index değişebilir bu yüzden çok tercih edilmez
        Sheet sheet1 = woorkbook.getSheet("Sheet1");  //getShreet(String) sayfanın ismini yazarak sayfaya gidebiliriz.Sheet1 isimli sayfayı aç

        //İLK SATIRA GİT /ROW
        Row row1 = sheet1.getRow(0); //satırın ismi yok bu yüzden index ile alıyoruz

        //ILK SATIR 3.SÜTUNU CREATE ET
        Cell cell3= row1.createCell(2); //2.sütunu create ettik

        //NUFUS YAZ
        cell3.setCellValue("NUFUS");

        //2.SATIR 3.SÜTUNA 450000 YAZDIR
        sheet1.getRow(1).createCell(2).setCellValue(450000);

        //3.SATIR 3.SÜTUNA 350000 YAZDIR
        sheet1.getRow(2).createCell(2).setCellValue(350000);

        //KAYDET : KAYIT İŞLEMİ "FileOutputStream" ile yapılır
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        woorkbook.write(fileOutputStream);

    }
}
