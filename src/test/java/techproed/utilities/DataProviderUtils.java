package techproed.utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import techproed.pages.HerokuPage;

public class DataProviderUtils {
    @DataProvider
    public Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","IçAnadolu","06"},{"Izmir","Ege","35"},{"DiyarBakır","Doğu","21"}};
    }

    @DataProvider
    public Object[][] kullanicilar() {
        return new Object[][]{{"Erol","65656565656"},{"Nuri", "65656768768"},{"Sefa","90909090907"}};
    }

    @DataProvider
    public Object[][] blueRental() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx", "customer_info");
        return excelUtils.getDataArray();//buradki getDataAarray() methodunu ExcelItils class inda olusturdu
    }


}
