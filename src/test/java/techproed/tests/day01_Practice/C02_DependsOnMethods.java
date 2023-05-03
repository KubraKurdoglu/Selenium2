package techproed.tests.day01_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class C02_DependsOnMethods {

    // test01 isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // test02 isimli bir test methodu olusturunuz. Ve arama motoruna "Nutella" Yazıp aratın
    // test03 isimli bir test methodu olusturunuz. Ve sonuc yazısının "Nutella" icerdigini test edelim


    // test02 isimli test methodunu, test01'e baglayınız.
    // test03 isimli test methodunu, test02'ye baglayınız.

    /*

    Burda TestBase'ye extend etmedik cunku testler birbririyle bagimli, testbase deki methodlari kullansak before ve after
    her test methodundan pnce ve sonra calistigi icin, buredki testlerin bu sekilde calismasini engelleyecekti
    yani before ve after methodlar burada yazacagımız kodların calısmasına engel oleacagı ıcın sayfa ac
    kapa yapacak tı arama  motoruna dahı gıdemıyecektık
    Burada Before ve After class'i kullanmadik, cunku uc ayri method kullanacagiz ve bunlar birbirine
    bagimli olacak, o nedenle BeforeClass ve AfterClass' i kullandik.TestBase'i kullanmadik, dependsOnMethods'u
    kullanabilmek icin JUnit framework'unu kullanmak gerekiyor
     */

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void afterClass() {
       // driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        WebElement aramaMotoru = driver.findElement(By.id("twotabsearchtextbox"));
        aramaMotoru.sendKeys("nutella", Keys.ENTER);

    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        WebElement sonucNutella = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        assertTrue(sonucNutella.getText().contains("nutella"));
    }


}
