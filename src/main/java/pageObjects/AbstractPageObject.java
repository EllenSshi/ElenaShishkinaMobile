package pageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.IPageObject;
import setup.Property;

import java.awt.event.KeyEvent;

public abstract class AbstractPageObject implements IPageObject {

    private AppiumDriver appiumDriver;
    private String platformName;
    public final String packageName = "platkovsky.alexey.epamtestapp:";
    private final String webUrl = new Property().getDomain();
    public WebDriverWait wait;

    public AbstractPageObject(String platformName, AppiumDriver appiumDriver) throws Exception {
        this.platformName = platformName;
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 5);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    @Override
    public String getWelementText(WebElement webElement) {
        return webElement.getText();
    }

    @Override
    public void fillWithText(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    @Override
    public void click(WebElement webElement) {
        webElement.click();
    }

    @Override
    public void pressEnterKey(WebElement webElement) {
        if (platformName.equals("Android")) {
            webElement.sendKeys(Keys.ENTER); // works for Android
        }
        else {
            webElement.submit();
        }
    }

    @Override
    public void open() {
        appiumDriver.get(webUrl);
    }

}
