package UI.Web;

import Base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Pages.Enums.SideBarMenu.*;
import static Pages.Enums.StageURL.TEST_DASHBOARD;
import static Pages.Enums.StageURL.V_ENTRY;

public class VEntryTests extends BaseTest {

    @BeforeMethod
    public void classSetup() {
        if (driver != null) {
            login.closeAlert();
        }
        else {
            webDriverSetup();
        }
        driver.get(V_ENTRY.getUrl());
    }

    @Test(description = "TC0001_Website_V-Entry Home Nav")
    @Description("To verify the ability to load home page")
    @TmsLink("MFPA-1658")
    public void MFPA_1658() {
        vEntry.landingPage.validateLandingPageObjects();
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
