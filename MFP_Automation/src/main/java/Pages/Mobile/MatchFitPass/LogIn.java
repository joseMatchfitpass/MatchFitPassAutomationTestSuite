package Pages.Mobile.MatchFitPass;

import Pages.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogIn extends Base {

    public LogIn() {
    }

    @FindBy(xpath = "//*[@text='Get Started']")
    public WebElement getStarted;
    @FindBy(xpath = "//*[@text='I already have an account']")
    public WebElement iAlreadyHaveAnAccount;
    @FindBy(xpath = "//*[@text='Phone number or email ']")
    public WebElement username;
    @FindBy(xpath = "//android.widget.EditText[@text='Password']")
    public WebElement password;
    @FindBy(xpath = "(//android.view.ViewGroup)[25]")
    public WebElement signIn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Wrong password or email')]")
    public WebElement wrongEmailOrPassword;
    @FindBy(xpath = "//android.widget.EditText[@index='1']")
    public WebElement voucherCodeInput;
    @FindBy(xpath = "//android.widget.TextView[@text='Next']")
    public WebElement nextButton;
    @FindBy(xpath = "//android.widget.TextView[@text='Let''s start with your phone number']")
    public WebElement letsStartWithYourPhoneNumberLabel;
    @FindBy(xpath = "//*[@text='Wrong user code']")
    public WebElement wrongUserCode;
    @Step("Click I Already Have An Account")
    public void clickIAlreadyHaveAnAccount()
    {
        clickObject_Mobile(iAlreadyHaveAnAccount);
    }
    @Step("Click Get Started")
    public void clickGetStarted()
    {
        clickObject_Mobile(getStarted);
    }
    @Step("Perform Login")
    public void performLogin(Data.LogIn loginData)
    {
        sleep(1000);
        username.sendKeys(loginData.getUserName());
        password.click();
        password.sendKeys(loginData.getPassword());
        sleep(1000);
        signIn.click();
    }
    @Step("Set Voucher Code")
    public void setVoucherCode(String voucherCode)
    {
        mobileWait.until(ExpectedConditions.elementToBeClickable(voucherCodeInput)).sendKeys(voucherCode);
    }

    @Step("Click Next")
    public void clickNext()
    {
        mobileDriver.hideKeyboard();
        clickObject_Mobile(nextButton);
    }
    @Step("Validate Lets Start With Phone Number Page")
    public boolean validateLetsStartWithPhoneNumberPage()
    {
        return validateElementsIsDisplayed_mobile(letsStartWithYourPhoneNumberLabel);
    }
    @Step("Validate Wrong Email or Password")
    public boolean validateErrorMessage()
    {
        return validateElementsIsDisplayed_mobile(wrongEmailOrPassword);
    }

    @Step("Validate wrong user code")
    public boolean validateInvalidVoucherCode()
    {
        return validateElementsIsDisplayed_mobile(wrongUserCode);
    }



}
