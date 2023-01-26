package UI;

import Base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;

public class UITest extends BaseTest {

    //  @BeforeMethod
    public void driverSetup() {
        if (mobileDriver != null) {
            resetMobileApp();
        }
        if (driver != null) {
            login.closeAlert();
        }

    }

    // @Test(description = "TC0002_Website Login")
    @Description("TC0002_Website Login")
    public void MFPA_776() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
        Assert.assertTrue(mobileMFPHome.validateHomePage());
    }

    //  @Test(description = "TC0001_Website Login")
    @Description("TC0001_Website Login")
    public void MFPA_777() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
        Assert.assertTrue(mobileMFPHome.validateHomePage());
    }

    //  @AfterTest
    public void teardown() {
        login.closeAlert();
        driver.close();
        driver.quit();
        if (mobileDriver != null) {
            mobileDriver.close();
            mobileDriver.quit();
        }
    }
}
