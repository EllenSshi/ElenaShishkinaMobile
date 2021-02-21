package scenarios;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @DataProvider
    public Object[] webTestData() {
        return new Object[] {"EPAM"};
    }

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage", dataProvider = "webTestData")
    public void searchTextTest(String searchText) throws InterruptedException {
        webPageActions().openGoogleSearchPage();
        webPageActions().searchTextInGoogleSearch(searchText);
        assertion.assertTrue(webPageActions().getSearchResultsCount() > 0);
    }
}
