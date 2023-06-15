package gitgit.day01_Practice;

import org.testng.annotations.Test;
import techproed.utilities.TestBase;

public class C01_Priority extends TestBase {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız

    //Priortiy degeri en kucuk olan en once calisir
    //priortiy e herhangi bir deger atamazsan "default" deger olan "0" atar

    //!!!!!!!!!!!!!
    /*
    TestNG, test methodlarını isim sırasına gore calıstırır
    eger isim sıralamasının dısında bir sıralama ile calısmasını isterseniz
    o zaman test methodlarına oncelik(priority) tanımlayabiliriz.


    priority kucukten buyuge gore calısır
    eger bir test methoduna priority degeri atanmamıssa
    default olarak priority=0 kabul edilir
     */

    @Test(priority = -2)
    public void amazon() {
        driver.get("https://www.amazon.com");
    }

    @Test(priority = -5)
    public void bestBuy() {
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void techproeducation() {
        driver.get("https://www.techproeducation.com");
    }


}
