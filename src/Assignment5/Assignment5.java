// Daniel Barchino Rodríguez-Caro
// Jorge Carrascosa Clemente
// Andrés García López
// Marcos Hurtado Morcillo

package Session5;
import java.util.Scanner;
import java.util.Random;

public class Assignment5 {
	private static final Scanner KEYBOARD = new Scanner(System.in);
	final static Random RANDOM = new Random();
	public static void main(String[] args) {
		int amountRows, amountColumns, maxBombs, amountBombs;
		/* Variables uses:
			- amountRows: Amount of rows of the board
			- amountColumns: Amount of columns of the board
			- maxBombs: Maximum amount of bombs that can be on the board
			- amountBombs: The amount of bombs that is going to be on the board
		 */
		System.out.println("Introduce the number of rows for the board (greater than or equal to 2): ");
		amountRows = KEYBOARD.nextInt(); // Stores the amount of rows of the board
		while (amountRows<2) { // Controls that the amount of rows is higher or equal to 2
			System.out.println("	The number of rows for the board must be greater than or equal to 2: ");
			amountRows = KEYBOARD.nextInt(); // Stores the amount of rows of the board
		}
		System.out.println("Introduce the number of columns for the board (greater than or equal to 2): ");
		amountColumns = KEYBOARD.nextInt(); // Stores the amount of columns of the board
		while (amountRows<2) { // Controls that the amount of columns is higher or equal to 2
			System.out.println("	The number of columns for the board must be greater than or equal to 2: ");
			amountColumns = KEYBOARD.nextInt(); // Stores the amount of rows of the board
		}
		int [][] board = new int [amountRows][amountColumns];	
		maxBombs = amountRows * amountColumns / 2;
		System.out.println("Introduce the number of bombs (between 1 and " + maxBombs + "): ");
		amountBombs = KEYBOARD.nextInt();
		while (amountBombs<1&&amountBombs>maxBombs) {
			System.out.println("	The number of bomb must be between 1 and " + maxBombs + ": ");
			amountBombs = KEYBOARD.nextInt();
		}
		for(int i=0;i<amountBombs;i++) {
			int randomRow = RANDOM.nextInt(board.length);
			int randomColumn = RANDOM.nextInt(board[randomRow].length);
			while(board[randomRow][randomColumn]==1)
				randomRow = RANDOM.nextInt(board.length);
				randomColumn = RANDOM.nextInt(board[randomRow].length);
			board[randomRow][randomColumn]=1;
		}
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++)
				if(j==board[i].length-1) {
					System.out.println(board[i][j]);
				} else {
					System.out.print(board[i][j]);
				}		
		}
	}
}