package org.BankTransactions.test;

import org.BankTransactions.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * the class to do the test
 */
public class UpdateAccountNumberTest extends BaseTest{
    /**
     * this test updates the account number of a client
     * @param endpoint the endpoint to do the PUT request
     *
     */

    @Parameters({"endpoint"})
    @Test
    public void verifyUpdateAccountNumberTest(String endpoint)  {
        Reporter.info("Starting update client test");
        Assert.assertEquals(updateAccountNumber(endpoint), 200, "The account number was updated");

    }
}
