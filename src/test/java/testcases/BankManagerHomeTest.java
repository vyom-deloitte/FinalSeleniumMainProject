package testcases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;
@Listeners(CustomListener.class)
public class BankManagerHomeTest extends Base {
    BankManagerHome objbankmanagerhome;
    AddCustomerDetails objaddcustomerdetails1;
    LoginPage loginpage;
    OpenAccountPage objopenacnt;
    CustomersPage objcustomers;
    public BankManagerHomeTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        objbankmanagerhome=new BankManagerHome();
        loginpage=new LoginPage();
        objcustomers=new CustomersPage();
        objopenacnt=new OpenAccountPage();
        objaddcustomerdetails1=new AddCustomerDetails();
        objbankmanagerhome=loginpage.clickonmanagerlogin();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
    @Test(priority = 1)
    public void addcustomertest() throws InterruptedException {
        objaddcustomerdetails1 = objbankmanagerhome.clickaddcustomer();

    }
    @Test(priority =2)
    public void openaccounttest() throws InterruptedException {
        objopenacnt = objbankmanagerhome.clickonopenaccount();

    }
    @Test(priority = 3)
    public void customerstest() throws InterruptedException {
        objcustomers=objbankmanagerhome.clickcustomers();
    }
    @Test(priority =4)
    public void homebtmtest() throws InterruptedException {
        loginpage=objbankmanagerhome.clickhome();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
