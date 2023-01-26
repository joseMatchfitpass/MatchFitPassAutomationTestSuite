package Pages;

import Helpers.UIHelper;
import Pages.Enums.StageURL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
    public static WebDriver driver;
    public static AndroidDriver mobileDriver;
    public static WebDriverWait wait;
    public static WebDriverWait mobileWait;
    StageURL url;
    public UIHelper uiHelper = new UIHelper();

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Documents\\AUTOMATION\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }

    public void startAppiumServer() {
        String WindowsApplicationDriverUrl = "/wd/hub/";
        killAllNode();
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

        serviceBuilder.usingPort(4723);
        AppiumDriverLocalService server = AppiumDriverLocalService
                .buildService(serviceBuilder)
                .withBasePath(WindowsApplicationDriverUrl);
        server.start();
    }

    public void executeCMDCommand(String command) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(new String[]{"cmd.exe", "/c", command});

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(proc.getInputStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println("DSDFSFSDSDFSDFDSSD" + s);
                if (s.contains("Advertising in:")) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Di PUMASOK");
        }

    }

    public AndroidDriver getMobileDriver(Properties props) {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", props.getProperty("osVersion"));
        caps.setCapability("deviceName", props.getProperty("avdName"));
        caps.setCapability("automationName", "uiautomator2");
        caps.setCapability("app", "C:\\Users\\Public\\Documents\\AUTOMATION\\MFP_Automation\\MFP_Automation\\src\\test\\resources\\apk\\app-v1.15.0.94-matchfit-stageRelease.apk");
        try {
            mobileDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
            System.out.println(mobileDriver.getStatus());
            return mobileDriver;
        } catch (Exception e) {
            //System.out.println("Fail");
            return null;
        }
    }

    public boolean validateThereAreRunningEmulator() {

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(new String[]{"cmd.exe", "/c", "adb shell dumpsys activity services com.android.service"});
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    proc.getErrorStream()));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("adb.exe: no devices/emulators found")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void closeEmulator() {
        System.out.println("Killing emulator...");

        String[] aCommand = new String[]{"taskkill", "/F", "/IM"
                , "qemu-system-x86_64.exe", "/T"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(10000, TimeUnit.SECONDS);
            //Thread.sleep(10000);
            System.out.println("Emulator closed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void killAllNode() {
        System.out.println("Killing emulator...");

        String[] aCommand = new String[]{"taskkill", "/F", "/IM"
                , "node.exe"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(10000, TimeUnit.SECONDS);
            Thread.sleep(10000);
            System.out.println("Emulator closed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {

        }

    }

    public static WebElement getElement(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public static void clickObject(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
    }

    public static void clickObject(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public static void clickObject_Mobile(WebElement webElement) {
        mobileWait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public static List<WebElement> getElements(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public String gettext(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void type(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(value);
    }

    public static Select getSelectElement(String locator) {
        return new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))));
    }

    public static boolean validateElementsIsDisplayed_mobile(WebElement webElement) {
        return mobileWait.until(ExpectedConditions.visibilityOf(webElement)).isDisplayed();
    }


    public static boolean validateElementIsDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean validateElementsIsDisplayed(WebElement[] webElements) {
        try {
            for (WebElement w : webElements) {
                w.isDisplayed();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Validate alert")
    public boolean isAlertPresent() {
        try {
            Thread.sleep(2000);
            driver.switchTo().alert();
            return true;
        }   // try
        catch (Exception e) {
            return false;
        }   // catch
    }   // isAlertPresent()

    @Step("Get alert text")
    public String getAlertText() {
        if (isAlertPresent()) {
            return driver.switchTo().alert().getText();
        }
        return null;
    }

    @Step("Close alert text")

    public void closeAlert() {
        if (isAlertPresent()) {
            driver.switchTo().alert().dismiss();
        }
    }

    @Attachment(value = " Screenshot", type = "image/png")
    public byte[] mobileSaveScreenshot() {
        return mobileDriver.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = " Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        if (isAlertPresent()) {
            try {
                BufferedImage bi = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bi, "png", baos);
                return baos.toByteArray();
                //return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            } catch (Exception e) {
            }
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
