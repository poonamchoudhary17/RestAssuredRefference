
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
public class Rest_Delete_Reference {
	public static void main(String[]args) {
		//declare base URL
		RestAssured.baseURI="https://reqres.in/";
		//declare the response body
		given()
        .header("Content-Type", "application/json") .body("requestBody") .when().delete("api/users?page=2").then().extract().asString();
	}
}