package org.BankTransactions.test;

import org.BankTransactions.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * the class to do the test
 */
public class InitializePojoTest extends BaseTest {
    /**
     * creates clients after verifying there are no duplicated emails and verifies the creating was successful
     * @param endpoint
     */
    @Parameters({"endpoint"})
    @Test
    public void initializePojoTest(String endpoint) {
        Reporter.info("Initializing the POJO");
        Assert.assertTrue(createClients(endpoint), "Clients created");
    }
}
