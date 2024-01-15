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
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomValidPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginInvalidEmail() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomInvalidEmail(), RandomUserData.getRandomValidPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }


    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutUpperCaseChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutLowerCaseChars() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutLowerCaseChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutDigits() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutDigits()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutSplChars() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomPasswordWithoutSplChars()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginInvalidLengthPassword() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), RandomUserData.getRandomInvalidLengthPassword()))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginWithEmptyValues() {
        given().log().all().body(BodyGenerator.getBody("", ""))
                .header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginEmailIsNull() {
        given().log().all().body(BodyGenerator.getBody(null, RandomUserData.getRandomValidPassword())).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of non-null type \"String!\" must not be null."));
    }

    @Test
    public void testLoginPasswordIsNull() {
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), null)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of non-null type \"String!\" must not be null."));
    }

    @Test
    public void testLoginEmailIsInt() {
        int email = RandomUserData.getRandomInt();
        given().log().all().body(BodyGenerator.getBody(email, RandomUserData.getRandomValidPassword())).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo(BodyGenerator.getExpectedResultEmail(email)));
    }

    @Test
    public void testLoginPasswordIsInt() {
        int password = RandomUserData.getRandomInt();
        given().log().all().body(BodyGenerator.getBody(RandomUserData.getRandomValidEmail(), password)).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo(BodyGenerator.getExpectedResultPassword(password)));
    }

    @Test
    public void testLoginUpperCaseInEmailKey() {
        given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                        " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                        " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                        "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                        ":{\"EMAIL\":\"" + RandomUserData.getRandomValidEmail() + "\",\"password\":\"" + RandomUserData.getRandomValidEmail() + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of required type \"String!\" was not provided."));
    }

    @Test
    public void testLoginUpperCaseInPasswordKey() {
                given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                                " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                                " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                                "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                                ":{\"email\":\"" + RandomUserData.getRandomValidEmail() + "\",\"PASSWORD\":\"" + RandomUserData.getRandomValidEmail() + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of required type \"String!\" was not provided."));
    }

}
