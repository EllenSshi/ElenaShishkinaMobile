package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AbstractPageObject;

public class HomePageObject extends AbstractPageObject {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    @AndroidFindBy(id = packageName + "id/email_sign_in_button")
    private WebElement signInBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    @AndroidFindBy(id = packageName + "id/register_button")
    private WebElement registerBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    @AndroidFindBy(id = packageName + "id/login_email")
    private WebElement loginFld;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    @AndroidFindBy(id = packageName + "id/login_pwd")
    private WebElement passwordFld;

    public HomePageObject(String platformName, AppiumDriver appiumDriver) throws Exception {
        super(platformName, appiumDriver);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void fillCreds(String username, String password) {
        fillWithText(loginFld, username);
        fillWithText(passwordFld, password);
    }

    public void clickSignInBtn() {
        click(signInBtn);
    }

    public void clickRegisterBtn() {
        click(registerBtn);
    }

    public void goToRegisterForm() {
        this.click(registerBtn);
    }

}
