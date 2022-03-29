package testcases;

import base.Base;
import org.apache.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Listeners(CustomListener.class)
public class AddCustomerDetailsTest extends Base {
    AddCustomerDetails objaddcustomerdetails;
    LoginPage loginpage;
    BankManagerHome bankmanagerhome;
    OpenAccountPage openaccount;
    CustomersPage customerspage;

    //Adding Log4J
   // private static Logger log= LogManager.getLogger(AddCustomerDetailsTest.class.getName());
   //log.error("hello error");
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
    public void addcustomertest() throws InterruptedException, IOException {
       // File file = new File("C:\\Users\\vypant\\FinalSeleniumMainProject\\src\\main\\java\\data\\UserData.xlsx");
        FileInputStream inputStream = new FileInputStream("C:\\Users\\vypant\\FinalSeleniumMainProject\\src\\main\\java\\data\\UserData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        String first=null;
        String last=null;
        String postcode=null;
        for(int i=1;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    first= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if (j == 1) {
                    last= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==2){
                    postcode=sheet.getRow(i).getCell(j).getStringCellValue();
                }

            }
            System.out.println(first+" "+last+" "+postcode);
           //log.error("test failed in reading");
            objaddcustomerdetails.addcustomerdata(first,last,postcode);
            System.out.println(objaddcustomerdetails.alertmsg);
            objaddcustomerdetails.customebtn();
            customerspage.addCutomer();
        }
        wb.close();
        inputStream.close();
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
