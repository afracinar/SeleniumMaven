package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C03_JavaFaker {

    /*
         fake data = mock data = gerçek olmayan (sahte) test için kullanılan data
           örneğin: test yaparken gerçek telefon numaranı kullanmazsın.gerçek data ile test yapılmaz
           fake adress-fake telefon numarası- fake isim
        Fake data'lar test case'lerde data ihtiyacı olduğunda kullanılabilir
        Java Faker kütüphanesi, fake data üretmek için kullanılabilir

         <dependency>
              <groupId>com.github.javafaker</groupId>
              <artifactId>javafaker</artifactId>
              <version>1.0.2</version>
          </dependency>

          bunu pom.xml 'e ekleyerek fake data üretiriz


        1.Faker dependency pom'a ekle
        2.Faker objesi oluştur
           Faker faker = new Faker();  java kütüphanesinden gelir,seleniumdan gelmez
        3.Fake data üret
           String name = faker.method();
     */

    /*
         TEST DATA: kullanıcıadi,sifre,tel no,email,sehir,kredi kart no,... gibi verilere data deriz
         Test yaparken birden fazla ve farklı farklı datalara ihtiyacımız olur
         Test Data'ları kimden alınır ?
              1)BA-Business Analyst'ten gelir (BA,Acceptance Criteria'ları yazar, BRD ve FRD hazırlar)
              2)Test Lead
              3)Manuel Tester
              4)Tech Lead & Dev Lead & Dev Lead
              6)Developer
              7)DataBase
              8)Documantasyonlar
          Test Dataları kimden gelmez?
              1.Kullanıcıdan alınmaz
              2.scrum master'dan alınmaz
     */

    @Test
    public void test(){

        //1.ADIM :Faker objesi oluştur
        Faker faker = new Faker();

        //2.ADIM :Faker objesi ile fake data oluştur
          //firsname data'sı
        String fName= faker.name().firstName();
        System.out.println(fName);

        //last name datası
        String lastName = faker.name().lastName();
        System.out.println(lastName);

           //kullanıcı adı data'sı
        String userName = faker.name().username();
        System.out.println("Kullanıcı Adı :"+userName);

          //meslek ismi çağırma
        System.out.println("Meslek ismi :"+faker.name().title());

          //şehir ismi
        System.out.println(faker.address().city());

          //eyalet ismi
        System.out.println(faker.address().state());

          //full adres
        System.out.println(faker.address().fullAddress());

          //cep telefon numarası
        System.out.println(faker.phoneNumber().cellPhone());

          //mail
        System.out.println(faker.internet().emailAddress());

           //posta kodu
        System.out.println(faker.address().zipCode());

           //rastgele 15 haneli numara
        System.out.println(faker.number().digits(15));


    }
}
