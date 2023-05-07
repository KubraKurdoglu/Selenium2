package techproed.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {
    //yukarda uc tane ayri olabiecek class'i ayni anda implements yaotik, ayri da yapilabilirdi
    /*
    Listeners; TestNG de bir test'in durumunu ve sonucunuu izleyen ve bu duruma yanit veren bir yapidir
    Testlerin passed ve failed olma durumlarina, baslangic ve bitisini takip eder ve raporlayabilir.
    Bunun icin TestNG'den ITestListener arayuzunu(interface) kullaniriz. Olusturdugumuz Listeners class'ina
    ITestListener arayuzundeki methodlari Override etmek icin implements ederiz.
     */
    //asagidaki methodlar ITestListener'dan geliyor.
    @Override
    public void onStart(ITestContext context) {//BeforeClass gibi calisiyor
        System.out.println("onStart Methodu=> Tum testlerden once tek bir sefer cagrilir"+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("pnFinish=> tum testlerden sonra tek bir sefer cagrilir"+context.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {//Before gibi calisiyor
        System.out.println("onTestStart=> her bir test'ten once tek bir sefer cagrilir"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Methodu=> PASSED olan testlerden sonra tek bir sefer cagrilir");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure=> FAILED olan testlerden sonra bir tek sefer cagrilir"+result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Methodu -> SKIP(atlanan) olan testlerden sonra tek bir sefer çağrılır "+result.getName());
    }




    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    //maxRetryCount==> fail olan test'i kac kere calistiracagini gosteriyor
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
    /*
     Bu method(yukarda) sadece FAILED olan test case leri tekrar calistirir
    maxRetryCount ek olarak calisma sayisidir. Bu ornekte Fail olan test (maxRetryCount = 1) normal
    bir kere calistiktan sonra fail olursa birkez daha calisacaktir.
     */


    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        /*
            Bu methodun amacı; test notasyonlarını, sınıfları, cons.ları ve methodları transform(dönüştürme) etmemize
        olanak sağlar
            Bu method sayesinde Listeners sınıfını .xml dosyasında kullanabileceğiz ve istediğimiz class'ları fail
        olma durumunda listeners sınıfı retry methodunu kullanarak istediğimiz kadar tekrar çalıştırabileceğiz.
         */

        annotation.setRetryAnalyzer(Listeners.class);
    }
}
