// Daniel Barchino Rodríguez-Caro
// Jorge Carrascosa Clemente
// Andrés García López
// Marcos Hurtado Morcillo

package Session2;
import java.util.Scanner;

public class Assignment2Version2 {
	private static final Scanner KEYBOARD = new Scanner(System.in);
	public static void main(String[] args) {
		final int rowsMatrix=4;
		final int columnsMatrix=5;
		int rowPosition, columnPosition;
		/* Variables uses:
    		- rowsMatrix: The number of rows that the matrix has
    		- columnsMatrix: The number of columns that the matrix has
    		- rowPosition: The row we want to know its position
    		- columnPosition: The column we want to know its position
		 */
		System.out.println("The matrix has 4 rows and 5 columns");
		System.out.println("Introduce the rows for the position:");
		rowPosition = KEYBOARD.nextInt(); // Stores the row number that we want to know it position
		if(rowPosition>0 && rowPosition<=rowsMatrix) { // Controls that the row number given is inside the matrix range
			System.out.println("Introduce the column for the position:");
			columnPosition = KEYBOARD.nextInt(); // Stores the column number that we want to know it position
			if(columnPosition>0 && columnPosition<=columnsMatrix) { // Controls that the column number given is inside the matrix range
				switch(rowPosition) { // We are going to guess the position of the row
					case 1: // It is the first row
						System.out.println("The position is in the top border");
						break;
					case rowsMatrix: // It is the last row
						System.out.println("The position is in the bottom border");
				}
				switch(columnPosition) { // We are going to guess the position of the column
					case 1: // It is the left border row
						System.out.println("The position is in the left border");
						break;
					case columnsMatrix: // It is the right border row
						System.out.println("The position is in the right border");
				}
			} else // If the column number is not inside the matrix range
				System.out.println("The position of the column must be inside the range 1-" + columnsMatrix);
		}else // If the row number is not inside the matrix range
			System.out.println("The position of the row must be inside the range 1-" + rowsMatrix);
	}
}