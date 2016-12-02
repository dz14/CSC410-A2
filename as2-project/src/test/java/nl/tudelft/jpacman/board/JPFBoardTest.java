package nl.tudelft.jpacman.board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class JPFBoardTest {
	
	private Board board;
	
	private final Square x0y0 = mock(Square.class);
	private final Square x0y1 = mock(Square.class);
	private final Square x0y2 = mock(Square.class);
	private final Square x1y0 = mock(Square.class);
	private final Square x1y1 = mock(Square.class);
	private final Square x1y2 = mock(Square.class);
	
	private static final int MAX_WIDTH = 2;
	private static final int MAX_HEIGHT = 3;
	
	@Before
	public void setUp() {
		Square[][] grid = new Square[MAX_WIDTH][MAX_HEIGHT];
		grid[0][0] = x0y0;
		grid[0][1] = x0y1;
		grid[0][2] = x0y2;
		grid[1][0] = x1y0;
		grid[1][1] = x1y1;
		grid[1][2] = x1y2;
		board = new Board(grid);
	}
	
	@Test
	public void testInBoundary(){
		assertTrue(board.withinBorders(0, 0));
	}
	
	@Test
	public void testOutOfBoundary1(){
		assertFalse(board.withinBorders(0, 3));
	}
	
	@Test
	public void testOutOfBoundary2(){
		assertFalse(board.withinBorders(0, -1000000));
	}
	
	@Test
	public void testOutOfBoundary3(){
		assertFalse(board.withinBorders(2, -2147483648));
	}
	
	@Test public void testOutOfBoundary4(){
		assertFalse(board.withinBorders(-1000000, -2147483648));
	}
	
	@Test public void testOnBoundary(){
		assertTrue(board.withinBorders(1, 2));
	}
}
