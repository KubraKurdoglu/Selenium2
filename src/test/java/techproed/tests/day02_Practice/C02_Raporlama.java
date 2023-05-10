package techproed.tests.day02_Practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.TestBaseRapor;

import static org.testng.AssertJUnit.assertTrue;

public class C02_Raporlama extends TestBaseRapor {

    //asagidaki class da , hata alindiginda ekran goruntusu alan bir method var, bu methodu calistirmak icin
    //java yerine, sonuc yazisinda olmayan bir kelime aratirsan, fail'in resmini de alacaktir.

    // 'https://www.amazon.com' adresine gidin
    // arama kutusuna "Java" yazip aratın
    // sonuc yazisinin "Java" icerdigini test edin
    // kontrollu olarak yeni bir sayfa acın
    // yeni acılan sayfada "Kitap" aratın
    // sonuc yazisinin Kitap icerdigini test edin
    // test raporu alınız

    @Test
    public void test01(){
        //tum adimlari yazdi hoca, en son  raporlama icin asgidaki adimlari yapti
        extentTest = extentReports.createTest("testname", "tanim");




        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        extentTest.pass("AMAZON SAYFASINA GIDILDI");

        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java", Keys.ENTER);
        extentTest.pass("ARAMA KUTUSUNA JAVA YAZILIP ARATILDI");

        // sonuc yazisinin "Java" icerdigini test edin

        assertTrue(amazonPage.sonucYazisi1.getText().contains("Java"));
        extentTest.pass("SONUC YAZISININ JAVA ICERIP ICERMEDIGI TEST EDILID");

        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.pass("KONTROLLU YENI SAYFA ACILDI");

        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        amazonPage.aramaKutusu.sendKeys("Kitap",Keys.ENTER);
        extentTest.pass("YENI ACILAN SAYFADA KITAP ARATILDI");

        // sonuc yazisinin Kitap icerdigini test edin
        assertTrue(amazonPage.sonucYazisi2.getText().contains("Kitap"));
        extentTest.pass("SONUC YAZISININ KITAP ICERIP ICERMEDIGI TEST EDILDI");

        // test raporu alınız
        //test raporunu tum test adimlarini bitiridikten sonra, sayfanin en yukarisinda yaptik.

    }
}
