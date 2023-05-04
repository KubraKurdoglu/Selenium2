package techproed.tests.day28_Listeners;

import org.openqa.selenium.NoSuchElementException;
import org.testng.SkipException;
import org.testng.annotations.Test;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class C02_ListenersTest2 {
    /*
    Bir class'ta listener kullanabilmek için class'dan önce @Listeners notasyonu eklememiz gerekir.
    Notasyon içine parametre olarak Listeners class'ının yolunu belirtmemiz gerekir.
     */

    @Test
    public void test1() {
        System.out.println("PASSED");
        assertTrue(true);
        assertEquals(2, 2);//test true olsun diye bu degerleri verdi
        //getName'den dolayi bu testlerden sonra adlairni da yaziyor. getName()'i Listener class'ina eklemistik
    }

    @Test
    public void test2() {
        System.out.println("FAILED");
        assertTrue(false);
        assertEquals(2,1);//bilerek esit olmayan bir deger verdi, fail almak icin
        ReusableMethods.tumSayfaResmi("test2");
    }

    @Test//burda method icinde exception almak istiyoruz, yani bu testi "ignore" etmesini istiyoruz
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandi");
        //yukardaki sekilde yazarsak raporlamalarda gosterecek biz e"skip" i

    }

    @Test
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        throw new NoSuchElementException("NOSUCHELEMENTEXCEPTION");

        /*
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.xpath("kqkqkqkqkkq"));//elementi bulamasin diye boyle yazdi

         */
    }
}
