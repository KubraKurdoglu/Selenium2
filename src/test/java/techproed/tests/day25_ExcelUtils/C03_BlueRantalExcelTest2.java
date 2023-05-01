package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.security.Key;

public class C03_BlueRantalExcelTest2 {
    /*
        EXCEL dosyasindaki tum email ve passwordler ile
        BlueRentalCar sayfasina gidip login olalim
     */

    @Test
    public void test1() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");

        //sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();

        //Bir loop olusturup Excel dosyasindaki tum verileri girelim

        for (int i = 1; i <= excelUtils.rowCount() ; i++) {//i'yi 1'den baslatti, cunku veriler 1. satirdan basliyor
            String mail = excelUtils.getCellData(i, 0);//sutun ayni, cunku hep email sutunundakileri alacak
            //fakat satir degisecek
            String password = excelUtils.getCellData(i, 1);
            System.out.println(mail+" || "+password);

            blueRentalPage.login.click();
            blueRentalPage.email.sendKeys(mail, Keys.TAB, password, Keys.ENTER);

            blueRentalPage.login3.click();
            ReusableMethods.bekle(3);
            blueRentalPage.logout.click();
            ReusableMethods.bekle(3);
            blueRentalPage.ok.click();




        }

    }
}
