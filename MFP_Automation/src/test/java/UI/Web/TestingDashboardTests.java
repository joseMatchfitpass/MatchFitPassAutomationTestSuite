package UI.Web;

import Base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;

import static Pages.Enums.SideBarMenu.*;
import static Pages.Enums.StageURL.TEST_DASHBOARD;

public class TestingDashboardTests extends BaseTest {

    @BeforeMethod
    public void classSetup() {
        if (driver != null) {
            login.closeAlert();
        }
        else {
            webDriverSetup();
        }
        driver.get(TEST_DASHBOARD.getUrl());
    }

    @Test(description = "TC0001_Website Testing Nav")
    @Description("To verify the ability to load testing page")
    @TmsLink("MFPA-1493")
    public void MFPA_1493() {
        login.validateLoginPageObjects();
    }

    @Test(description = "TC0001_Website Testing Nav")
    @Description("To verify that system will validate invalid email and password")
    @TmsLink("MFPA-581")
    public void MFPA_581() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123x@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(login.getAlertText(), "Wrong password or Email");
    }

    @Test(description = "TC002_Testing Login")
    @Description("To verify that system will validate invalid email and password")
    @TmsLink("MFPA-227")
    public void MFPA_227() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123x@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(login.getAlertText(), "Wrong password or Email");
    }
    @Test(description = "TC001_Testing Login")
    @Description("To verify that the user can login successfully")
    @TmsLink("MFPA-327")
    public void MFPA_327() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.validateDashboardPage();
    }

    @Test(description = "TC001_Testing Centre Details")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-572")
    public void MFPA_572() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.validateDashboardPage();
    }

    @Test(description = "TC001_Testing Registered Test Types")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-298")
    public void MFPA_298() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.validateDashboardPage();
        driver.get(TEST_DASHBOARD.getUrl()+REGISTERED_TEST_TYPES.getHref());
        broadcastMessage.validatePage();
        Assert.assertEquals(broadcastMessage.getHeaderTitle(),REGISTERED_TEST_TYPES.getTitle());
    }

    @Test(description = "TC001_Testing Broadcast Message")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-565")
    public void MFPA_565() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.validateDashboardPage();
        driver.get(TEST_DASHBOARD.getUrl()+BROADCAST_MESSAGE.getHref());
        broadcastMessage.validatePage();
        Assert.assertEquals(broadcastMessage.getHeaderTitle(),"Broadcast Message");
    }

    @Test(description = "TC001_Testing Administered Test Types")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-508")
    public void MFPA_508() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.validateDashboardPage();
        driver.get(TEST_DASHBOARD.getUrl()+ADMINISTERED_TEST_TYPES.getHref());
        broadcastMessage.validatePage();
        Assert.assertEquals(broadcastMessage.getHeaderTitle(),ADMINISTERED_TEST_TYPES.getTitle());
    }
    @Test(description = "TC001_Testing User Account Management")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-241")
    public void MFPA_241() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.validateDashboardPage();
        driver.get(TEST_DASHBOARD.getUrl()+USER_MANAGEMENT.getHref());
        broadcastMessage.validatePage();
        Assert.assertEquals(broadcastMessage.getHeaderTitle(),USER_MANAGEMENT.getTitle());
    }

    @AfterMethod
    public void afterMethodCleanup()
    {
        dashboard.clickLogout();
    }
    @AfterClass
    public void cleanup() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
