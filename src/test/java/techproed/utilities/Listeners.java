package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
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
}
