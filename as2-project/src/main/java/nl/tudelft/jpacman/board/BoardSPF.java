package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.Sprite;

public class BoardSPF {
	 private static final int MAX_WIDTH = 2;
	    private static final int MAX_HEIGHT = 3;
	   
	    static class Square1 extends Square {
	 
	        @Override
	        public boolean isAccessibleTo(Unit unit) {
	            // TODO Auto-generated method stub
	            return true;
	        }
	 
	        @Override
	        public Sprite getSprite() {
	            // TODO Auto-generated method stub
	            return new EmptySprite();
	        }
	       
	    }
	   
	    public static void main(String[] args) {
	    	Square1 x0y0 = new Square1();
	    	Square1 x0y1 = new Square1();
	    	Square1 x0y2 = new Square1();
	    	Square1 x1y0 = new Square1();
	    	Square1 x1y1 = new Square1();
	    	Square1 x1y2 = new Square1();
	       
	        Square[][] grid = new Square[MAX_WIDTH][MAX_HEIGHT];
	        grid[0][0] = x0y0;
	        grid[0][1] = x0y1;
	        grid[0][2] = x0y2;
	        grid[1][0] = x1y0;
	        grid[1][1] = x1y1;
	        grid[1][2] = x1y2;
	        Board board = new Board(grid);
	       
	        board.withinBorders(board.getWidth(), board.getHeight());
	    }

}
