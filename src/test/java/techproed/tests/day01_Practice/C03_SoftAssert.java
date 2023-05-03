package techproed.tests.day01_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.TestBase;

public class C03_SoftAssert extends TestBase {
    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin


    @Test
    public void test01() {
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://www.amamzon.com");

        /// Title'in "Amazon" icerdigini test edin
        //burada softassertion kullanin dedigi icin oncelikle sosfassert objesi olusturmaliyiz
        //cunku sofassert static degildir, instance'dir. bu nedenle onun methodlarini obje ile vagirmamiz gerekiyor


        SoftAssert softAssert = new SoftAssert();

        String amazonTitle = driver.getTitle();

        softAssert.assertTrue(amazonTitle.contains("Amazon"), "Title Amazon icermiyor");


        /// Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        /// Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi  =driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(), "SONUC YAZISI GORUNMUYOR");

        /// Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"), "SONUC YAZISI NUTELLA ICERMIYOR");


        // test islemlerini softAsser ile yapınız ve hatalar icin mesaj versin

        softAssert.assertAll();//hata ile karsilasirsa butun hatalari bizim icin listeleyecek

    }
}
