package assignment5;

import java.util.Random;
import java.util.Scanner;

public class Assignment5_V2 {

	final static Scanner KEYBOARD = new Scanner(System.in);
	final static Random RANDOM = new Random();
	
	final static int AVAILABLE = 0;
	final static int BOMB = 1;
	final static int MARKED = 2;
	
	public static void main(String[] args) {
		// DATA
		int rows, columns, maxBombs, numBombs;
		int[][] board;
		
		// INSTRUCTIONS
		
		// ask number of rows
		System.out.print("Introduce the number of rows for the board (greater than or equal to 2): ");
		rows = KEYBOARD.nextInt();
		while(rows < 2) {
			System.out.print("    ERROR. Introduce the number of rows for the board (greater than or equal to 2): ");
			rows = KEYBOARD.nextInt();
		}
		// ask number of columns
		System.out.print("Introduce the number of columns for the board (greater than or equal to 2): ");
		columns = KEYBOARD.nextInt();
		while(columns < 2) {
			System.out.print("    ERROR. Introduce the number of columns for the board (greater than or equal to 2): ");
			columns = KEYBOARD.nextInt();
		}
		
		// create the board (2d array), by default all values take value 0
		board = new int[rows][columns];
		
		// ask amount of bombs
		maxBombs = (rows * columns) / 2;
		System.out.print("Introduce the amount of bombs (between 1 and " + maxBombs + "): ");
		numBombs = KEYBOARD.nextInt();
		while(numBombs < 1 || numBombs > maxBombs) {
			System.out.print("    ERROR. Introduce the amount of bombs (between 1 and " + maxBombs + "): ");
			numBombs = KEYBOARD.nextInt();
		}
		
		// place the bombs in the board randomly
		for(int i = 1; i <= numBombs; i++) {
			int r, c;
			boolean availableSquare;
			do {
				availableSquare = false;
				r = RANDOM.nextInt(rows);
				c = RANDOM.nextInt(columns);
				// it the square is available, put a bomb in it
				if(board[r][c] == AVAILABLE) {
					board[r][c] = BOMB;
					availableSquare = true;
				}
				// while it is not available, try again with another square
			} while (!availableSquare);
		}
		
		// play the game, selecting squares
		System.out.println("\nTHE GAME STARTS:");
		boolean end = false;
		int availableCount = (rows * columns) - numBombs;
		do {
			int r, c;
			// ask square
			System.out.println("\nChoose a square:");
			System.out.print("Introduce the row, value in [0, " + (rows-1) + "]: ");
			r = KEYBOARD.nextInt();
			while(r < 0 || r >= rows) {
				System.out.print("    ERROR. Introduce the row, value in [0, " + (rows-1) + "]: ");
				r = KEYBOARD.nextInt();
			}
			System.out.print("Introduce the column, value in [0, " + (columns-1) + "]: ");
			c = KEYBOARD.nextInt();
			while(c < 0 || c >= columns) {
				System.out.print("    ERROR. Introduce the column, value in [0, " + (columns-1) + "]: ");
				c = KEYBOARD.nextInt();
			}
			
			// check the square
			switch(board[r][c]) {
			case AVAILABLE:
				System.out.println("The square is available.");
				board[r][c] = MARKED;
				availableCount--;
				// check if there are still available squares or if the user won
				if(availableCount == 0) {
					System.out.println("You have won the game!! There are no more available squares left.");
					end = true;
				} 
				break;
			case BOMB:
				System.out.println("There is a bomb in the selected square.");
				end = true;
				break;
			case MARKED:
				System.out.println("The square has been selected before. Choose another one.");
				break;
			}
		} while (!end);
		
		// show the board
		System.out.println("\nBoard:\n");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\nEnd of the program");
	}
}
