package com.appspot.xssgame.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileWriter;
import java.io.IOException;


public class TestListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

//        try (FileWriter writer = new FileWriter("target/success.txt", true)){
//            for(Object param:iTestResult.getParameters()){
//                writer.write((String) param);
//                writer.write('\n');
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void onTestFailure(ITestResult iTestResult) {
//
//        try (FileWriter writer = new FileWriter("target/failure.txt", true)){
//            for(Object param:iTestResult.getParameters()){
//                writer.write((String) param);
//                writer.write('\n');
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
   }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
