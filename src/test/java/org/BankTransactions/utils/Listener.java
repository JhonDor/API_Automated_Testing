package org.BankTransactions.utils;

import org.BankTransactions.reporting.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        Reporter.info("test: " + result.getName()+ "[PASSED]");}

    @Override
    public void onTestFailure(ITestResult result){
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }
}