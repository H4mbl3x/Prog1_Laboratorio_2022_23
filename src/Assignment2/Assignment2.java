// Daniel Barchino Rodríguez-Caro
// Jorge Carrascosa Clemente
// Andrés García López
// Marcos Hurtado Morcillo

package Session2;
import java.util.Scanner;

public class Assignment2 {
	private static final Scanner KEYBOARD = new Scanner(System.in);
	public static void main(String[] args) {
		int rowPosition, columnPosition, rowsMatrix, columnsMatrix;
		/* Variables uses:
	    	- rowPosition: The row we want to know its position
	    	- columnPosition: The column we want to know its position
	    	- rowsMatrix: The number of rows that the matrix has
	    	- columnsMatrix: The number of columns that the matrix has
		 */
		System.out.println("Introduce the number of rows for the matrix:");
		rowsMatrix = KEYBOARD.nextInt(); // Stores the number of rows
		if(rowsMatrix>=2) { // Controls that the number of rows is greater or equal to 2
			System.out.println("Introduce the number of columns for the matrix:");
			columnsMatrix = KEYBOARD.nextInt(); // Stores the number of columns
			if(columnsMatrix>=2) { // Controls that the number of columns is greater or equal to 2
				System.out.println("Introduce the rows for the position:");
				rowPosition = KEYBOARD.nextInt(); // Stores the row number that we want to know it position
				if(rowPosition>0 && rowPosition<=rowsMatrix) { // Controls that the row number given is inside the matrix range
					System.out.println("Introduce the column for the position:");
					columnPosition = KEYBOARD.nextInt(); // Stores the column number that we want to know it position
					if(columnPosition>0 && columnPosition<=columnsMatrix) { // Controls that the column number given is inside the matrix range
						System.out.println("The position of the cell is: ");
						if(rowPosition==1) // If the row is the top one
							System.out.print("1");
						else if(rowPosition==rowsMatrix) // If the row is the bottom one
							System.out.println("2");
						if(columnPosition==1)
							System.out.println("3"); // If the column is the left border one
						else if(columnPosition==columnsMatrix) // If the column is the right border one
							System.out.println("4");
					} else // If the column number is not inside the matrix range
						System.out.println("The position of the column must be inside the range 1-" + columnsMatrix);
				}else // If the row number is not inside the matrix range
					System.out.println("The position of the row must be inside the range 1-" + rowsMatrix);
			} else // If the number of columns is smaller than 2
				System.out.println("The numbers of columns must be greater or equal than 2");
		} else // If the number of rows is smaller than 2
			System.out.println("The numbers of rows must be greater or equal than 2");
	}
}