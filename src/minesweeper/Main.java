package minesweeper;

public class Main {
	
	
	public static void main(String[] args) {
		
		
		Minesweeper minesweep = new Minesweeper();
				
		minesweep.generate(8, 8);
		
		minesweep.start();
		
		minesweep.display();
		
		System.out.println(minesweep.getDifficulty());
		System.out.println(minesweep.getMines());
		
		//minesweep.solve();
		
		
	}
	
}
