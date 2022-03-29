package testcases;

import base.Base;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        FailedTest();
    }
}