package UI.Web;

import Base.BaseTest;
import Pages.Enums.Tabs;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.Enums.SideBarMenu.USER_CODES;
import static Pages.Enums.StageURL.ADMIN_DASHBOARD;

public class AdminDashboardTests extends BaseTest {

    @BeforeMethod
    public void classSetup() {
        if (driver != null) {
            login.closeAlert();
        } else {
            webDriverSetup();
        }
        driver.get(ADMIN_DASHBOARD.getUrl());
    }

    @Test(description = "TC003_Admin Login")
    @Description("To verify that system will validate in the user enters an invalid password")
    @TmsLink("MFPA-469")
    public void MFPA_469() {
        Data.LogIn loginData = new Data.LogIn("+639176254816", "Password123@!");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(login.getAlertText(), "Wrong password or Email");
    }

    @Test(description = "TC004_Admin Login")
    @Description("To verify that system will validate invalid email and password")
    @TmsLink("MFPA-110")
    public void MFPA_110() {
        Data.LogIn loginData = new Data.LogIn("+639176254816", "Password123@!");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(login.getAlertText(), "Wrong password or Email");
    }

    @Test(description = "TC0006_Admin Login")
    @Description("Verify the ability to show Password text")
    @TmsLink("MFPA-890")
    public void MFPA_890() {
        Data.LogIn loginData = new Data.LogIn("+639176254816", "Password123@!");
        login.validateLoginPageObjects();
        login.validateShowPassword(loginData);
    }

    @Test(description = "TC0001_User Codes View Active Codes")
    @Description("Verify that header title is correct")
    @TmsLink("MFP-776")
    public void MFP_776() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertNull(login.getAlertText());
        login.setAuthCode();
        login.clickOtpContinueButton();
        dashboard.validateDashboardPage();
        dashboard.clickNavMenu(USER_CODES);
        Assert.assertEquals(dashboard.getPageHeaderText(USER_CODES), USER_CODES.getTitle());
    }

    @Test(description = "TC0001_Admin Login")
    @Description("Verify that the user can login successfully")
    @TmsLink("MFP-745")
    public void MFP_745() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertNull(login.getAlertText());
        login.setAuthCode();
        login.clickOtpContinueButton();
        dashboard.validateDashboardPage();
        dashboard.clickTab(Tabs.FOR_ADMIN_VERIFICATION);
    }

    @AfterClass
    public void cleanup() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

}
