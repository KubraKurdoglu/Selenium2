package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class NegativeTest {
    /*
      Description:
        Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        Acceptance Criteria
        Customer email: fake@bluerentalcars.com
        Customer password: fakepass
        Error:
        User with email fake@bluerentalcars.com not found
     */

    @Test(groups = "smoke")
    public void test1() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        Reporter.log("BlueRental sayfasina gidildi");
        BlueRentalPage blueRentalPage =new BlueRentalPage();
        blueRentalPage.login.click();
        Reporter.log("Login butonuna tiklandi");
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,
                ConfigReader.getProperty("fakepass"));
        Reporter.log("Email ve password girildi");

        //burda Keys.ENTER ==> calismadi
        //o nedenle Login'in locate'ini aldi ve oyle click yapti
        //cok hizli geciyor, uyari yazisi gorunmuyor diye de "bekleme" koydu

        //burda giris yapilamayacagi icin "User with email" uyarisi gorunecek
        //bizim onun locate ini almmamiz lazim
        //isDisplayed ile veya assertEquals ile yapilabilir

        blueRentalPage.login2.click();
        Reporter.log("Tekrar Login butonuna tiklandi");

        //Hoca testbase'i kopyaladiktan sonra, adini ReusableMethods koydu, ve o class'taki methodlari kullandi
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("TumSayfaResmi");
        Reporter.log("Sayfanin resmi alindi");

        //Hatta burda, "tumSayfaResmi" methodunu kullaninca, otomatik TestOutput dosyasi olusturdu.
        //cunku o methodda dosya yolu vardi, methodu calistrinca dosyayi otomatik olusturdu

        assertTrue(blueRentalPage.hataMesaji.isDisplayed());
        Reporter.log("Dogrulama yapildi");
        Driver.closeDriver();
        Reporter.log("Sayfa kapatildi");

        //objeden cagirmamiz lazim; class'tan cagirirsak "satatic "ister

        //Reporter ==> TestNG'den geliyor





    }
}
