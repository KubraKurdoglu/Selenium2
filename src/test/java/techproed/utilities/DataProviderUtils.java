package techproed.utilities;

import org.testng.annotations.DataProvider;

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
        return excelUtils.getDataArray();
    }
}
