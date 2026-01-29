package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginAPI {

    public static String loginAndGetCookie() {

        RestAssured.baseURI = "http://localhost";

        Response response =
                given()
                        .contentType(ContentType.URLENC)
                        .formParam("username", "automationfc")
                        .formParam("password", "wrqYHGQvTSaUG9AR6&")
                        .when()
                        .post("/orangehrm/web/index.php/auth/validate")
                        .then()
                        .statusCode(302) // hoặc 200 tuỳ bản
                        .extract()
                        .response();

        // LẤY COOKIE ĐÚNG TÊN
        String sessionCookie = response.getCookie("_orangehrm");

        return sessionCookie;
    }
}
