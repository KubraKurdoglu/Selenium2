package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProvider {

                /*
            DataProvider, bir çok veriyi test case'lere loop kullanmadan aktarmak için kullanılır.
            TestNG'den gelen bir özelliktir. 2 boyutlu bir Object Array return eder.
            DDT(Data Driven Testing) için kullanılır. Yani birden fazla veriyi test case'lerde aynı anda kullanmak için
            kullanılır.
            Kullanımı için @Test notasyonundan sonra parametre olarak dataprovider yazılır ve String bir isim belirtilir.
            Bu belirttiğimiz isimle @DataProvider notasyonu ile bir method oluşturulur.
             */


    @DataProvider(name = "googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"}};
    }

    /*
        Eğer farklı bir test methodu için aynı dataProvider methodu kullanılacaksa
         @DataProvider(name = "googleTest") şeklinde dataProvider notasyonundan sonra name parametresine yeni
         oluşturduğumuz methodun adını yazarız.
         */


    @Test(dataProvider = "urunler")
    public void test1(String data) {//DataP.'daki verileri alabilmek icin
        //test methodumuza String bir parametre atamasi yapariz
    }


    @Test(dataProvider = "googleTest")//navigate.back'e gerek kalmadan dataProvider sayesinde geri geldik ve hepsini test etti
    public void googleTest(String araclar) {
        //Google sayfasına gidiniz
        //Driver.getDriver().get("https://google.com");==> bu sekilde de gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().findElement(By.xpath("(//div[@role='none'])[12]")).click();

        //{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"} araçları aratınız
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);


        //Her aratmadan sonra sayfa resmi alınız
        ReusableMethods.tumSayfaResmi();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
