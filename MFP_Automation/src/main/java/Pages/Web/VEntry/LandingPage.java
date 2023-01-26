package Pages.Web.VEntry;

import Pages.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends Base {
    public LandingPage() {
    }

    @FindBy(xpath = "//*[@alt='Verified Entry']")
    public WebElement logo; //expected text: Welcome to Match Fit Pass
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
    public void validateLandingPageObjects() {
        WebElement[] webElements =
                new WebElement[]{logo};
        for (WebElement w : webElements) {
             w.isDisplayed();
        }
    }


}
