package by.itacademy.moskalew.api;


import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReebokTestApi {
    String url = "https://www.reebok.com/graphql";
    String email = "fshdjgdj@gmail.com";
    String password = "11aaAA@@";
    String bodyAsString = "{\"query\":\"mutation userAuthenticate($email: String!, $password: String!, $keepMeLoggedIn: Boolean)" +
            " {\\n  userAuthenticate(\\n    email: $email\\n    password: $password\\n    keepMeLoggedIn: $keepMeLoggedIn\\n  )" +
            " {\\n    id\\n    email\\n    name {\\n      firstname\\n      lastname\\n      __typename\\n    }\\n    keepUserLoggedIn\\n    " +
            "code\\n    message\\n    legacyUser\\n    resetPasswordTrigger\\n    __typename\\n  }\\n}\",\"variables\"" +
            ":{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}}";

    @Test
    public void testLoginWithValidValues() {
        given().body(bodyAsString).header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));

    }

}
