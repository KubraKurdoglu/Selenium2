package techproed.tests.day24_Properties_Pages;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class C02_PageKullanimi {

    //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
    //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
    //Login Testini basarili oldugunu test et

    @Test
    public void test1() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSource_Url"));

        /*
        Yukardaki adres icin 20 adet test methodu olusturursak sonrasinda yukardaki url'de bir
        degisiklik oldugunda butun test methodlarindan tek tek url duzeltmek yerine bir kere .properties
        dosyamdan url'i duzeltirim ve bu bizim icin daha hizli daha duzenli ve daha kolay olur.
         */

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
        //TestNG'de locate'lerimizi bir yerde topluyor ve ordan kullaniyoruz

        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        openSourcePage.login.click();

        //Login Testini basarili oldugunu test et

        assertTrue(openSourcePage.dashboard.isDisplayed());




    }
}
