package unittests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutTest {
	
	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Virat");
		map.put("lastName", "Kholi");
		map.put("DOB", "01/06/1978");
		map.put("countryCode", 90);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/players/8") //end-points
		.contentType(ContentType.JSON)
		.body(map)//Pay-load
		.log().all()
		.put()
		.then()
		.log().all()
		.statusCode(200);
	}
}
