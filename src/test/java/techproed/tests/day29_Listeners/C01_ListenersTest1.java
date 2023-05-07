package techproed.tests.day29_Listeners;

import org.openqa.selenium.NoSuchElementException;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ReusableMethods;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


//burda iki sey yaptik, 1= rety ile fail olan testleri tekrar calistirdik
//2. class isminin uzerine @Listener yazarak, listner class'indan method kullanabilmek icin ,
//failed cikan testlerin ekran goruntsunu aldik
@Listeners(techproed.utilities.Listeners.class)//
public class C01_ListenersTest1 {
    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test1() {
        System.out.println("PASSED");
        assertTrue(true);
        assertEquals(2, 2);//test true olsun diye bu degerleri verdi
        //getName'den dolayi bu testlerden sonra adlairni da yaziyor. getName()'i Listener class'ina eklemistik
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test2() {
        System.out.println("FAILED");
        assertTrue(false);
        assertEquals(2,1);//bilerek esit olmayan bir deger verdi, fail almak icin
        ReusableMethods.tumSayfaResmi("test2");
    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    //burda method icinde exception almak istiyoruz, yani bu testi "ignore" etmesini istiyoruz
    public void test3() {
        System.out.println("SKIP");
        throw new SkipException("Method atlandi");
        //yukardaki sekilde yazarsak raporlamalarda gosterecek biz e"skip" i

    }

    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void test4() {
        System.out.println("NO SUCH ELEMENT EXCEPTION");
        throw new NoSuchElementException("NOSUCHELEMENTEXCEPTION");

        /*
        Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
        Driver.getDriver().findElement(By.xpath("kqkqkqkqkkq"));//elementi bulamasin diye boyle yazdi

         */
    }
}
