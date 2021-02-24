package setup;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.Assertion;
import org.testng.annotations.*;
import pageActions.NativePageActions;
import pageActions.PageActions;
import pageActions.WebPageActions;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriver {

    private static AppiumDriver appiumDriver;
    static WebPageActions wpa;
    static NativePageActions npa;
    public static Assertion assertion = new Assertion();

    @Override
    public AppiumDriver getDriver() { return appiumDriver; }

    public NativePageActions nativePageActions() {
        return npa;
    }

    public WebPageActions webPageActions() {
        return wpa;
    }

    @Parameters({"platformName","appType","deviceName","browserName","app"})
    @BeforeSuite(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(platformName, deviceName, browserName, app);
        setPageActions(appType, appiumDriver);

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        System.out.println("After");
        appiumDriver.closeApp();
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName",deviceName);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        try {
            appiumDriver = new AppiumDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Timeouts tuning
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    private void setPageActions(String appType, AppiumDriver appiumDriver) throws Exception {
        switch (appType) {
            case "web":
                wpa = new PageActions(appType, appiumDriver).getWebPageActions();
                break;
            case "native":
                npa = new PageActions(appType, appiumDriver).getNativePageActions();
                break;
        }
    }
}
