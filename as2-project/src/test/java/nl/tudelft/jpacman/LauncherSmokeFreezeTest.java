package nl.tudelft.jpacman;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;

public class LauncherSmokeFreezeTest {

private Launcher launcher;
	
	/**
	 * Launch the user interface.
	 */
	@Before
	public void setUpPacman() {
		launcher = new Launcher();
		launcher.launch();
	}
	
	/**
	 * Quit the user interface when we're done.
	 */
	@After
	public void tearDown() {
		launcher.dispose();
	}

    /**
     * Launch the game, and imitate what would happen in a typical game.
     * The test is only a smoke test, and not a focused small test.
     * Therefore it is OK that the method is a bit too long.
     * 
     * @throws InterruptedException Since we're sleeping in this test.
     */
    @SuppressWarnings({"methodlength", "PMD.JUnitTestContainsTooManyAsserts"})
    @Test
    public void smokeTest() throws InterruptedException {
        Game game = launcher.getGame();        
        Player player = game.getPlayers().get(0);
 
        // start cleanly.
        assertFalse(game.isInProgress());
        game.start();
        assertTrue(game.isInProgress());
        assertEquals(0, player.getScore());

        // get points
        game.move(player, Direction.EAST);
        assertEquals(10, player.getScore());

        // now moving back does not change the score
        game.move(player, Direction.WEST);
        assertEquals(10, player.getScore());

        // try to move as far as we can
        move(game, Direction.EAST, 7);
        assertEquals(60, player.getScore());

        // move towards the monsters
        move(game, Direction.NORTH, 6);
        assertEquals(120, player.getScore());

        // no more points to earn here.
        move(game, Direction.WEST, 2);
        assertEquals(120, player.getScore());

        move(game, Direction.NORTH, 2);
        
        // Sleeping in tests is generally a bad idea.
        // Here we do it just to let the monsters move.
        game.getLevel().pause();
        Thread.sleep(5000L);
       
        // we're close to monsters, this will get us killed.
       
        assertTrue(player.isAlive());

        game.stop();
        assertFalse(game.isInProgress());
     }

    /**
     * Make number of moves in given direction.
     *
     * @param game The game we're playing
     * @param dir The direction to be taken
     * @param numSteps The number of steps to take
     */
    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
}