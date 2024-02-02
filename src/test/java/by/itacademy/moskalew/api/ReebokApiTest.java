package by.itacademy.moskalew.api;


import by.itacademy.moskalew.domain.BodyGenerator;
import by.itacademy.moskalew.domain.RandomUserData;
import by.itacademy.moskalew.pages.ReebokApiPage;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ReebokApiTest extends ReebokApiBaseTest{
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testLoginValidValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginInvalidEmail() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomInvalidEmail(), RandomUserData.getRandomValidPassword()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }


    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutUpperCaseChars()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutLowerCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutLowerCaseChars()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutDigits() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutDigits()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutSplChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutSplChars()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginInvalidLengthPassword() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomInvalidLengthPassword()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginWithEmptyValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody("", ""));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageIncorretValues(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginEmailIsNull() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(null, RandomUserData.getRandomValidPassword()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageEmailNull(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordIsNull() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), null));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessagePasswordNull(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginEmailIsInt() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int email = RandomUserData.getRandomIntEmail();
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBody(email, RandomUserData.getRandomValidPassword()));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getExpectedResultIntEmail(email), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordIsInt() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int password = RandomUserData.getRandomIntPassword();
        JsonPath jsonPath =getJsonPath(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), password));
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getExpectedResultIntPassword(password), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginUpperCaseInEmailKey() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBodyWithInvalidEmailKey());
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessageEmailKeyInvalid(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginUpperCaseInPasswordKey() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBodyWithInvalidPasswordKey());
        String actualResult = jsonPath.getString("errors.message[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getErrorMessagePasswordKeyInvalid(), actualResult);
        logger.info("Test passed \n");
    }

    @Test
    public void testSearch() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Search request is: " + ReebokApiPage.getSearchRequest());
        JsonPath jsonPath = getJsonPath(BodyGenerator.getBodySearch(ReebokApiPage.getSearchRequest()));
        String actualResult = jsonPath.getString("data.productSearch.results.newProductName[0]");
        logger.info("Actual error message is: " + actualResult);
        assertEquals(ReebokApiPage.getSearchRequest(), actualResult);
        logger.info("Expected search response message is: " + ReebokApiPage.getSearchRequest());
        logger.info("Test passed \n");
    }

}
