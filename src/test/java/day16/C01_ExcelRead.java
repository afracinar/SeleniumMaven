package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C01_ExcelRead {

    /*
        Excel WebTable yapısına benzer bir yapıdadır
        Excel'de bir hücredeki bilgiye ulaşmak için adım adım gitmeliyiz: dosya/sayfa/satır/sütun
        Excel selenium'un bir parçası değildir ama selenium otomasyonunda kullanılır
        Workboook => excel dosyamız
        Sheet => Her açık excel sekmesi (sheet 1,sheet 2
        Row(Satır) => Java yalnızca içerde veri varsa satırları sayar.Dedfault olarak,Java perspektifinden satır sayısı 0'dır
        Cell(hucre) => Java her satıra bakar ve yalnızca hücrede veri varsa hücre sayısını sayar

        Apache POI ,Microsoft ofis dokumanlarına ulaşmak için kullanılan Java API'dır
        Excel incelemek için poi dependency'lere ihtiyaç vardı:Genelde ikisi birden eklenir pom.xml'e

        Microsoft dosyları ile işlem yapmak isteyen tester,dev "pol.apache.org" sitesinden faydalanmalıdır(genel bilgi)

         ADIMLAR:
         =>JAVA dosyasına sağ tıla ve resources adında bir klasör oluştur.Resources dosyası excel,work,text.. gibi data dosyalarının olduğu klasörün adıdır
         =>Excel dosyasını bu klasöre at

     */

    @Test
    public void readExcelTest() throws IOException {
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

        //İLK SATIRDAKİ İLK VERİYİ AL
        Cell cell1 = row1.getCell(0);

        //O VERİYİ YAZDIR
        System.out.println(cell1);

        //1.SATIR 2.SÜTUN
       Cell cell12= sheet1.getRow(0).getCell(1);//1.satırın indexi 0,2.sütunun indexi 1
        System.out.println(cell12);

        //3.SATIR 1.SÜTUN YAZDIR ve O VERİNİN FRANCE OLDUĞUNU TEST ET
        String cell31=sheet1.getRow(2).getCell(0).toString(); //stringe çevirdiğimizde assert yapabiliyoruz
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        //EXCELDEKİ TOPLAM SATIR SAYISINI BUL
        int toplamSatirSayisi = sheet1.getLastRowNum()+1; //getLastRowNum() son satır numarasını verir.index 0'dan başlıyor sayma sayıları 1'den bu yüzden +1 yaptık
        System.out.println("Toplam satır sayısı: "+toplamSatirSayisi);

        //KULLANILAN (DOLU)TOPLAM SATIR SAYISINI BUL
        int kullanılanToplamSatırSayısı = sheet1.getPhysicalNumberOfRows(); //dolu olan satır sayısı.bu method 1 den başlar
        System.out.println("Kullanılan satır sayısı : "+kullanılanToplamSatırSayısı);

        //COUNTRY,CAPITALS key ve valualar map a alıp print et
           //{{USA,D.C},{FRANCE,PARIS}...}

        //Variable oluşturalım.Bu variable excel'deki country,capital
        Map<String,String> ulkeBaskentleri = new HashMap<>();
        for(int satirSayisi=1;satirSayisi<kullanılanToplamSatırSayısı;satirSayisi++){

            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capitals = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capitals);

        }
        System.out.println(ulkeBaskentleri);



    }
}
