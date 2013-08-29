import junit.framework.TestCase;


public class BowlingGameTest extends TestCase {
	private BowlingGame bowlingGame;
	
	@Override
	protected void setUp() throws Exception {	
		bowlingGame = new BowlingGame();
	}
	
	public void testInitialize() throws Exception {
		bowlingGame.start();
	}
}
