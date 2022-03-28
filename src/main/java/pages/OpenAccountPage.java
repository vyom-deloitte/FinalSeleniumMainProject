package pages;

import base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OpenAccountPage extends Base {
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement btnhome;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersbtn;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processbtn;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userselect;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addcustomer;
    public String altmsg;

    public OpenAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public CustomersPage customerbtnclick() throws InterruptedException {
        customersbtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new CustomersPage();
    }

    public LoginPage homeBtnClick() throws InterruptedException {
        btnhome.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new LoginPage();
    }

    public AddCustomerDetails clickaddcustomer() throws InterruptedException {
        addcustomer.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new AddCustomerDetails();

    }
    public void userdraopdown(String name,String currencyuser) throws InterruptedException {
        Select selectuser=new Select(userselect);
        selectuser.selectByVisibleText(name);
        Thread.sleep(2000);
        Select selectcurrency=new Select(currency);
        selectcurrency.selectByVisibleText(currencyuser);
        Thread.sleep(2000);
        processbtn.click();
        Alert simplealert=driver.switchTo().alert();
        altmsg= simplealert.getText();
        Thread.sleep(2000);
        simplealert.accept();
        Thread.sleep(2000);
    }
}
