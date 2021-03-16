package loginForm;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Elena Dovhaliuk
 */

@Epic("Login")
@Feature("Authorization")
@RunWith(Parameterized.class)

public class WrongLoginInputTest extends AbstractParentTest {

    private String loginValue;

    public WrongLoginInputTest(String login) {
        this.loginValue = login;
    }

    @Parameterized.Parameters(name = "Parameters are {0}")
    public static Collection loginData(){
        return Arrays.asList(new Object[][] {
                        {"27600005"},
                        {"7600004"},
                        {"!7600005"},
                        {" 7600005"},
                        {"07600005"},
                        {"a7600005"}
                }
        );
    }

    @Description("Wrong authorization")
    @Story("Authorization")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void loginOfOneOperAndPassOfAnotherOper(){
        loginPage.openPage();
        loginPage.fillInLoginInput(loginValue);
        loginPage.enterValidPassword();
        loginPage.clickVhidToSignIn();

        checkExpectedResult("!!! Login isn't suitable for such negative case",
                loginPage.isLoginOrPasswordIsInvalidPopUpVisible());

        loginPage.clickContinueButton();
        loginPage.checkCurrentUrl();
    }
}
