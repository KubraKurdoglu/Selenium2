package techproed.tests.day24_Properties_Pages;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_ClassWork {
    //Config.Redader=> bize yardim ediyor properties den bilgileri almak icin
    @Test
    public void test1() {
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.closeDriver();//Driver'i bosalt sonra techpro'ya gec
        //eger driver'i kapatmasa idi hata veriridi
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
    }



}
