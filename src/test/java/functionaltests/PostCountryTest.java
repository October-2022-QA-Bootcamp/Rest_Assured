package functionaltests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import endpoints.Countries;

public class PostCountryTest {

	Countries countries;
	
	@BeforeMethod
	public void init() {
		countries = new Countries();
		countries.init();
	}
	
	@Test
	public void postACountry() {
		countries.postACountry();
		countries.validateStatusCode(201);
		countries.validatePayloadObject("countryName", "West Indies");
		countries.validate_w_JsonPath("iccRank", 6);
	}
}
