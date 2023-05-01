package techproed.tests.day24_Properties_Pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TestCenterTechproPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import javax.swing.*;

import static org.testng.AssertJUnit.assertTrue;

public class C03_PageKullanimi {

    //https://testcenter.techproeducation.com/index.php?page=form-authentication
    //Page object Model kullanarak sayfaya giriş yapildigini test edin
    //Sayfadan cikis yap ve cikis yapildigini test et


    @Test
    public void test1() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));


        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterTechproPage testCenterTechproPage = new TestCenterTechproPage();
        testCenterTechproPage.userName.sendKeys(ConfigReader.getProperty("kullaniciAdi"), Keys.TAB,
                ConfigReader.getProperty("kullaniciPassword"), Keys.ENTER);

        //yukarda "password" icin locate alip xpath ile girmek yerine, TAB ile bir alt satira gecip
        //configReader araciligiyla password'u gonderdi

        assertTrue(testCenterTechproPage.text.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        //yeniden login yazisini gorursek bu sayfadan cikildigi anlamina gelir
        //o nedenle sayfadan cikildigini anlamak icin "login" kisminin locate'ini aldi


        testCenterTechproPage.logout.click();
        assertTrue(testCenterTechproPage.giris.isDisplayed());





    }

}

