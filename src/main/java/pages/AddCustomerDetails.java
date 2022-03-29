package pages;

import base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class AddCustomerDetails extends Base {
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;

    @FindBy(xpath = "//button[text()='Add Customer']")
    WebElement addcustomerbtn;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebtn;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openaccountbtn;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersbtn;
    public String alertmsg;
    //initialize page objects
    public AddCustomerDetails(){
        PageFactory.initElements(driver,this);

    }
    public void addcustomerdata(String fname, String ln, String pcode) throws InterruptedException {
        firstname.sendKeys(fname);
        lastname.sendKeys(ln);
        postcode.sendKeys(pcode);
        addcustomerbtn.click();
        Alert simplealert=driver.switchTo().alert();
        alertmsg= simplealert.getText();
        simplealert.accept();

    }
    public LoginPage clickhomebtn() throws InterruptedException {

        homebtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new LoginPage();
    }
    public OpenAccountPage accountbtn() throws InterruptedException {
        openaccountbtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new OpenAccountPage();
    }
    public CustomersPage customebtn() throws InterruptedException {
        customersbtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new CustomersPage();
    }


}
