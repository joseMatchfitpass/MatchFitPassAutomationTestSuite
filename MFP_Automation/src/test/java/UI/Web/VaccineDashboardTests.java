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
import static Pages.Enums.SideBarMenu.VIEW_VACCINE_BATCHES;
import static Pages.Enums.StageURL.HOST_DASHBOARD;
import static Pages.Enums.StageURL.VACCINE_DASHBOARD;

public class VaccineDashboardTests extends BaseTest {

    @BeforeMethod
    public void classSetup() {
        if (driver != null) {
            login.closeAlert();
        }
        else {
            webDriverSetup();
        }
        driver.get(VACCINE_DASHBOARD.getUrl());
    }

    @Test(description = "TC0001_Admin Vaccination View Vaccine Batches")
    @Description("To verify that header title is correct")
    @TmsLink("MFPA-550")
    public void MFPA_550() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(dashboard.getPageHeaderText(VIEW_VACCINE_BATCHES),VIEW_VACCINE_BATCHES.getTitle());
    }
    @Test(description = "TC001_Vaccine Login")
    @Description("To verify that the user can login successfully")
    @TmsLink("MFPA-437")
    public void MFPA_437() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        login.validateLoginPageObjects();
        login.performLogin(loginData);
        Assert.assertEquals(dashboard.getPageHeaderText(VIEW_VACCINE_BATCHES),VIEW_VACCINE_BATCHES.getTitle());
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
