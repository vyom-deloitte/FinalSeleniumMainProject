package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BankManagerHome extends Base {
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    WebElement addcustomer;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    WebElement openaccount;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customers;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebtn1;


    public BankManagerHome(){
        PageFactory.initElements(driver,this);
    }
    public AddCustomerDetails clickaddcustomer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        addcustomer.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new AddCustomerDetails();
    }
    public CustomersPage clickcustomers() throws InterruptedException {
        Thread.sleep(2000);
        customers.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new CustomersPage();

    }
    public OpenAccountPage clickonopenaccount() throws InterruptedException {
        Thread.sleep(2000);
        openaccount.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new OpenAccountPage();
    }
    public LoginPage clickhome() throws InterruptedException {
        Thread.sleep(2000);
        homebtn1.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        return new LoginPage();
    }

}
