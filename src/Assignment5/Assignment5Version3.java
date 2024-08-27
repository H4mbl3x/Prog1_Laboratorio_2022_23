// Daniel Barchino Rodríguez-Caro
// Jorge Carrascosa Clemente
// Andrés García López
// Marcos Hurtado Morcillo

package Session5;
import java.util.Scanner;
import java.util.Random;

public class Assignment5Version3 {
	private static final Scanner KEYBOARD = new Scanner(System.in);
	final static Random RANDOM = new Random();
	public static void main(String[] args) {
		int amountRows, amountColumns, maxBombs, amountBombs;
		/* Variables uses:
			- amountRows: Amount of Rows of the board
			- amountColumns: Amount of Columns of the board
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
			amountColumns = KEYBOARD.nextInt(); // Stores the amount of columns of the board
		}
		int [][] board = new int [amountRows][amountColumns]; // Creates the board
		maxBombs = amountRows * amountColumns / 2; // Calculates the maximum amount of bombs that can be on the map
		System.out.println("Introduce the number of bombs (between 1 and " + maxBombs + "): ");
		amountBombs = KEYBOARD.nextInt(); // Stores the real amount of bombs that is going to be on the map
		while (amountBombs<1||amountBombs>maxBombs) { // Controls that the real amount of bombs is between 1 and the maximum amount
			System.out.println("	The number of bomb must be between 1 and " + maxBombs + ": ");
			amountBombs = KEYBOARD.nextInt(); // Stores the real amount of bombs that is going to be on the map
		}
		for(int i=0;i<amountBombs;i++) { // Loop for generate the random location of the bombs
			int randomRow = RANDOM.nextInt(board.length); // Gets the number of the row randomly
			int randomColumn = RANDOM.nextInt(board[randomRow].length); // Gets the number of the column randomly
			while(board[randomRow][randomColumn]==1) { // Controls that in the cell is not another bomb
				randomRow = RANDOM.nextInt(board.length);
				randomColumn = RANDOM.nextInt(board[randomRow].length);
			}
			board[randomRow][randomColumn]=1; // Generates the bomb
		}
		System.out.println("\nTHE GAME STARTS\n");
		
		boolean playing=true; // If playing is "True", the game continues, else it stops
		int maxRow = amountRows-1; // The maximum value for the rows value
		int maxColumn = amountColumns-1; // The maximum value for the columns value
		do {
			System.out.println("Choose a square:");
			System.out.println("Introduce the row, value in [0, " + maxRow + "]:");
			int rowChecked = KEYBOARD.nextInt(); // Stores the row where the user want to check if there is a bomb
			while(rowChecked<0||rowChecked>maxRow) { // Controls that the row defined exists
				System.out.println("	The row value must be between [0, " + maxRow + "]:");
				rowChecked = KEYBOARD.nextInt(); // Stores the row where the user want to check if there is a bomb
			}
			System.out.println("Introduce the column, value in [0, " + maxColumn + "]:");
			int columnChecked = KEYBOARD.nextInt(); // Stores the column where the user want to check if there is a bomb
			while(columnChecked<0||columnChecked>maxColumn) { // Controls that the column defined exists
				System.out.println("	The column value must be between [0, " + maxColumn + "]:");
				columnChecked = KEYBOARD.nextInt(); // Stores the column where the user want to check if there is a bomb
			}
			if(board[rowChecked][columnChecked]==1) { // Controls if the cell defined contains a bomb
				playing=false; // Indicator to not continue the game
				System.out.println("There is a bomb in the selected square.");
				System.out.println("BOARD:");
				for(int i=0;i<board.length;i++) { // Prints the board
					for(int j=0;j<board[i].length;j++) {
						if(j==board[i].length-1) {
							System.out.println(board[i][j]);
						} else {
							System.out.print(board[i][j]);
						}
					}
				}
			} else if(board[rowChecked][columnChecked]==0) { // Checks if the cell is free
				System.out.println("The cell is free!");
				board[rowChecked][columnChecked]=2;
				int check=1; // Auxiliary variable to check if there is a cell without been checked
				for(int i=0;i<board.length;i++) { // Checks of there is any free bomb
					for(int j=0;j<board[i].length;j++)
						check*=board[i][j];
				}
				if(check!=0) // If there is any cell without been checked
					playing=false;
				else { // If there are available cells to check
					int surrondedBombs = 0; // Stores the number of bombs that surrounds the cell selected
					if(rowChecked>=1&&rowChecked<=amountRows-2) { //If the cell we are checking is in a middle row
						for(int i=rowChecked-1;i<=rowChecked+1;i++) {
							if(columnChecked>=1&&columnChecked<=amountColumns-2) { //If the cell we are checking is in a middle column
								for(int j=columnChecked-1;j<=columnChecked+1;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							} else if(columnChecked==0) { //If the cell we are checking is in the first column
								for(int j=columnChecked;j<=columnChecked+1;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							} else if(columnChecked==amountColumns-1) { //If the cell we are checking is in the last column
								for(int j=columnChecked-1;j<=columnChecked;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							}
						}
					} else if(rowChecked==0) { //If the cell we are checking is in the left
						for(int i=rowChecked;i<=rowChecked+1;i++) { // Checks of there is any free bomb
							if(columnChecked>=1&&columnChecked<=amountColumns-2) { //If the cell we are checking is in a middle column
								for(int j=columnChecked-1;j<=columnChecked+1;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							} else if(columnChecked==0) { //If the cell we are checking is in the first column
								for(int j=columnChecked;j<=columnChecked+1;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							} else if(columnChecked==amountColumns-1) { //If the cell we are checking is in the last column
								for(int j=columnChecked-1;j<=columnChecked;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							}
						}
					} else if(rowChecked==amountRows-1) { //If the cell we are checking is in the right
						for(int i=rowChecked-1;i<=rowChecked;i++) { // Checks of there is any free bomb
							if(columnChecked>=1&&columnChecked<=amountColumns-2) { //If the cell we are checking is in a middle column
								for(int j=columnChecked-1;j<=columnChecked+1;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							} else if(columnChecked==0) { //If the cell we are checking is in the first column
								for(int j=columnChecked;j<=columnChecked+1;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							} else if(columnChecked==amountColumns-1) { //If the cell we are checking is in the last column
								for(int j=columnChecked-1;j<=columnChecked;j++) {
									if(board[i][j]==1) //If there is a bomb
										surrondedBombs+=board[i][j];
								}
							}
						}
					}
					if(surrondedBombs==1)
						System.out.println("The cell check is surrounded by " + surrondedBombs + " bomb.\n\n");
					else if (surrondedBombs>1)
						System.out.println("The cell check is surrounded by " + surrondedBombs + " bombs.\n\n");
					else
						System.out.println("The cell is not surrounded by any bomb.\n\n");
				}
			} else if(board[rowChecked][columnChecked]==2) { // Checks if there is a bomb in the cell defined
				System.out.println("You checked this cell previosly\n\n");
			}
		} while(playing==true);
		System.out.println("");
		System.out.println("END OF THE GAME");
	}
}