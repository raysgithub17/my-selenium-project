package org.example;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class List implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Test finished...");
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Test success...");
    }




    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed...");}

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped...");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started...");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test success...");
    }

}