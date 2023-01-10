package day12;

import utilities.TestBase;

public class C02_Synchronization extends TestBase {

    /*
    Synchronization, driver objesi ile web sitenin uyumlu bir şekilde çalışması demektir
    Bir sayfanın uygulama sunucusu veya web sunucusu çok yavaş ise veya internet ağı çok yavaşsa web sayfasındaki öğe(element) çok yavaş yüklenir
    Bu durumda,komut dosyanız öğeyi bulmaya çalıştığında,öğeler  yüklenemez
    Bu yüzden test komut dosyası öğeyi bulamaz ve başarısız olur ve NoSuchElementException alırız

    Driver ve cihaz veya internet arasında yaşanan senkronizayson sorunlarını çözmek için driver'ımızı belli şartlar ile bekletmemiz(wait) gerekir
       1)Veri Tabanlı Wait
          Thread.sleep() ==> Java'dan gelir ve kodları yazılan süre kadar bekletir.Süre dolduktan sonra alt satırdan işleme devam eder

       2)Selenium Tabanlı Wait'ler
          Implicitly Wait ==> Sayfadaki tüm öğeler için global bir zamanaşımıdır
             driver.manage().timesouts()
          Explicitly Wait==> Çoğunlukla belirli öğeler için belirli koşul için kullanılır.Yereldir(local).Implicitly Wait çalışmadığı durumlarda kullanılır
             WebDriverWait

    Thread.sleep(20); //HARD WAİT'tir . 20 saniye kesin bekler Java'dan gelir
    implicitlyWait(Duration.ofSeconds(20)); //en fazla 20 saniye bekler,site açılırsa süre sonuna kadar beklemesine gerek kalmaz,devam eder
                                           Seleniumdan gelir

     Explicitly Wait ==> Belirli bir elemente bir wait koymak istediğimiz zaman kullanırız.
                         Implicitly Wait ile çözülebilecek durumlar için çalışmadığı durumlarda Explicitly Wait kullanılmasına ihtiyaç yoktur.
                         Nadiren karşımıza çıkar ve daha fazla bekleme süresi gerektiren belirli öğeler için Explicitly Wait kullanılır

     */
}
