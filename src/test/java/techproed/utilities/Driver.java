package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    public static WebDriver getDriver() {
        /*
    Driver'i her cagirdiginda yeni bir pencere acilmasinin onune gecmek icin
    if blogu icinde eger driver'a deger atanmamissa deger ata ,Eger deger atanmissa Driver'i ayni
    sayfa da RETURN et.Bunun sadece yapmamiz gereken if(driver==null) kullanmak
    (Driver'in dolu demek zaten bir browser acti isen, yine onu kullan, uc browser acmak yerine
    bir browser'da tum islemleri yap demek.)
    */

        if (driver == null) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origin=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
        return driver;
    }
    public static void closeDriver(){
        driver.close();
    }

}
