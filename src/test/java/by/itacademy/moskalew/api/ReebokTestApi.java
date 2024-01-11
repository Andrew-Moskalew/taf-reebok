package by.itacademy.moskalew.api;


import by.itacademy.moskalew.domain.RandomUserData;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReebokTestApi {
    String url = "https://www.reebok.com/graphql";

    @Test
    public void testLoginWithValidValues() {
        given().log().all().body(RandomUserData.getBodyWithRandomValidValuesAPI()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

    @Test
    public void testLoginPasswordWithoutUpperCaseChars() {
        given().log().all().body(RandomUserData.getBodyPasswordWithoutUpperCaseChars()).
                header("Content-Type", "application/json")
                .when().post(url)
                .then()
                .statusCode(200).body("errors.message[0]", equalTo("Incorrect email/password – please check and retry"));
    }

}
