package functionaltests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import endpoints.Players;

public class GetPlayersTest{

	Players players;
	
	@BeforeMethod
	public void initTests() {
		players = new Players();
		players.init();
	}
	
	@Test
	public void getPlayersValidation() {
		players.getPlayers();
		players.validateStatusCode(200);
	}
}
