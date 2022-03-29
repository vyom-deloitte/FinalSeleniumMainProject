package testcases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;
@Listeners(CustomListener.class)
public class OpenAccountTest extends Base {
    AddCustomerDetails objaddcustomerdetails;
    LoginPage loginpage;
    BankManagerHome bankmanagerhome;
    OpenAccountPage openaccount;
    CustomersPage customerspage;
    public OpenAccountTest(){

        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        initialization();
        objaddcustomerdetails=new AddCustomerDetails();
        loginpage=new LoginPage();
        openaccount=new OpenAccountPage();
        bankmanagerhome=new BankManagerHome();
        customerspage=new CustomersPage();
        bankmanagerhome=loginpage.clickonmanagerlogin();
        openaccount=bankmanagerhome.clickonopenaccount();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
    @Test(priority = 1)
    public void clickCustomersTest() throws InterruptedException {
        customerspage=openaccount.customerbtnclick();
    }
    @Test(priority = 2)
    public void clickhomeTest() throws InterruptedException {
        loginpage=openaccount.homeBtnClick();
    }
    @Test(priority = 3)
    public void clickaddcustomerTest() throws InterruptedException {
        objaddcustomerdetails=openaccount.clickaddcustomer();
    }
    @Test(priority = 4)
    public void userdropdownTest() throws InterruptedException {
        openaccount.userdraopdown("Harry Potter","Dollar");

    }



    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
