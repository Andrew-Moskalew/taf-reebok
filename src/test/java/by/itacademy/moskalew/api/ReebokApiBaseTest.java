package by.itacademy.moskalew.api;

import by.itacademy.moskalew.pages.ReebokApiPage;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ReebokApiBaseTest {
    public static JsonPath getJsonPath(String body) {
        JsonPath jsonPath = given().body(body)
                .contentType(ReebokApiPage.getContentType())
                .when().post(ReebokApiPage.getUrl())
                .then().extract().response().jsonPath();
        return jsonPath;
    }
}
