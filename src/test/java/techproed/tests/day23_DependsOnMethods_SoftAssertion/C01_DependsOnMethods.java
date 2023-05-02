package techproed.tests.day23_DependsOnMethods_SoftAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {
    /*
Test methodlari birbirinden bagimsiz calisir, Methodlari birbirine bagimli calistirmak istersek
"dependsOnMethods"parametresini @Test notasyonundan sonra baglamak istedigimiz test method'unun
adini belirtiriz.


/*
        TestNG test method'larını isim sırasına (alfabetik) göre ve rakamlara göre küçükten büyüğe çaliştirir.
    Eğer isim sıralamasının dışında bir sıralama ile çalışmasını isterseniz o zaman test methodlarına öncelik(priority)
    tanımlayabiliriz.
        Priority küçükten büyüğe göre çalışır. Eğer bir test methoduna priority atanmamışsa
    default olarak priority=0 kabul edilir.
     */

    WebDriver driver;
    @Test
    public void amazonTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test (dependsOnMethods = "amazonTest")
    public void amazonTest2(){
        driver.get("https://amazon.com");// yukardaki dependsOnMethod olmasa ==>BullPointerException verirdi
    }

    /*
    @Test(dependsOnMethods = "amazontest2")
    public void amazonTest3() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }

     */
}
