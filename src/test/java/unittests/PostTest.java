package unittests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostTest {

	@Test(enabled = false)
	public void postTestStringBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 7,\"firstName\": \"Harshal\",\"lastName\": \"Gibbs\",\"DOB\": \"04/02/1980\",\"countryCode\": 70}")
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test(enabled = false)
	public void postTestStringBody400() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body("{\"id\": 7,\"firstName\": \"Harshal\",\"lastName\": \"Gibbs\",\"DOB\": \"04/02/1980\",\"countryCode\": 70\"}")
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(400);
	}
	
	@Test(enabled = false)
	public void postTestFileBody500() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(new File("src/test/resources/player.json"))
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(500);
	}
	
	@Test(enabled = false)
	public void postTestInputStreamBody() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(getClass().getClassLoader().getResourceAsStream("player2.json"))
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test(enabled = false)
	public void postTestByteBody() {
		try {
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.contentType(ContentType.JSON)
			.body(getClass().getClassLoader().getResourceAsStream("player2.json").readAllBytes())
			.basePath("/players")
			.when()
			.log().all()
			.post()
			.then()
			.log().all()
			.statusCode(201);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = true)
	public void postTestMapBody() {
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", "Rahul");
		map.put("lastName", "Dravid");
		map.put("DOB", "01/05/1977");
		map.put("countryCode", 90);
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.contentType(ContentType.JSON)
		.body(map)
		.basePath("/players")
		.when()
		.log().all()
		.post()
		.then()
		.log().all()
		.statusCode(201);
	}
}
