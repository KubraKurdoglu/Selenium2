package techproed.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_LIsteners3 {

    //bu class'ta @Listeners da kullanmadik, herbir test methoduna rtreyAnalyzer de yazmadik fakat bunlarn
    //tum methodlarini kullanabildik, cunku "xml" file <Listeners< actik, bu sayesse methodlari kullanabildik
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
        Driver.getDriver().findElement(By.xpath("//*yanlislocate,fail almak icin"));
    }




    @Test
    public void test2() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }




    @Test

    public void test3() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("elllqlql=>yanlis emalil", Keys.TAB, "12345", Keys.ENTER);
        //burda hata almayacagiz sadece login yapamayacak, email yablis cunku

    }
}
