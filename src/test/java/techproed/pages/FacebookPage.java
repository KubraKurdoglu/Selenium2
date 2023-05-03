package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class FacebookPage {


    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //variablel'ler static olsa idi, obje olusturmaz ve bu nedenle buradki default constructor'u kullanamazdik
    // o nedenele loacater class'inda variable'ler instance oldugu icin, obje olusturup cagiriyoruz onlari

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girdiginSifreYanlisYaziElementi;

    //eger cerez varsa bunu kullanabilirsin
    @FindBy(xpath = "(//button[@value='1'])[3]")
    public WebElement cereziKabulEt;





}
