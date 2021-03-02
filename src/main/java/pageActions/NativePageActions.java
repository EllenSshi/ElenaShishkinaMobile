package pageActions;

import io.appium.java_client.AppiumDriver;
import pageObjects.nativePageObjects.BudgetActivityPageObject;
import pageObjects.nativePageObjects.HomePageObject;
import pageObjects.nativePageObjects.RegistrationPageObject;

public class NativePageActions {

    public HomePageObject homePageObject;
    public RegistrationPageObject registrationPageObject;
    public BudgetActivityPageObject budgetActivityPageObject;

    private final AppiumDriver appiumDriver;


    public NativePageActions(String platformName, AppiumDriver appiumDriver) throws Exception {
        this.appiumDriver = appiumDriver;
        homePageObject = new HomePageObject(platformName, appiumDriver);
        registrationPageObject = new RegistrationPageObject(platformName, appiumDriver);
        budgetActivityPageObject = new BudgetActivityPageObject(platformName, appiumDriver);
    }

    public void logIn(String username, String password) {
        homePageObject.fillCreds(username, password);
        homePageObject.clickSignInBtn();
    }

    public void register(String email, String username, String password) {
        homePageObject.goToRegisterForm();
        registrationPageObject.fillRegistrationForm(email, username, password);
        registrationPageObject.clickRegisterBtn();
    }

    public String getPageTitle() {
        return budgetActivityPageObject.getBudgetPageTitle();
    }
}
