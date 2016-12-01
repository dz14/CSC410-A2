package nl.tudelft.jpacman.board;

public class TestWithinBorders {
	public static void main(String args[]){
		Square [][] grid = new Square[2][2];
		
		for (int i  = 0; i < 2; i++){
			for (int k = 0; k < 2; k++){
				Square a = new BasicSquare();
				grid[i][k] = a;
			}
		}

		Board b = new Board(grid);
		b.withinBorders(0, 1);
		b.withinBorders(4, 6);
		b.withinBorders(99, 99);

	}
}
