package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.IPageObject;
import setup.Property;

public abstract class AbstractPageObject implements IPageObject {

    /*Object somePageObject; // it should be set of web page or EPAM Test App WebElements
    //Object somePageActions;*/

    private AppiumDriver appiumDriver;
    public final String packageName = "platkovsky.alexey.epamtestapp:";
    private final String webUrl = new Property().getDomain();
    public WebDriverWait wait;

    public AbstractPageObject(AppiumDriver appiumDriver) throws Exception {
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, 5);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    /*@Override
    public WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException {
        // use reflection technique
        Field field = somePageObject.getClass().getDeclaredField(weName);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);

    }*/

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
    public void pressEnterKey() {
        appiumDriver.getKeyboard().pressKey("\n");
    }

    @Override
    public void open() {
        appiumDriver.get(webUrl);
    }

}
