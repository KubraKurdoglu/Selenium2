package techproed.tests.day01_Practice;

import org.testng.annotations.Test;
import techproed.pages.FacebookPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

public class C04_PageClassKullanimi {

    // facebook anasayfaya gidin
    // kullanıcı email kutusuna rastgele bir isim yazın
    // kullanıcı sifre kutusuna rastgele bir password yazın
    // giris yap butonuna tıklayın
    // girdigin sifre yanlıs yazı elementinin, gorunur oldugunu test edin
    // sayfayı kaptın


    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfaya gidin
        //burda once properties'de url olusturdu
        //sonra configReader araciligi(kopru) ile bu Url'ye ulasti

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));



        // kullanıcı email kutusuna rastgele bir isim yazın
        FacebookPage facebookPage = new FacebookPage();
        Thread.sleep(2000);
        facebookPage.cereziKabulEt.click();//cookies cikarsa bu calisir once



        facebookPage.emailKutusu.sendKeys("Kubra");

        // kullanıcı sifre kutusuna rastgele bir password yazın
        facebookPage.sifreKutusu.sendKeys("1234");

        // giris yap butonuna tıklayın
        facebookPage.girisYapButonu.click();

        // girdigin sifre yanlıs yazı elementinin, gorunur oldugunu test edin
        assertTrue(facebookPage.girdiginSifreYanlisYaziElementi.isDisplayed());


        // sayfayı kaptın
        Driver.getDriver().close();
    }
}
