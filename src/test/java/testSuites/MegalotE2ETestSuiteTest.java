package testSuites;


import api.megalotRegBetTest.MegalotRegBetTest;
import drawingDraws.MegalotDrawInRegistrationCreationTest;
import drawingDraws.MegalotDrawingTest;
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
