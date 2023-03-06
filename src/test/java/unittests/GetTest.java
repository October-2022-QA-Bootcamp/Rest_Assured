package unittests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {

	@Test(enabled = false)
	public void getPlayersPreetyPrint() {
		RestAssured.get("http://enthrall.education:3001/players").prettyPrint();
	}
	
	@Test(enabled = true)
	public void getPlayersVar() {
		Response response = RestAssured.get("http://enthrall.education:3001/countries");
		System.out.println(response.asString());
	}
	
	@Test(enabled = false)
	public void getPlayersResposneCodeValidation() {
		RestAssured.get("http://localhost:3000/countries/10")
		.then()
		.statusCode(200);
	}
	
	@Test(enabled = false)
	public void getPlayersResposneCodeValidationNeagativeTest404() {
		RestAssured.get("http://localhost:3000/countries/100")
		.then()
		.statusCode(404);
	}

	@Test(enabled = false)
	public void getPlayersLogs() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/countries/10")
		.then()
		.log().all()
		.statusCode(200);
	}
	
	@Test(enabled = false)
	public void getPlayersResponseValidation() {
		RestAssured.given()
		.log().all()//Request Log
		.get("http://localhost:3000/players/3")
		.then()
		.log().all()//Response Log
		.statusCode(200)
		.and()
		.body("id", equalTo(3))
		.body("firstName", equalTo("Sakibal"))
		.body("DOB", equalTo("11/02/1992"));
	}
	
	@Test(enabled = true)
	public void getPlayersBaseUriPath() {
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/players/3")
		.log().all()//Request Log
		.get()
		.then()
		.log().all()//Response Log
		.statusCode(200);
	}
}
