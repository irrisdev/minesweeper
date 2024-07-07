package minesweeper;

enum Difficulty {
	EASY,
	NORMAL,
	HARD
}

public class Minesweeper {
	
	private Difficulty difficulty;
	
	private int height, length;
	private int[][] board;
	private int mines;
	
	
	
	
	public void solve() {
		
	}
	
	public void generate(int h, int l) {
		this.setHeight(h);
		this.setLength(l);
		this.setBoard(new int[h][l]);
		
		switch (difficulty) {
		case HARD:
			this.setMines((int) Math.ceil(h*l * 0.263));
			break;
		case EASY:
			this.setMines((int) Math.ceil(h*l * 0.1563));
			break;
		case NORMAL:
			this.setMines((int) Math.ceil(h*l * 0.1235));
			break;
		
		}
		
	}
	
	
	
	public Minesweeper() {
		this.setDifficulty(Difficulty.NORMAL);
		
	}
	
	public Minesweeper(Difficulty d) {
		this.setDifficulty(d);
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public int[][] getBoard() {
		return board;
	}

	private void setBoard(int[][] board) {
		this.board = board;
	}

	public int getMines() {
		return mines;
	}

	private void setMines(int mines) {
		this.mines = mines;
	}

	public int getLength() {
		return length;
	}

	private void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}
	
	public void display() {
		
		 for (int i = 0; i < height; i++) {
	            // Print the horizontal line
	            for (int j = 0; j < length; j++) {
	                System.out.print("+---");
	            }
	            System.out.println("+");
	            
	            // Print the cell values with vertical separators
	            for (int j = 0; j < length; j++) {
	                System.out.printf("| %d ", board[i][j]);
	            }
	            System.out.println("|");
	        }
	        // Print the bottom line of the grid
	        for (int j = 0; j < length; j++) {
	            System.out.print("+---");
	        }
	        System.out.println("+");
	 }


	
}
