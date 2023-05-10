package techproed.tests.day02_Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.io.File;
import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class C01_PageClassKullanimi {

    // amazon sayfasına gidin
// dropdown'dan "Computers" optionunu secin
// arama motoruna "Asus" yazıp aratın
// ikinci urunun fotografını cekin
// ikinci urune tıklayın
// title'ının "ASUS" icerdigini test edin
// sayfayı kapatın

    @Test
    public void test01() throws IOException {
        // amazon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));

        // dropdown'dan "Computers" optionunu secin
        AmazonPage amazonPage = new AmazonPage();
        Select select = new Select(amazonPage.ddm);
        select.selectByVisibleText("Computers");

        // arama motoruna "Asus" yazıp aratın
        amazonPage.aramaKutusu.sendKeys("Asus", Keys.ENTER);


        // ikinci urunun fotografını cekin
        File kayit = new File("target/ekranGoruntusu/kayit.Jpeg");//cektigimiz fotografi nereye kadedecek?onu bu "file" dosyasi ile belirliyoruz
        File gecici = amazonPage.ikinciUrun.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici, kayit);//gecici dosyasindaki fotogfrafi kayit dosyasina koyacak

        //ekran goruntusunu aldigimiz urunu direk kayit edememisler, o nedenle once gecici bir kayit yapiyor
        //sonra kayit dosyasina atiyoruz.


        // ikinci urune tıklayın
        amazonPage.ikinciUrun.click();

        // title'ının "ASUS" icerdigini test edin
        assertTrue(Driver.getDriver().getTitle().contains("ASUS"));
        //getTitle()==> zaten String dondurur, o nedenle getText() demene gerek yok.

        // sayfayı kapatın
        Driver.closeDriver();

    }
}
