package UI;

import Base.BaseTest;
import Pages.Enums.Tabs;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UITestSamples extends BaseTest {

  //  @BeforeMethod
    public void driverSetup() {
        if (mobileDriver != null) {
            resetMobileApp();
        }
        if (driver != null) {
            login.closeAlert();
        }

    }

   // @Test(description = "To verify that the user can login successfully")
    @Description("To verify that the user can login successfully")
    public void TC001_AdminLogin() throws InterruptedException {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Jheyseeiy1!");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertNull(login.getAlertText());
        login.setAuthCode();
        login.clickOtpContinueButton();
        dashboard.validateDashboardPage();
        dashboard.clickTab(Tabs.FOR_ADMIN_VERIFICATION);
        dashboard.searchField.sendKeys("Jose ");
        Thread.sleep(2000);
        //get row count
        int rowCount = dashboard.getRowCount();
        //click view details
        dashboard.clickRowViewDetails(1);
        //click button
        //click update user detail
        //String test = dashboard.getTableValue(TableHeaders.NAME, 1);
    }

  //  @Test(description = "inValid Login Scenario with invalid username and password.")
    @Description("inValid Login Scenario with invalid username and password.")
    public void LogInTC_002() {
        Data.LogIn loginData = new Data.LogIn("+639176254816", "Jheyseeiyx!");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(login.getAlertText(), "Wrong password or Email");
    }

  //  @Test(description = "Mobile: valid Login Scenario with valid username and password.")
    @Description("Mobile: Valid Login Scenario with valid username and password.")
    public void mobile001() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Jheyseeiy1!");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
    }

  //  @Test(description = "Mobile: inValid Login Scenario with invalid username and password.")
    @Description("Mobile: inValid Login Scenario with invalid username and password.")
    public void mobile002() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Jheyseeiy1!");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
    }

   // @AfterTest
    public void teardown() {
        login.closeAlert();
        //driver.close();
        driver.quit();
    }
}
