package Pages.Web.Dashboards;

import Pages.Base;
import Pages.Enums.SideBarMenu;
import Pages.Enums.TableHeaders;
import Pages.Enums.Tabs;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard extends Base {
    public Dashboard() {
    }

    @FindBy(xpath = "//*[@class='header__logo-icon']")
    public WebElement mfpHeaderLogoIcon;
    @FindBy(xpath = "//*[@class='header__logo-text']")
    public WebElement mfpHeaderLogoText;
    @FindBy(xpath = "//*[@class='sign-in__subtitle']")  //Please log in with your email address or phone number
    public WebElement formText;
    @FindBy(xpath = "//*[@name='login']")      //placeholder="Email address / phone number..."
    public WebElement username;
    @FindBy(xpath = "//*[@name='password']")      //placeholder="Email address / phone number..."
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")      //placeholder="Email address / phone number..."
    public WebElement continueButton;
    @FindBy(xpath = "//*[@class='sign-in__forget']")      //placeholder="Email address / phone number..."
    public WebElement forgetPassword;
    //Help link
    @FindBy(xpath = "//*[@href='/reset-password']")      //placeholder="Email address / phone number..."
    public WebElement helpLink;
    @FindBy(xpath = "//p[text()='Update User Detail']")
    public WebElement updateUserDetail;
    @FindBy(xpath = "//div[text()='Logout']")
    public WebElement logout;

    @FindBy(xpath = "//div[@class='input input--search']//input")
    public WebElement searchField;

    @Step("Validate dashboard page if loaded")
    public void validateDashboardPage() {
        sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderLogoIcon));
        mfpHeaderLogoIcon.isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(mfpHeaderLogoText));
        mfpHeaderLogoText.isDisplayed();
    }

    @Step("Perform search user")
    public void searchUser(String user) {

        clickObject(searchField);
        sleep(1000);
        new Actions(driver)
                .sendKeys(user)
                .perform();
    }

    @Step("Click View Details of first result")
    public void clickViewDetails() {
        getElement("//tr[td[contains(text(),'jose')]]/td[a]/a").click();
    }

    @Step("Click update user detail")
    public void clickUpdateUserDetail() {
        clickObject(updateUserDetail);
    }

    @FindBy(xpath = "//p[text()='Save changes']")
    public WebElement saveChanges;
    @FindBy(xpath = "//input[@name='user.first_name']")
    public WebElement updateUserDetail_username;


    @Step("Click save changes")
    public void clickSaveChanges() {
        clickObject(saveChanges);
    }

    @Step("Click logout")
    public void clickLogout() {
        if (validateElementIsDisplayed(logout)) {
            clickObject(logout);
        }
    }

    public boolean checkError() {
        return isAlertPresent();
    }

    @Step("Get Table Value")

    public String getTableValue(TableHeaders tableHeaders, int row) {
        return uiHelper.getCellValue(tableHeaders, row);
    }

    @Step("Click tab")
    public void clickTab(Tabs tab) {
        clickObject("//a[contains(@class,'page-header__section-btn')][@href='" + tab.getHref() + "']");
    }

    @Step("Click Nav Menu")
    public void clickNavMenu(SideBarMenu sideBarMenu) {
        clickObject(sideBarMenu.getNavMenuXpath());
    }

    @Step("Get Page header")
    public String getPageHeaderText(SideBarMenu sideBarMenu) {
        return getElement(sideBarMenu.getHeaderXpath()).getText();
    }

    @Step("Get row count")
    public int getRowCount() {
        return getElements("//tbody/tr").size();
    }

    @Step("Click view details of row")
    public void clickRowViewDetails(int row) {
        clickObject("//tr[" + row + "]/td[a[text()='View details']]/a");
    }
}
