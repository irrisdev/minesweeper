package minesweeper;

public class Main {
	
	
	public static void main(String[] args) {
		
		
		Minesweeper minesweep = new Minesweeper();
		
		minesweep.setDifficulty(Difficulty.HARD);
		
		minesweep.generate(10, 10);
		
		minesweep.display();
		
		System.out.println(minesweep.getDifficulty());
		System.out.println(minesweep.getMines());
		
		//minesweep.solve();
		
		
	}
	
}
