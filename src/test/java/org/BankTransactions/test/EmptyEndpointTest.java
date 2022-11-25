package org.BankTransactions.test;


import org.BankTransactions.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * the class to do the test
 */
public class EmptyEndpointTest extends BaseTest {
    /**
     * this test verifies if the endpoint is empty
     * @param endpoint
     */
    @Parameters({"endpoint"})
    @Test
    public void emptyEndpointTest(String endpoint) {
        Reporter.info("Verifying the endpoint is empty");
        Assert.assertTrue(verifyEmptyEndpoint(endpoint), "The endpoint is empty or all de clients were deleted");
    }
}
