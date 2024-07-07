package minesweeper;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

enum Difficulty {
	EASY,
	NORMAL,
	HARD
}

public class Minesweeper {
	
	private Difficulty difficulty;
	private int height, length;
	
	private String[][] board;
	private int mines;
	private Set<Integer> coordinates;
	
	private static int[][] offsets = new int[][] {{-1,-1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
	private Random rand = new Random();

	
	private String[][] DisplayBoard;

	
	private void setMines(int nx, int ny) {
		Set<Integer> taken = new HashSet<>();
		taken.add(nx * ny);
		
		coordinates = new HashSet<>();
		int x, y, ox, oy;

		for (int[] offset : offsets) {
			
			ox = nx + offset[0];
			oy = ny + offset[1];

			taken.add(ox * oy);
		}
		
		for (int i = 0; i < mines; i++) {
			
			x = rand.nextInt(length);
			y = rand.nextInt(height);
			
			while (taken.contains(x * y) || coordinates.contains(x * 7)) {
				x = rand.nextInt(length);
				y = rand.nextInt(height);
			}
			
			coordinates.add(x * y);
			board[y][x] = "*";
			for (int[] offset : offsets) {
				
				ox = x + offset[0];
				oy = y + offset[1];
				
				if ((ox < 0 || ox > (length -1)) || (oy < 0 || oy > (height-1)) || board[oy][ox].equals("*")) {
					continue;
				}

				board[oy][ox] = Integer.toString(Integer.parseInt(board[oy][ox]) + 1);
				
			}
			
		}
		
		
	}
	
	
	public void solve() {
		
	}
	
	public void generate(int h, int l) {
		this.setHeight(h);
		this.setLength(l);
		this.setBoard(new String[h][l]);
		
		switch (difficulty) {
		case HARD:
			this.setMines((int) Math.ceil(h*l * 0.263));
			break;
		case NORMAL:
			this.setMines((int) Math.ceil(h*l * 0.1563));
			break;
		case EASY:
			this.setMines((int) Math.ceil(h*l * 0.1235));
			break;
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				board[i][j] = "0";
			}
		}
		
	}

	
	private void setBoard(String[][] strings) {
		this.board = strings;
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

	public String[][] getBoard() {
		return board;
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
	                System.out.printf("| %s ", board[i][j]);
	            }
	            System.out.println("|");
	        }
	        // Print the bottom line of the grid
	        for (int j = 0; j < length; j++) {
	            System.out.print("+---");
	        }
	        System.out.println("+");
	 }

	
	public void display(String[][] iboard) {
		
		 for (int i = 0; i < height; i++) {
	            // Print the horizontal line
	            for (int j = 0; j < length; j++) {
	                System.out.print("+---");
	            }
	            System.out.println("+");
	            
	            // Print the cell values with vertical separators
	            for (int j = 0; j < length; j++) {
	                System.out.printf("| %s ", iboard[i][j]);
	            }
	            System.out.println("|");
	        }
	        // Print the bottom line of the grid
	        for (int j = 0; j < length; j++) {
	            System.out.print("+---");
	        }
	        System.out.println("+");
	 }
	
	private void revealCell(int x, int y) {
		
		if (x < 0 || x > length-1 || y < 0 || y > height-1 || board[y][x].equals("*") || !DisplayBoard[y][x].equals(" ")) { return; }
		else if (!board[y][x].equals("0")) { DisplayBoard[y][x] = board[y][x]; return;}
		else {
			
			DisplayBoard[y][x] = board[y][x];
			
			for (int[] offset : offsets) {
				revealCell(x + offset[0], y + offset[1]);
			}
			
			
		}
		
		
		
		
	}
	
	public void start() {
		 int x, y;
		 Scanner scanner = new Scanner(System.in);
		 
		 DisplayBoard = new String[height][length];
			
		 for (int i = 0; i < height; i++) {
				for (int j = 0; j < length; j++) {
					DisplayBoard[i][j] = " ";
			}
		}
		 
		 display(DisplayBoard);

		 System.out.println("Pick first cell: ");
		 
		 x = scanner.nextInt();
		 y = scanner.nextInt();
		 
		 setMines(x, y);
		 
		 revealCell(x, y);
		 	
		 display(DisplayBoard);
		 display();

		 while (true){
		

			 System.out.println("Pick next cell: ");
			 
			 x = scanner.nextInt();
			 y = scanner.nextInt();
			 
			 revealCell(x, y);
			 
			 display(DisplayBoard);
			 
		 }

		
	}

	public String[][] getDisplayBoard() {
		return DisplayBoard;
	}

	public void setDisplayBoard(String[][] displayBoard) {
		DisplayBoard = displayBoard;
	}


	
}
