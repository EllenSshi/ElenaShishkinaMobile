package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AbstractPageObject;

import java.util.List;

public class GoogleSearchPageObject extends AbstractPageObject {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchFld;

    @FindBy(xpath = "//div[@id='rso']/div")
    private List<WebElement> searchResults;

    public GoogleSearchPageObject(AppiumDriver appiumDriver) throws Exception {
        super(appiumDriver);
        PageFactory.initElements(appiumDriver, this);
    }

    public void fillSearchFld(String text) {
        fillWithText(searchFld, text);
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
}
