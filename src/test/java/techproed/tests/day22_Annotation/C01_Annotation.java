package techproed.tests.day22_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    /*
    @Test: Testleri yazmak icin kullandigimiz notasyon
    @BeforeSuite: Her bir test suitinden once bir kez calisir
    @AfterSuite: Her bir test suitinden sonra bir kez calisir
    @BeforeTest: Her bir test oncesi bir kez calisir
    @AfterTest: Her bir test sonrasi bir kez calisir
    @BeforeClass: Her bir class tan once bir kez calisir
    @AfterClass:Her bir class'tan sonra bir kez calisir.
    @BeforeMethod:her bir test method'dundan once bir kez calisir=> JUnit'teki @Before
    @AfterMethod:her bir test method'dundan sonra bir kez calisir=> JUnit'teki @After
    --TestNG de @BeforeGroups,@AfterGroups,@FindBy gibi notasyonlarda vardir bunlari ileriki konularda gorecegiz.
    --JUnit'te @BeforeClass ve @AfterClass notasyonuna sahip methodlar "Static" olmak ZORUNDAYDI
    --TestNG FrameWork'unde boyle bir zorunluluk yoktur

     */

    @Test
    public void test1(){
        System.out.println("test1 calisti");
    }


    @Test
    public void test2(){
        System.out.println("test 2 calisti");
    }
    @Test
    public void test3(){
        System.out.println("test 3 calisti");
    }
    @Test
    public void test4(){
        System.out.println("test 4 calisti");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("After Suit");
    }

    /*
Before Suit===> buraya data base ba
Before Test===> driver konabilir
Before Class
Before Method==> extend konabilir
test1 calisti
After Method
Before Method
test 2 calisti
After Method
Before Method
test 3 calisti
After Method
Before Method
test 4 calisti
After Method
After Class
After Test
After Suit
     */
}
