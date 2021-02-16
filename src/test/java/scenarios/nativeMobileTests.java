package scenarios;

import dto.NativeTestDataDto;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.NativeTestData;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This test registers a new account and then signs in",
            dataProvider = "nativeTestDataProvider", dataProviderClass = NativeTestData.class)
    public void registerAndSignInTest(Object testData) throws InterruptedException {
        NativeTestDataDto data = (NativeTestDataDto) testData;
        pageActions().register(data.getEmail(), data.getUsername(), data.getPassword());
        pageActions().logIn(data.getEmail(), data.getPassword());
        assertion.assertEquals(pageActions().getPageTitle(), data.getExpectedBudgetPageTitle());
    }

}
