import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.path.xml.*;

public class Soap_Api_Reference {

	public static <Xmlpath> void main(String[] args) {
		//declare the base URL
		RestAssured.baseURI="https://www.dataaccess.com";
		//declare Requestbody
		String Requestbody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n"
				+ "  <soap:Body>\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n"
				+ "      <ubiNum>100</ubiNum>\n"
				+ "    </NumberToWords>\n"
				+ "  </soap:Body>\n"
				+ "</soap:Envelope>";
		//extract Responsebody
		String ResponseBody=given().header("Content-Type", "text/xml; charset=utf-8").body(Requestbody).when().
				post("webservicesserver/NumberConversion.wso").then().extract().response().asString();
		System.out.println(ResponseBody);
		//parse the responseBody
		XmlPath XmlResponse=new XmlPath(ResponseBody);
		String ResponseParameter=XmlResponse.getString("NumberToWordsResult");
		System.out.println(ResponseParameter);
		//validate the Responsebody
		Assert.assertEquals(ResponseParameter, "one hundred");
		
		
	}
	

}
