package testSuites;


import api.megalotRegBetTest.MegalotRegBetTest;
import drawingDraws.MegalotDrawInRegistrationCreationTest;
import drawingDraws.MegalotDrawingTest;
import megalotTest.MegalotPositiveWinPayTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Elena Dovhaliuk
 * This suite has overall Megalot review:
 * creation new draw, purchase, drawing draw, win payment
 */

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
