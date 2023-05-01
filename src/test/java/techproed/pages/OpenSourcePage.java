package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
            /*
        Locate'lerimizi tek bir yerde duzenli bir sekilde tutabilmek icin;

        1-ilk olarak olusturmus oldugumuz page class'imizda bir constructor olustururuz.
        2-PageFactory class'indan initelements methodu ile driver'i tanitiriz.
        3-@findBy notasyonu kullanarak locatelerimizi aliriz.
            */

    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Driver.getDirver().get(By.xpath("locate"))==> normalde boyle aliyorduk locate'i ama
    //TestNG'de boyle yapmayacagiz, FindBy ile bulacagiz

    @FindBy(xpath ="//*[@name='username']")
    public WebElement username;

    //Bunu Test annaotationun icinde yapmamamizin nedeni, bizim yuzlerce test iliz olacak
    //bir veri de degisiklik yapmak istedigimiz zaman "Pages" e girip degislik yapmak
    //cok kolaylik oluyor

    @FindBy(xpath ="//*[@name='password']")
    public WebElement password;
    @FindBy(xpath ="//*[@type='submit']")
    public WebElement login;
    @FindBy(xpath ="//h6")
    public WebElement dashboard;



}
