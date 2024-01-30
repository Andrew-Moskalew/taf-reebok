package by.itacademy.moskalew.api;


import by.itacademy.moskalew.domain.BodyGenerator;
import by.itacademy.moskalew.domain.RandomUserData;
import by.itacademy.moskalew.pages.ReebokApiPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReebokApiTest {
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testLoginValidValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginInvalidEmail() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomInvalidEmail(), RandomUserData.getRandomValidPassword()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }


    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutUpperCaseChars()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutLowerCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutLowerCaseChars()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutDigits() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutDigits()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutSplChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutSplChars()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginInvalidLengthPassword() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomInvalidLengthPassword()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginWithEmptyValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody("", ""))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageIncorretValues()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginEmailIsNull() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(null, RandomUserData.getRandomValidPassword()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageEmailNull()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordIsNull() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), null))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessagePasswordNull()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginEmailIsInt() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int email = RandomUserData.getRandomIntEmail();
        given().body(BodyGenerator.getBody(email, RandomUserData.getRandomValidPassword()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getExpectedResultIntEmail(email)));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordIsInt() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int password = RandomUserData.getRandomIntPassword();
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), password))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getExpectedResultIntPassword(password)));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginUpperCaseInEmailKey() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBodyWithInvalidEmailKey())
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessageEmailKeyInvalid()));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginUpperCaseInPasswordKey() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBodyWithInvalidPasswordKey())
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("errors.message[0]", equalTo(ReebokApiPage.getErrorMessagePasswordKeyInvalid()));
        logger.info("Test passed \n");
    }

    @Test
    public void testSearch() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("Search request is: " + ReebokApiPage.getSearchRequest());
        given().body(BodyGenerator.getBodySearch(ReebokApiPage.getSearchRequest()))
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().statusCode(200).body("data.productSearch.results.newProductName[0]", equalTo(ReebokApiPage.getSearchRequest()));
        logger.info("Expected search response message is: " + ReebokApiPage.getSearchRequest());
        logger.info("Test passed \n");
    }

}
