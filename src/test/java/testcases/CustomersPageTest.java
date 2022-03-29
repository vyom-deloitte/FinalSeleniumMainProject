package testcases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Listeners(CustomListener.class)
public class CustomersPageTest extends Base {
    CustomersPage objcustomer;
    LoginPage loginpage;
    BankManagerHome bankmanagerhome;
    AddCustomerDetails objaddcustomer;
    OpenAccountPage objopencnt;
    //Adding Log4J
    private static Logger log= LogManager.getLogManager().getLogger(CustomersPageTest.class.getName());


    public CustomersPageTest(){
        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        initialization();
        objcustomer = new CustomersPage();
        loginpage = new LoginPage();
        objaddcustomer =new AddCustomerDetails();
        bankmanagerhome= new BankManagerHome();
        bankmanagerhome= loginpage.clickonmanagerlogin();
        objcustomer= bankmanagerhome.clickcustomers();
        Thread.sleep(2000);
    }
    @Test
    public void fillvalueTeet() throws InterruptedException {
        objcustomer.fillvalue(prop.getProperty("firstname"));
    }
    @Test
    public void fillvalueDTeet() throws InterruptedException {
        objcustomer.fillvalue(prop.getProperty("duplicatefname"));
    }
    @Test
    public void addcustomerTest() throws InterruptedException {
        objaddcustomer = objcustomer.addCutomer();
    }
    @Test
    public void clickhomeTest() throws InterruptedException {
        loginpage = objcustomer.clickhome();
    }
    @Test
    public void openacntTest() throws InterruptedException {
        objopencnt = objcustomer.clickopenacnt();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }


}
