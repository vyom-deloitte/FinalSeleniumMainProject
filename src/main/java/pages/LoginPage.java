package pages;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class LoginPage extends Base {

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    WebElement bankmanager;

    @FindBy(xpath = "//button[text()='Customer Login']")
    WebElement cutomer;
    //initialize page objects
    public LoginPage(){
        PageFactory.initElements(driver,this);

    }
    //actions
    public String validateloginpagetitle(){

        return driver.getTitle();
    }
    public BankManagerHome clickonmanagerlogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        bankmanager.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new BankManagerHome();

    }
    public NamePage clickoncustomerlogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        cutomer.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new NamePage();
    }




}
