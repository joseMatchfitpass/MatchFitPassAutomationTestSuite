package Pages.Web.Dashboards;

import Pages.Base;
import Pages.Enums.TableHeaders;
import Pages.Enums.Tabs;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BroadcastMessage extends Base {
    public BroadcastMessage() {

    }

    @FindBy(xpath = "//*[@class='header__logo-icon']")
    public WebElement mfpHeaderLogoIcon;
    @FindBy(xpath = "//*[@class='header__logo-text']")
    public WebElement mfpHeaderLogoText;
    @FindBy(xpath = "//*[@class='page-header__title']")
    public WebElement mfpHeaderTitle;

    @Step("Validate BroadCast Message page if loaded")
    public void validatePage()
    {
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderLogoIcon));
        mfpHeaderLogoIcon.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderLogoText));
        mfpHeaderLogoText.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderTitle));
        mfpHeaderTitle.isDisplayed();

    }
    @Step("Get Header Title")
    public String getHeaderTitle()
    {
        return mfpHeaderTitle.getText();
    }

}
