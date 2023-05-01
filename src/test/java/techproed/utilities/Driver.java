package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

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

        /*
    Singleton Pattern: Tekli kullanım kalıbı.
        Bir class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade
        Bir class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için
    private access modifire kullanarak bir constructor oluştururuz
     */

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origin=*"));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(new EdgeOptions().addArguments("--remote-allow-origin=*"));
                    break;
                default://chrome ve edge gonderirken bir hata yaparsak default calissin
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origin=*"));
            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//Driver' a deger atanmissa close yap
            driver.close();
            driver = null;//isin bitti driver'i bosalt
        }
    }

    public static void quitDriver () {
        if (driver != null) {//Driver' a deger atanmissa close yap
            driver.quit();
            driver = null;//isin bitti driver'i bosalt
        }


    }


}