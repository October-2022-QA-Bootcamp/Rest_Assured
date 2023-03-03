package unittests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PlayersTest {

	@Test(enabled = false)
	public void getPlayersPreetyPrint() {
		RestAssured.get("http://localhost:3000/countries/10").prettyPrint();
	}
	
	@Test(enabled = false)
	public void getPlayersVar() {
		Response response = RestAssured.get("http://localhost:3000/countries");
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
	
	@Test(enabled = true)
	public void getPlayersResponseValidation() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/players/3")
		.then()
		.log().all()
		.statusCode(200)
		.and()
		.body("id", equalTo(3))
		.body("firstName", equalTo("Sakibal"))
		.body("DOB", equalTo("11/02/1992"));
	}
}
