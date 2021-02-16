package setup;

import pageObjects.AbstractPageObject;

public interface IPageActions {

    void logIn(String username, String password);

    void register(String email, String username, String password);

    String getPageTitle();

    void openGoogleSearchPage();

    void searchTextInGoogleSearch(String text);

    Integer getSearchResultsCount();
}
