
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Rest_Get_Reference {

    public static void main(String[] args) {
        // Declare the base URL
        RestAssured.baseURI = "https://reqres.in/";

        // Send a GET request
        //Response response = RestAssured.get("api/users");

        // Extract the response body as a string
       // String responseBody = response.getBody().asString();

        // Declare given, when, and then methods
        given()
                .header("Content-Type", "application/json") .body("requestBody") .when().get("api/users?page=2").then().log().all().extract().asString();

        // Print the response body
       // System.out.println(responseBody);
      
    }
}