package techproed.tests.Odevler;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.HerokuPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertTrue;


  /*
Negative Test
1.  https://id.heroku.com/login sayfasina gidin
2.  Faker class'ı kullanarak Dataprovider ile 5 adet email ve passwordleri giriniz
3.  Login butonuna tiklayiniz
4.  "There was a problem with your login." texti gorunur olduğunu test edin
5.  sayfalari kapatiniz
*/


public class Task12 {


    @DataProvider
    public static Object[][] herokuapp() {
        Faker faker = new Faker();
        String fkEmail=faker.internet().emailAddress();
        String fkPassword =faker.internet().password();
        return new Object[][]{{fkEmail, fkPassword}};
    }

    @Test(dataProvider = "herokuapp")
    public void heroku(String email, String password) {



        //1.  https://id.heroku.com/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));

        //2.  Faker class'ı kullanarak Dataprovider ile 5 adet email ve passwordleri giriniz
        HerokuPage herokuPage = new HerokuPage();
        WebElement login = herokuPage.login;
        herokuPage.cerez.click();

        for (int i = 0; i < 5; i++) {
            herokuPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            login.click();
            ReusableMethods.bekle(2);
            Driver.getDriver().navigate().back();
        }

        ReusableMethods.bekle(3);


        //3.  Login butonuna tiklayiniz
        //4.  "There was a problem with your login." texti gorunur olduğunu test edin
        assertTrue(herokuPage.alert.isDisplayed());

        //5.  sayfalari kapatiniz
        Driver.closeDriver();


    }
}
