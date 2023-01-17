package day11;

public class C02_Actions6_Interwiew {

    /*
        1)Actions Nedir ?
           Actions Selenium'dan gelen bir kütüphanedir
           Mouse ve Keyboard işlemlerini gerçekleştirmek için kullandığımız bir hazır selenium kütüphanesidir
           Örneğin; sağa tıklama(contextClick),çift tıklamak,bir elementin üzerine gitmek(moveToElement) .. gibi işlemleri gerçekleştirebiliriz
           Aynı zamanda shift,control,delete,enter ..gibi keyboard tuşlarına da actions yardımıyla basabiliriz
           Bu tür işlemlerde sendKeys() methodu kullanılır

        2)Ne tür methodları kullandın ?
           Actions methodları önemlidir.Ve tekrar tekrar kullanmam gerektiğinden Actions methodlarını içeren reusable methodlar oluşturdum ve
           gerektiğinde bu usable methodları kullanıyorum.Örneğin;
           rightClick methodunu bir elemente sağa tıklamak için test class'ımda çağırabilirim : rightClickOnElementActions()
           draganddroopActions methodu elementi sürüklemek ve bırakmak için oluşturduğum methodlardandır

        3)Hangi methdoları kullandın ne işe yarar ?
           doubleClick() = locatini verdiğimiz elemete çift tıklama yapar
           contextClick() = locate'ını verdiğimiz elemente sağ tıklama yapar
           moveToElement() = mouse'u hareket ettirir
           dragAndDrop() = elementi sürükler ve bırakır

     */


}
