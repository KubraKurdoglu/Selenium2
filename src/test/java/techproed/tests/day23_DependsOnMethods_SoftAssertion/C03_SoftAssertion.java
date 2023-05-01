package techproed.tests.day23_DependsOnMethods_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_SoftAssertion {

    /*
 SoftAssert kullanmak icin oncelikle bir obje olusturmamiz gerek
 Hard assertionda bir dogrulama fail olursa testin calismasi durur
  SoftAssertion da assertAll () methodu ile testin farkli bolumlerinde softassert kullanarak
dogrulama yapsakta testi istedigimiz yerde sonlandiririz.
  */



    SoftAssert softAssert;
    WebDriver driver;
    @Test
    public void amazonTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //ILK OLARAK Obje olusturduk
        //sonrasinda olusturmus oldugumuz oble ile assert methodlari ile dogrulama yapariz
        //son olarak assert objesini kullanarak assertAll() ethodu kullamamiz gerekir

        softAssert = new SoftAssert();

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //URL'nin amazon.com.tr olup olmadigini dogrulayiniz
        softAssert.assertEquals(driver.getCurrentUrl(), "https://amazon.com.tr");
        //Assert.assertEquals(driver.getCurrentUrl(), "https://amazon.com.tr");==> burda hard assertion kullandi
        //ve hata oldugu icin kodu direk burada durdurdu



        //basligin best icerdigini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));

        //arama kutusuna "iphone" aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);


        //Sonucun "samsung" icerip icermedigini test edin
        WebElement sonuc = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        softAssert.assertTrue(sonuc.getText().contains("samsung"));
        System.out.println("Gercek sonuc Iphone olmali");
        softAssert.assertAll();
        System.out.println("Test sonuclandi");//==> bunu yazdirmayacak
    }

}
