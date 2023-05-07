package techproed.tests.day29_Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;


@Listeners(techproed.utilities.Listeners.class)//bunun sayesinde "fail" olan yerde ekran resmi verecek
//ve ayni zamanda "Listener" class'inin methodlari olan "ontest, onSkip vs", methodlarini kullandik.
public class C02_ListenersTest2 {
    @Test(retryAnalyzer = techproed.utilities.Listeners.class)//Eger test fail olursa Listeners classindaki
                                                               // retry methodu sayesinde 1 kez daha calisir
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
        Driver.getDriver().findElement(By.xpath("//*yanlislocate,fail almak icin"));
    }




    @Test(retryAnalyzer = techproed.utilities.Listeners.class)//Eger test fail olursa Listeners classindaki
                                                              // retry methodu sayesinde 1 kez daha calisir
    public void test2() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }




    @Test(retryAnalyzer = techproed.utilities.Listeners.class)//Eger test fail olursa Listeners classindaki
    // retry methodu sayesinde 1 kez daha calisir

    public void test3() {
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys("elllqlql=>yanlis emalil", Keys.TAB, "12345", Keys.ENTER);
        //burda hata almayacagiz sadece login yapamayacak, email yablis cunku

    }
}
