package Base;

import Listeners.TestListener;
import Pages.Base;
import Pages.CreateAccount;
import Pages.Home;
import Pages.PersonalInformation;
import Pages.Web.Dashboards.BroadcastMessage;
import Pages.Web.Dashboards.Dashboard;
import Pages.Web.Dashboards.LogIn;
import Pages.Web.Dashboards.UserDetails;
import Pages.Web.VEntry.VEntry;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners({TestListener.class})
public class BaseTest extends Base {
    //public final String URL = "https://stage-admin.mfpstaging.technology/sign-in";
    // public final String URL = "https://admin-dashboard-stg.mfpstaging.technology/sign-in";


    protected WebDriver driver;
    protected AndroidDriver mobileDriver;


    public LogIn login;
    public Dashboard dashboard;
    public BroadcastMessage broadcastMessage;


    public UserDetails userDetails;


    public Pages.Mobile.MatchFitPass.LogIn mobileMFPLogin;
    public Pages.Mobile.MatchFitPass.Home mobileMFPHome;
    //////////////////
    public Properties props;
    public Properties webProps;

    public VEntry vEntry;

    public BaseTest() {
        props = new Properties();
        webProps = new Properties();
        try {
            props.load(BaseTest.class.getClassLoader().getResourceAsStream("mobile.properties"));
            webProps.load(BaseTest.class.getClassLoader().getResourceAsStream("web.properties"));

        } catch (Exception e) {
            System.out.println("error with properties file");
        }
        if (validateThereAreRunningEmulator()) {
            closeEmulator();
        }
        System.out.println("Profile ID:  " + webProps.getProperty("platform"));
    }


    public void webDriverSetup() {

        if (webProps.getProperty("platform").equals("Web")) {
            //closeEmulator();
            driver = getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            //webProps.getProperty("url"));

            Base.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            init();
        }
    }

    public void mobileDriverSetup() {
        if (props.getProperty("platform").equals("Mobile")) {
            startAppiumServer();
            executeCMDCommand("emulator @" + props.getProperty("avdName") + " -no-audio");
            sleep(35000);
            mobileDriver = getMobileDriver(props);
            int attempt = 0;
            do {
                if (mobileDriver == null) {
                    try {
                        System.out.println("Mobile Driver is null. retrying...");
                        Thread.sleep(90000);
                        mobileDriver = getMobileDriver(props);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                attempt++;
            } while (attempt <= 2 && mobileDriver == null);
            System.out.println(mobileDriver.getBatteryInfo());

            do {
                sleep(1000);
            }
            while (!mobileDriver.currentActivity().equals("com.matchfitpass.MainActivity"));
            mobileWait = new WebDriverWait(mobileDriver, Duration.ofSeconds(30));

            mobileMFPLogin = new Pages.Mobile.MatchFitPass.LogIn();
            mobileMFPHome = new Pages.Mobile.MatchFitPass.Home();
            PageFactory.initElements(mobileDriver, mobileMFPLogin);
            PageFactory.initElements(mobileDriver, mobileMFPHome);
            //resetMobileApp();
        }
    }

    public WebElement click() {
        return driver.findElement(By.xpath("//*[@text='I already have an account']"));
    }

    public void init() {
        login = new LogIn();
        dashboard = new Dashboard();
        userDetails = new UserDetails();
        broadcastMessage = new BroadcastMessage();
        broadcastMessage = new BroadcastMessage();
        vEntry = new VEntry();
        PageFactory.initElements(driver, login);
        PageFactory.initElements(driver, dashboard);
        PageFactory.initElements(driver, userDetails);
        PageFactory.initElements(driver, broadcastMessage);
        PageFactory.initElements(driver, vEntry);
    }

    public void resetMobileApp() {

        if (mobileDriver.currentActivity().equals("com.matchfitpass.MainActivity")) {
            mobileDriver.resetApp();
            do {
                sleep(1000);
            }
            while (!mobileDriver.currentActivity().equals("com.matchfitpass.MainActivity"));
        }
    }

}
