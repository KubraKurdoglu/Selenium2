package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    //Bu JUnit'teki TestBase class inin modofiye edilmis hali

    //asagidaki degiskenleri ilk basta "private" yapmamisti sonradan degistirmeye karar verdi
   private Workbook workbook;
   private Sheet sheet;
   private String path;

    //Constructor: Excel path'ine ve Excel'deki sayfaya ulsamak icn 2 parametreli cons. olusturduk.


    public ExcelUtils(String path, String sheetName){
        this.path =path;

        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet =workbook.getSheet(sheetName);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //Satir ve sutun sayilari verildiginde, o hucredeki veriyi return eder.

    public String getCellData(int rownum, int colNum){
        Cell cell = sheet.getRow(rownum).getCell(colNum);
        return cell.toString();
    }

    //Excel'deki satir sayisini return eder
    public int rowCount(){
        return  sheet.getLastRowNum();

    }
    //Excel'deki sutun sayisini return eder(sutun=cell)
    public int columnCount(){
        return  sheet.getRow(0).getLastCellNum();

        //0'i almasi su sebepten, sifir genellikle baslik kismi oluyor
        //baslikta tum sutunlar doludur, fakat alt satirlarda her hucre dolu olmayabilir
        // bu nedenle en saglikli sutun sayisi "baslik kismi" olan "0" inci satirdan alinmali
        //cunku basligi olmayan sutun anlamli degil, sayilmiyor


    }

    //Excel'deki datalari alabilmek icin 2 boyutlu bir Array method olusturalim

    public String[][] getDataArray(){
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 1; i <= rowCount() ; i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i-1][j]=value;//index 0'dan baslayacak ama biz i=1 dedik, o nedenle burada i-1 aldi

            }
        }
        return data;
    }

    //==============Sutun isimlerini verir==================//
    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }
    //=========Deger, Satir, Sutun girindiginde, O satır ve sutuna girilen veriyi ekler===============//
    public void setCellData(String value, int rowNum, int colNum) {
        try {
            sheet.getRow(rowNum).createCell(colNum).setCellValue(value);
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    Bu metot ustdeki metotla birlikde calisir. Overload eder. Parametreleri farklidir
    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

























}
