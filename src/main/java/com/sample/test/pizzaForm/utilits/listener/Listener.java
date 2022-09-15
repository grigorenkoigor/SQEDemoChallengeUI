package com.sample.test.pizzaForm.utilits.listener;

import com.sample.test.pizzaForm.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends TestBase implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - START");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - SUCCESS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - FAILURE");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " FailedButWithinSuccessPercentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("Context Tests case name: " + iTestContext.getName() + " ON START");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Context Tests case name: " + iTestContext.getName() + " ON FINISH");
    }

    private String getMethodName(ITestResult iTestResult) {
        return iTestResult.getTestClass().getName()
                + "." + iTestResult.getMethod().getMethodName();
    }
}

