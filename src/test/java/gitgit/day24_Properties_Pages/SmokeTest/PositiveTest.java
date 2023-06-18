package gitgit.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.*;

public class PositiveTest {
    /*
        Acceptance Criteria:
        Admin olarak, uygulamaya giriş yapabilmeliyim
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
         */


    @Test(groups = "smoke")
    public void test1() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage =new BlueRentalPage();
        blueRentalPage.login.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("email"), Keys.TAB,
                ConfigReader.getProperty("pass"), Keys.ENTER);


        //Girisi dogrulamak icin giris yapildiginda
        // sag uste kullanici adini gosteren kisim var, oranin locate'ini alabiliriz

        assertEquals(blueRentalPage.verify.getText(), "Jack Nicholson");

    }
}
