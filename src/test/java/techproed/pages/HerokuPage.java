package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HerokuPage {


    public HerokuPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath ="//input[@id='password']" )
    public WebElement password;

    @FindBy(xpath = "//button[@name='commit']")
    public WebElement login;

    @FindBy(xpath = "//div[@role='alert']")
    public  WebElement alert;

    @FindBy(xpath = "//button[@id='onetrust-reject-all-handler']")
    public WebElement cerez;

    // "There was a problem with your login."==>yazisinin locate'i
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement theWasaProblemYaziElementi;





}
