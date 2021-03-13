package testSuites;

import api.boAuth2.BOAuth2GsAltWebPositiveTest;
import api.boGetClientListTest.BOGetClientListAsAltWebPositiveTest;
import api.boGetSidTest.BOGetSIDAsTermPositiveTest;
import api.boGetSidTest.BOGetSIDGsAltWebPositiveTest;
import api.megalotRegBetTest.MegalotRegBetTest;
import api.resendAuth2Test.ResendAuth2Test;
import api.sendAuthCode.SendAuthCode;
import api.zabavaRegBetTest.ZabavaRegBetTest;
import autoLoto.AutoLotoTicketBuyTest;
import drawingDraws.MegalotDrawInRegistrationCreationTest;
import drawingDraws.MegalotDrawingTest;
import loginForm.PositiveAuthorizationTest;
import loginForm.WrongLoginInputTest;
import lotoZabavaTest.LotoZabavaTicketBuyTest;
import megalotTest.MegalotPositiveWinPayTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                MegalotDrawInRegistrationCreationTest.class,
                MegalotRegBetTest.class,
                MegalotDrawingTest.class,
                MegalotPositiveWinPayTest.class
        }
)

public class MegalotE2ETestSuiteTest {
}
