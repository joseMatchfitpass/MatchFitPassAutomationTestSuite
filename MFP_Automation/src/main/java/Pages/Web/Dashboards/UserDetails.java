package Pages.Web.Dashboards;

import Pages.Base;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserDetails extends Base {
    public UserDetails() {
    }

    @FindBy(xpath = "//*[@class='header__logo-icon']")
    public WebElement mfpHeaderLogoIcon;
    @Step("Validate dashboard page if loaded")
    public void validateDashboardPage()
    {
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderLogoIcon));
        mfpHeaderLogoIcon.isDisplayed();
        //wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderLogoText));
        //mfpHeaderLogoText.isDisplayed();
    }
}
