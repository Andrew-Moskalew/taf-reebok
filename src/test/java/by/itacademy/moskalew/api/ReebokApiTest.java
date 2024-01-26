package by.itacademy.moskalew.api;


import by.itacademy.moskalew.domain.BodyGenerator;
import by.itacademy.moskalew.domain.RandomUserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReebokApiTest {
    String url = "https://www.reebok.com/graphql";
    private static final Logger logger = LogManager.getLogger();

    @Test
    public void testLoginValidValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginInvalidEmail() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomInvalidEmail(), RandomUserData.getRandomValidPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }


    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutUpperCaseChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutLowerCaseChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutLowerCaseChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutDigits() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutDigits()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordWithoutSplChars() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutSplChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginInvalidLengthPassword() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomInvalidLengthPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginWithEmptyValues() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody("", ""))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginEmailIsNull() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(null, RandomUserData.getRandomValidPassword())).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of non-null type \"String!\" must not be null."));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordIsNull() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), null)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of non-null type \"String!\" must not be null."));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginEmailIsInt() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int email = RandomUserData.getRandomIntEmail();
        given().body(BodyGenerator.getBody(email, RandomUserData.getRandomValidPassword())).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo(BodyGenerator.getExpectedResultIntEmail(email)));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginPasswordIsInt() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        int password = RandomUserData.getRandomIntPassword();
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), password)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo(BodyGenerator.getExpectedResultIntPassword(password)));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginUpperCaseInEmailKey() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBodyWithInvalidEmailKey()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of required type \"String!\" was not provided."));
        logger.info("Test passed \n");
    }

    @Test
    public void testLoginUpperCaseInPasswordKey() {
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        given().body(BodyGenerator.getBodyWithInvalidPasswordKey()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of required type \"String!\" was not provided."));
        logger.info("Test passed \n");
    }

    @Test
    public void testSearch() {
        String searchRequest = "Spyder x Reebok Zig Kinetica 2.5 Edge Shoes";
        logger.info("Started " + Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.info("search request is: " + searchRequest);
        given().body(BodyGenerator.getBodySearch(searchRequest)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("data.productSearch.results.newProductName[0]", equalTo(searchRequest));
        logger.info("Test passed \n");
    }

}
