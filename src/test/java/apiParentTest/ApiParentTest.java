package apiParentTest;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import pages.EMLPurchaseMenuPage;
import pages.EMLPurchaseRegistrationPage;
import pages.LoginFormPage;
import pages.LotteriesPage;
import paramsForRequests.BOGetSID;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class ApiParentTest {

    protected Logger logger = Logger.getLogger(getClass());
    protected long timestamp = Instant.now().getEpochSecond();

    protected BOGetSID boGetSID = new BOGetSID();

}
