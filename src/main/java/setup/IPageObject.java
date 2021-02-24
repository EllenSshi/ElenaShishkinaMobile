package setup;

import org.openqa.selenium.WebElement;

public interface IPageObject {

    //WebElement getWelement(String weName) throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    String getWelementText(WebElement webElement);

    void fillWithText(WebElement webElement, String text);

    void click(WebElement webElement);

    void open();

    void pressEnterKey(WebElement webElement);

}
