package testSuites;

import api.boAuth2.BOAuth2GsAltWebPositiveTest;
import api.boGetClientListTest.BOGetClientListAsAltWebPositiveTest;
import api.boGetSidTest.BOGetSIDAsTermPositiveTest;
import api.boGetSidTest.BOGetSIDGsAltWebPositiveTest;
import api.resendAuth2Test.ResendAuth2Test;
import api.sendAuthCode.SendAuthCode;
import api.zabavaRegBetTest.ZabavaRegBetTest;
import autoLoto.AutoLotoTicketBuyTest;
import loginForm.PositiveAuthorizationTest;
import loginForm.WrongLoginInputTest;
import lotoZabavaTest.LotoZabavaTicketBuyTest;
import megalotTest.MegalotPositiveWinPayTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Elena Dovhaliuk
 * This is class which contains all necessary tests for regression in one run
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                BOAuth2GsAltWebPositiveTest.class,
                BOGetClientListAsAltWebPositiveTest.class,
                BOGetSIDAsTermPositiveTest.class,
                BOGetSIDGsAltWebPositiveTest.class,
                ResendAuth2Test.class,
                SendAuthCode.class,
                ZabavaRegBetTest.class,
                AutoLotoTicketBuyTest.class,
                PositiveAuthorizationTest.class,
                WrongLoginInputTest.class,
                LotoZabavaTicketBuyTest.class,
                MegalotPositiveWinPayTest.class
        }
)

public class RegressionTestSuiteTest {
}
