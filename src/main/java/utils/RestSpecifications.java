package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import reporting.Logs;

public abstract class RestSpecifications {

	protected RequestSpecification request;
	protected Response response;
	
	public void init() {
		String baseUrl = TestConfig.getUrl();
		System.out.println(baseUrl);
		request = RestAssured.given().baseUri(baseUrl);
	}
	
	public void getCall(String endpoint) {
		request.log().all();
		response = request.get(endpoint);
		Logs.log("Response :\n" + response.prettyPrint());
	}
	
	public void validateStatusCode(int statusCode) {
		response.then().statusCode(statusCode);
		Logs.log("Expected Response Code is :" + statusCode + ". Actual Status code is : " + response.statusCode());
	}
}
