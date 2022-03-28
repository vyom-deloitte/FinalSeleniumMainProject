package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CustomersPage extends Base {
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement inputCustomer;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addcustomer;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebn;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openbtn;

    public CustomersPage(){
        PageFactory.initElements(driver,this);
    }
    public void fillvalue(String username) throws InterruptedException{
        inputCustomer.sendKeys(username);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        deleteBtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
    public AddCustomerDetails addCutomer() throws InterruptedException {
        addcustomer.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new AddCustomerDetails();
    }
    public LoginPage clickhome() throws InterruptedException {
        homebn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new LoginPage();
    }
    public OpenAccountPage clickopenacnt() throws InterruptedException {
        openbtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new OpenAccountPage();
    }

}
