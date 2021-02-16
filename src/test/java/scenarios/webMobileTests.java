package scenarios;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    /*@Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org"); // open IANA homepage

        // Make sure that page has been loaded completely
        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        // Check IANA homepage title
        assert ((WebDriver) getDriver()).getTitle().equals("Internet Assigned Numbers Authority") : "This is not IANA homepage";

        // Log that test finished
        System.out.println("Site opening done");
    }*/

    @DataProvider
    public Object[] webTestData() {
        return new Object[] {"EPAM"};
    }

    @Test(groups = {"web"}, description = "Make sure that we've opened IANA homepage", dataProvider = "webTestData")
    public void searchTextTest(String searchText) throws InterruptedException {
        pageActions().openGoogleSearchPage();
        pageActions().searchTextInGoogleSearch(searchText);
        assertion.assertTrue(pageActions().getSearchResultsCount() > 0);
    }
}
