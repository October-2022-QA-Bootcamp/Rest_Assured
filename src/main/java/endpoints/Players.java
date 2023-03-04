package endpoints;

import utils.RestSpecifications;

public class Players extends RestSpecifications{

	private final String ENDPOINT = "/players";
	
	public void getPlayers() {
		getCall(ENDPOINT);
	}
}
