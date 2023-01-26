package Pages.Web.Dashboards;

import Pages.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogIn extends Base {
    public LogIn() {
    }

    @FindBy(xpath = "//div[@class='form-card__title title h3']")
    public WebElement mfpLogo; //expected text: Welcome to Match Fit Pass
    @FindBy(xpath = "//*[@class='sign-in__subtitle']")  //Please log in with your email address or phone number
    public WebElement formText;
    @FindBy(xpath = "//*[@name='login']")      //placeholder="Email address / phone number..."
    public WebElement username;
    @FindBy(xpath = "//*[@name='password']")      //placeholder="Email address / phone number..."
    public WebElement password;
    @FindBy(xpath = "//*[@class='input__password-btn']")
    public WebElement showPassword;
    @FindBy(xpath = "//*[@type='submit']")      //placeholder="Email address / phone number..."
    public WebElement continueButton;
    @FindBy(xpath = "//*[@class='sign-in__forget']")      //placeholder="Email address / phone number..."
    public WebElement forgetPassword;
    //Help link
    @FindBy(xpath = "//*[@href='/reset-password']")      //placeholder="Email address / phone number..."
    public WebElement helpLink;

    @FindBy(xpath = "//*[@name='auth_code']")
    public WebElement authCode;
    @FindBy(xpath = "//button[p[text()='Continue']]")
    public WebElement otpContinueButton;

    @Step("Validate Log in Page objects")
    public void validateLoginPageObjects() {
        WebElement[] webElements =
                new WebElement[]{mfpLogo, username, password, continueButton};
        for (WebElement w : webElements) {
             w.isDisplayed();
        }
    }

    @Step("Perform Login")
    public void performLogin(Data.LogIn loginData)
    {
        username.clear();
        username.sendKeys(loginData.getUserName());
        password.clear();
        password.sendKeys(loginData.getPassword());
        clickObject(showPassword);
        continueButton.click();
    }
    @Step("Validate Show Password")
    public void validateShowPassword(Data.LogIn loginData)
    {
        username.clear();
        username.sendKeys(loginData.getUserName());
        password.clear();
        password.sendKeys(loginData.getPassword());
        clickObject(showPassword);
        password.getText().equals(loginData.getPassword());
    }

    @Step("Set Auth Code")
    public void setAuthCode()
    {
        wait.until(ExpectedConditions.visibilityOf(authCode));
        authCode.sendKeys("141175");
    }

    @Step("Set Auth Code")
    public void setAuthCode(String code)
    {
        wait.until(ExpectedConditions.visibilityOf(authCode));
        authCode.sendKeys(code);
    }


    @Step("Click OTP page continue button")
    public void clickOtpContinueButton()
    {
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(authCode));
        otpContinueButton.click();
    }
    public boolean checkError()
    {
        return isAlertPresent();
    }


}
