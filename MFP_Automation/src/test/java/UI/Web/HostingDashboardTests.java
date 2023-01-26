package UI.Web;

import Base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.Enums.SideBarMenu.TRACKING;
import static Pages.Enums.StageURL.HOST_DASHBOARD;

public class HostingDashboardTests extends BaseTest {

    @BeforeMethod
    public void classSetup() {
        if (driver != null) {
            login.closeAlert();
        } else {
            webDriverSetup();
        }
        driver.get(HOST_DASHBOARD.getUrl());
    }

    @Test(description = "TC001_Host Login")
    @Description("To verify that the user can login successfully")
    @TmsLink("MFPA-573")
    public void MFPA_573() {
        login.validateLoginPageObjects();
    }


    @Test(description = "TC002_Host Tickets")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-570")
    public void MFPA_570() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        dashboard.clickNavMenu(TRACKING);
        Assert.assertEquals(dashboard.getPageHeaderText(TRACKING), TRACKING.getTitle());
    }

    @AfterMethod
    public void afterMethodCleanup() {
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
