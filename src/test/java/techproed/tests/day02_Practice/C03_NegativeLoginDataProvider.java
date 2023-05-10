package techproed.tests.day02_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HerokuPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class C03_NegativeLoginDataProvider {


    // https://id.heroku.com/login sayfasına gidin
    // yanlis email ve yanlis password giriniz
    // login butonuna tıklayınız
    // "There was a problem with your login." texti gorunur oldugunu test edin
    // sayfayı kapatınız


    // NOT: birden fazla email ve password'u dataProvider kullanarak sırayla deneyin
    //data provider kullanbilmek icin @test==> yanina dataProvider yazmamaiz ve bir isim vermmeiz gerekiyor
    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {{"ali@gmail.com","123456"},
                {"veli@gmail.com","654123"},
                {"hasan@gmail.com","741258"}};

        return kullaniciBilgileri;
    }


    @Test(dataProvider = "kullaniciListesi")//bunu yazdiktan sonra , buraya tiklayinca otomatik methodu yapiyor
    public void test01(String email, String password) {

    // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));

    // yanlis email ve yanlis password giriniz
        HerokuPage herokuPage = new HerokuPage();
        herokuPage.email.sendKeys(email);
        herokuPage.password.sendKeys(password);

    // login butonuna tıklayınız
        herokuPage.login.click();

    // "There was a problem with your login." texti gorunur oldugunu test edin
        assertTrue(herokuPage.theWasaProblemYaziElementi.isDisplayed());

    // sayfayı kapatınız
        Driver.closeDriver();
}
}
