package techproed.tests.day25_ExcelUtils;

import org.testng.annotations.Test;
import techproed.utilities.ExcelUtils;

public class C01_ExcelTest1 {

    //sutun 1'den satir 0'dan basliyor UNUTMA!
    @Test
    public void test1() {
        String path = "src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa ="customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path, sayfa);
        System.out.println("1 ve 0 : "+ excelUtils.getCellData(1, 0));
        String email = excelUtils.getCellData(1,0);
        String password = excelUtils.getCellData(1,1);
        System.out.println(email + " || "+ password);

    }
}
