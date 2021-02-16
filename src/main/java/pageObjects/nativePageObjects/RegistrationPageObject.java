package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AbstractPageObject;

public class RegistrationPageObject extends AbstractPageObject {

    @AndroidFindBy(id = packageName + "id/registration_email")
    private WebElement emailFld;

    @AndroidFindBy(id = packageName + "id/registration_username")
    private WebElement usernameFld;

    @AndroidFindBy(id = packageName + "id/registration_password")
    private WebElement passwordFld;

    @AndroidFindBy(id = packageName + "id/registration_confirm_password")
    private WebElement confirmPswdFld;

    @AndroidFindBy(id = packageName + "id/register_new_account_button")
    private WebElement registerBtn;

    @AndroidFindBy(id = packageName + "id/registration_cancel_button")
    private WebElement cancelBtn;

    public RegistrationPageObject(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void fillRegistrationForm(String email, String username, String password) {
        fillWithText(emailFld, email);
        fillWithText(usernameFld, username);
        fillWithText(passwordFld, password);
        fillWithText(confirmPswdFld, password);
    }

    public void clickRegisterBtn() {
        click(registerBtn);
    }

    public void clickCancelBtn() {
        click(cancelBtn);
    }
}
