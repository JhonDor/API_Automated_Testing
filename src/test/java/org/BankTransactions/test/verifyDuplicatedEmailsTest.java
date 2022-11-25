package org.BankTransactions.test;

import org.BankTransactions.reporting.Reporter;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



/**
 * the class to do the test
 */
public class verifyDuplicatedEmailsTest extends BaseTest{
    /**
     * this test verifies if there are any duplicate emails
     * @param endpoint
     */
    @Parameters({"endpoint"})
    @Test
    public void verifyDuplicatedEmailsTest(String endpoint) {
        Reporter.info("Verifying that there are not duplicated emails");
        Assert.assertTrue(verifyDuplicateEmails(endpoint), "There are no duplicated emails");
    }
}
