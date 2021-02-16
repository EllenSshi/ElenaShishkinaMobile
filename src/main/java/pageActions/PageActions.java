package pageActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import pageObjects.nativePageObjects.BudgetActivityPageObject;
import pageObjects.nativePageObjects.HomePageObject;
import pageObjects.nativePageObjects.RegistrationPageObject;
import pageObjects.webPageObjects.GoogleSearchPageObject;
import setup.IPageActions;

public class PageActions implements IPageActions {

    public HomePageObject homePageObject;
    public RegistrationPageObject registrationPageObject;
    public BudgetActivityPageObject budgetActivityPageObject;

    public GoogleSearchPageObject googleSearchPageObject;

    private final AppiumDriver appiumDriver;

    public PageActions(String appType, AppiumDriver appiumDriver) throws Exception {
        this.appiumDriver = appiumDriver;

        System.out.println("Current app type: "+appType);
        switch(appType){
            case "web":
                googleSearchPageObject = new GoogleSearchPageObject(appiumDriver);
                break;
            case "native":
                homePageObject = new HomePageObject(appiumDriver);
                registrationPageObject = new RegistrationPageObject(appiumDriver);
                budgetActivityPageObject = new BudgetActivityPageObject(appiumDriver);
                break;
            default: throw new Exception("Can't create a page object for "+appType);
        }

    }

    @Override
    public void logIn(String username, String password) {
        homePageObject.fillCreds(username, password);
        homePageObject.clickSignInBtn();
    }

    @Override
    public void register(String email, String username, String password) {
        homePageObject.goToRegisterForm();
        registrationPageObject.fillRegistrationForm(email, username, password);
        registrationPageObject.clickRegisterBtn();
    }

    @Override
    public String getPageTitle() {
        return budgetActivityPageObject.getBudgetPageTitle();
    }

    @Override
    public void openGoogleSearchPage() {
        googleSearchPageObject.open();
    }

    @Override
    public void searchTextInGoogleSearch(String text) {
        googleSearchPageObject.fillSearchFld(text);
        googleSearchPageObject.pressEnterKey();
    }

    @Override
    public Integer getSearchResultsCount() {
        return googleSearchPageObject.getSearchResults().size();
    }
}
