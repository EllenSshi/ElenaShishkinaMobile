package pageActions;

import io.appium.java_client.AppiumDriver;

public class PageActions {

    NativePageActions nativePageActions;
    WebPageActions webPageActions;

    private final AppiumDriver appiumDriver;

    public PageActions(String appType, AppiumDriver appiumDriver) throws Exception {
        this.appiumDriver = appiumDriver;

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                webPageActions = new WebPageActions(appiumDriver);
                break;
            case "native":
                nativePageActions = new NativePageActions(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }

    public NativePageActions getNativePageActions() {
        return nativePageActions;
    }

    public WebPageActions getWebPageActions() {
        return webPageActions;
    }
}
