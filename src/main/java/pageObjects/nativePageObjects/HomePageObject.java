package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AbstractPageObject;

public class HomePageObject extends AbstractPageObject {

    @AndroidFindBy(id = packageName + "id/email_sign_in_button")
    private WebElement signInBtn;

    @AndroidFindBy(id = packageName + "id/register_button")
    private WebElement registerBtn;

    @AndroidFindBy(id = packageName + "id/login_email")
    private WebElement loginFld;

    @AndroidFindBy(id = packageName + "id/login_pwd")
    private WebElement passwordFld;

    public HomePageObject(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
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
