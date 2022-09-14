package com.sample.test.pizzaForm.utilits.listener;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Listener implements ITestListener, IMethodInterceptor, IAnnotationTransformer {

//    private DbWorker dbCon = new DbWorker();

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> testsToRun = new ArrayList<>();
        for (IMethodInstance method : methods) {
            Test testClass = method.getInstance()
                    .getClass()
                    .getAnnotation(Test.class);
            System.out.println("intercept" + getMethodName(method));
            if (testClass == null || testClass.enabled()) {
                testsToRun.add(method);
            }
        }
        return testsToRun;
    //    return null;
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        System.out.println("transform - " + testMethod.getName());
    }

    private String getMethodName(IMethodInstance method) {
        return method.getMethod().getTestClass().getName()
                + "." + method.getMethod().getMethodName();
    }


    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - START");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - SUCCESS");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test case name: " + getMethodName(iTestResult) + " - FAILURE");
//        takeScreenshot(getMethodName(iTestResult));
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

