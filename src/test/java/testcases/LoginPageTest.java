package testcases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;
@Listeners(CustomListener.class)
public class LoginPageTest extends Base {
    LoginPage objloginpage;
    BankManagerHome objbankmanagerhome;
    NamePage objnamepage;
    public LoginPageTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        objloginpage=new LoginPage();
        objbankmanagerhome=new BankManagerHome();
        objnamepage= new NamePage();
    }
    @Test(priority = 2)
    public void loginpagetitletest(){
        String title=objloginpage.validateloginpagetitle();
        Assert.assertEquals(title,"XYZ Bank");
    }
    @Test(priority = 1)
    public void managerlogintest() throws InterruptedException {
        objbankmanagerhome=objloginpage.clickonmanagerlogin();
    }
    @Test
    public void customerlogintest() throws InterruptedException {
        objnamepage= objloginpage.clickoncustomerlogin();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
