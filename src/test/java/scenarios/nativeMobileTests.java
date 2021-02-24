package scenarios;

import dto.NativeTestDataDto;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.NativeTestData;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This test registers a new account and then signs in",
            dataProvider = "nativeTestDataProvider", dataProviderClass = NativeTestData.class)
    public void registerAndSignInTest(Object testData) {
        NativeTestDataDto data = (NativeTestDataDto) testData;
        nativePageActions().register(data.getEmail(), data.getUsername(), data.getPassword());
        nativePageActions().logIn(data.getEmail(), data.getPassword());
        assertion.assertEquals(nativePageActions().getPageTitle(), data.getExpectedBudgetPageTitle());
    }

}
