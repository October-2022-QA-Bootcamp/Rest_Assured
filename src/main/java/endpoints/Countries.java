package endpoints;

import utils.RestSpecifications;

public class Countries extends RestSpecifications{

	private final String ENDPOINT = "/countries";
	
	public void getCountries() {
		getCall(ENDPOINT);
	}
}
