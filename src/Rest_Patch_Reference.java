
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;



    public class Rest_Patch_Reference {

    public static void main(String[] args) {

        // Declare the base URL

        RestAssured.baseURI = "https://reqres.in/";

        // Declare the request body string variable

        String RequestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";

        // Declare the expected results

        JsonPath JspRequest = new JsonPath(RequestBody);

        String Req_name = JspRequest.getString("name");

        String Req_job = JspRequest.getString("job");

        LocalDateTime currentdate = LocalDateTime.now();

        String expecteddate = currentdate.toString().substring(0, 11);

        // Perform the PUT request

        String ResponseBody = given() .header("Content-Type", "application/json") .body(RequestBody) .when() .patch("api/users/2") .then().log().all() .extract() .response() .asString();



        // Create an object of JSON path to parse the response body

        JsonPath JspResponse = new JsonPath(ResponseBody);

        String Res_name = JspResponse.getString("name");

        String Res_job = JspResponse.getString("job");

        String Res_updateddAt = JspResponse.getString("updatedAt");

        Res_updateddAt = Res_updateddAt.substring(0, 11);



        // Validate the ResponseBody parameters

        Assert.assertEquals(Res_name, Req_name);

        Assert.assertEquals(Res_job, Req_job);

        Assert.assertEquals(Res_updateddAt, expecteddate);
        
        System.out.println(ResponseBody);

    }

}