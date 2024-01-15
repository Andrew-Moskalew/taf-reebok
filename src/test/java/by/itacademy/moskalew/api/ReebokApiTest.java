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
        given().log().all().body(BodyGenerator.getBodyWithValidValues()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginInvalidEmail() {
        given().log().all().body(BodyGenerator.getBodyWithInvalidEmail()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }


    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        given().log().all().body(BodyGenerator.getBodyPasswordWithoutUpperCaseChars()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutLowerCaseChars() {
        given().log().all().body(BodyGenerator.getBodyPasswordWithoutLowerCaseChars()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutDigits() {
        given().log().all().body(BodyGenerator.getBodyPasswordWithoutDigits()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutSplChars() {
        given().log().all().body(BodyGenerator.getBodyPasswordWithoutSplChars()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginInvalidLengthPassword() {
        given().log().all().body(BodyGenerator.getBodyInvalidLengthPassword()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginWithoutValues() {
        String email = "";
        String password = "";
        given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                        " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                        " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                        "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                        ":{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginEmailIsNull() {

        String password = "";
        given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                        " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                        " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                        "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                        ":{\"email\":null,\"password\":\"" + password + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of non-null type \"String!\" must not be null."));
    }

    @Test
    public void testLoginEmailIsInt() {
        int email = 123;
        String password = "";
        given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                        " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                        " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                        "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                        ":{\"email\":123,\"password\":\"" + password + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" got invalid value 123; Expected type String. String cannot represent a non string value: 123"));
    }

    @Test
    public void testLoginUpperCaseInEmailKey() {
        String email = "";
        String password = "";
        given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                        " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                        " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                        "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                        ":{\"Email\":\"" + email + "\",\"password\":\"" + password + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$email\" of required type \"String!\" was not provided."));
    }

    @Test
    public void testLoginUpperCaseInPasswordKey() {
        String email = "";
        String password = "";
        given().log().all().body("{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
                        " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
                        " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
                        "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
                        ":{\"email\":\"" + email + "\",\"Password\":\"" + password + "\"}}").
                header("Content-Type", "application/json")
                .when().post(url)
                .then().log().all()
                .statusCode(200).body("errors.message[0]", equalTo("Variable \"$password\" of required type \"String!\" was not provided."));
    }

}
