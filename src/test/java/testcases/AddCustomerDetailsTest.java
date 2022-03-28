package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AddCustomerDetailsTest extends Base {
    AddCustomerDetails objaddcustomerdetails;
    LoginPage loginpage;
    BankManagerHome bankmanagerhome;
    OpenAccountPage openaccount;
    CustomersPage customerspage;
    public AddCustomerDetailsTest(){

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
        objaddcustomerdetails=bankmanagerhome.clickaddcustomer();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

    }
    @Test(priority = 1)
    public void addcustomertest() throws InterruptedException {
        objaddcustomerdetails.addcustomerdata(prop.getProperty("firstname"), prop.getProperty("lastname"),prop.getProperty("postcode"));
        Assert.assertEquals(objaddcustomerdetails.alertmsg,"Customer added successfully with customer id :6");

    }

    @Test(priority =2)
    public void homebtmtest() throws InterruptedException {
        loginpage= objaddcustomerdetails.clickhomebtn();

    }
    @Test(priority = 3)
    public void accountbtntest() throws InterruptedException {
        openaccount=objaddcustomerdetails.accountbtn();
    }
    @Test(priority = 4)
    public void customerbtntest() throws InterruptedException {
        customerspage=objaddcustomerdetails.customebtn();
    }
    @Test(priority = 5)
    public void addDuplicateCustomerTest() throws InterruptedException {
        objaddcustomerdetails.addcustomerdata(prop.getProperty("duplicatefname"), prop.getProperty("duplicatelname"), prop.getProperty("duplicatepcode"));
        Assert.assertEquals(objaddcustomerdetails.alertmsg,"Please check the details. Customer may be duplicate.");
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
