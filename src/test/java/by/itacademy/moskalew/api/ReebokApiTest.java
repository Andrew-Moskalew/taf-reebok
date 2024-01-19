package by.itacademy.moskalew.api;


import by.itacademy.moskalew.domain.BodyGenerator;
import by.itacademy.moskalew.domain.RandomUserData;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReebokApiTest {
    String url = "https://www.reebok.com/graphql";

    @Test
    public void testLoginValidValues() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginInvalidEmail() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomInvalidEmail(), RandomUserData.getRandomValidPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }


    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutUpperCaseChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutLowerCaseChars() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutLowerCaseChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutDigits() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutDigits()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutSplChars() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutSplChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginInvalidLengthPassword() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomInvalidLengthPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginWithEmptyValues() {
        given().body(BodyGenerator.getBody("", ""))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginEmailIsNull() {
        given().body(BodyGenerator.getBody(null, RandomUserData.getRandomValidPassword())).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of non-null type \"String!\" must not be null."));
    }

    @Test
    public void testLoginPasswordIsNull() {
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), null)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of non-null type \"String!\" must not be null."));
    }

    @Test
    public void testLoginEmailIsInt() {
        int email = RandomUserData.getRandomInt();
        given().body(BodyGenerator.getBody(email, RandomUserData.getRandomValidPassword())).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo(BodyGenerator.getExpectedResultEmail(email)));
    }

    @Test
    public void testLoginPasswordIsInt() {
        int password = RandomUserData.getRandomInt();
        given().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), password)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo(BodyGenerator.getExpectedResultPassword(password)));
    }

    @Test
    public void testLoginUpperCaseInEmailKey() {
        given().body(BodyGenerator.getBodyWithInvalidEmailKey()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of required type \"String!\" was not provided."));
    }

    @Test
    public void testLoginUpperCaseInPasswordKey() {
        given().body(BodyGenerator.getBodyWithInvalidPasswordKey()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of required type \"String!\" was not provided."));
    }

}
