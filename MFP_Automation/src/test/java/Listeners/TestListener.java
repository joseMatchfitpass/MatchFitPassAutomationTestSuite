package Listeners;

import Pages.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends Base implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {

        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        if (result.getTestClass().getName().contains("UI.Web")) {
            saveScreenshot();
        } else {
            mobileSaveScreenshot();
        }
        saveTextLog(getTestMethodName(result) + " Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        if (result.getTestClass().getName().contains("UI.Web")) {
            saveScreenshot();
        } else {
            mobileSaveScreenshot();
        }
        saveTextLog(getTestMethodName(result) + " Failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        killAllNode();
    }
}
