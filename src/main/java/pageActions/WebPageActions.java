package pageActions;

import io.appium.java_client.AppiumDriver;
import pageObjects.webPageObjects.GoogleSearchPageObject;

public class WebPageActions {

    public GoogleSearchPageObject googleSearchPageObject;

    private final AppiumDriver appiumDriver;

    public WebPageActions(AppiumDriver appiumDriver) throws Exception {
        this.appiumDriver = appiumDriver;
        googleSearchPageObject = new GoogleSearchPageObject(appiumDriver);
    }

    public void openGoogleSearchPage() {
        googleSearchPageObject.open();
    }

    public void searchTextInGoogleSearch(String text) {
        googleSearchPageObject.fillSearchFld(text);
        googleSearchPageObject.pressEnterKey(googleSearchPageObject.searchFld);
    }

    public Integer getSearchResultsCount() {
        return googleSearchPageObject.getSearchResults().size();
    }
}
