package UI.Mobile;

import Base.BaseTest;
import Listeners.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class MFPTests extends BaseTest {

    @BeforeTest
    public void classSetup() {
        if (mobileDriver != null) {
            resetMobileApp();
        } else {
            mobileDriverSetup();
        }

    }


    @Test(description = "TC003_Android_MobileApp Onboarding Create an Account Log In New Account")
    @Description("To verify the ability to login using phone number and email")
    @TmsLink("MFPA-710")
    public void MFPA_710() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123@");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
        Assert.assertTrue(mobileMFPHome.validateHomePage());
    }

    @Test(description = "TC002_Android_MobileApp Onboarding Create an Account Log In New Account")
    @Description("To verify that the system will flag user if your account and/or password is invalid")
    @TmsLink("MFPA-709")
    public void MFPA_709() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
        mobileMFPLogin.validateErrorMessage();
    }

    @Test(description = "TC006_Android_MobileApp Onboarding Create an Account Input Email")
    @Description("To verify that the system will not accept expired/invalid verification code pin")
    @TmsLink("MFPA-703")
    public void MFPA_703() {
        Data.LogIn loginData = new Data.LogIn("+639176254815", "Password123");
        mobileMFPLogin.clickIAlreadyHaveAnAccount();
        mobileMFPLogin.performLogin(loginData);
        mobileMFPLogin.validateErrorMessage();
    }
    @Test(description = "TC001_Android_MobileApp Onboarding Create an Account Input Voucher")
    @Description("To verify the ability to input a valid voucher")
    @TmsLink("MFPA-687")
    public void MFPA_687() {
        mobileMFPLogin.clickGetStarted();
        mobileMFPLogin.setVoucherCode("devMFP");
        mobileMFPLogin.clickNext();
        mobileMFPLogin.clickNext();
        Assert.assertTrue(mobileMFPLogin.validateLetsStartWithPhoneNumberPage());
    }
    @Test(description = "TC002_Android_MobileApp Onboarding Create an Account Input Voucher")
    @Description("To verify the ability to flag user when voucher is invalid and expired")
    @TmsLink("MFPA-688")
    public void MFPA_688() {
        mobileMFPLogin.clickGetStarted();
        mobileMFPLogin.setVoucherCode("invalidVoucher");
        mobileMFPLogin.clickNext();
        Assert.assertTrue(mobileMFPLogin.validateInvalidVoucherCode());
    }

    @AfterMethod
    public void teardown() {
        resetMobileApp();
    }


    @AfterClass
    public void teardownAfterClass2() {
        //killAllNode();
    }
}
