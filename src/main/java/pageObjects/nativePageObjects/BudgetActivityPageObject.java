package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.AbstractPageObject;

public class BudgetActivityPageObject extends AbstractPageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Budget']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/" +
            "android.view.ViewGroup/android.widget.TextView")
    WebElement budgetPageTitle;

    public BudgetActivityPageObject(String platformName, AppiumDriver appiumDriver) throws Exception {
        super(platformName, appiumDriver);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public String getBudgetPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(budgetPageTitle));
        return getWelementText(budgetPageTitle);
    }
}
