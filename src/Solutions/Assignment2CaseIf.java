/**
 * 
 */
package assignment2;

import java.util.*;

public class Assignment2CaseIf {

	// SELECTION with switch ==> CASE VALUES MUST BE CONSTANTS... THUS, DIMENSIONS FOR THE MATRIX ARE FIXED... 
	// STRING VARIABLES ARE USED INSTEAD OF INTEGERS

	final static Scanner KEYBOARD = new Scanner(System.in);

	// define values for dimensions, each border and corner

	final static int DIM_N = 4;
	final static int DIM_M = 5;
	final static int FIRST_ROW = 1, FIRST_COLUMN = 1;
	final static int LAST_ROW = DIM_N, LAST_COLUMN = DIM_M;
	final static String TOP_BORDER = "in top border";
	final static String BOTTOM_BORDER = "in bottom border";;
	final static String LEFT_BORDER = "in left border";;
	final static String RIGHT_BORDER = "in right border";;
	final static String TL_CORNER = "in top left corner";
	final static String TR_CORNER = "in top right corner";
	final static String BL_BORDER = "in bottom left corner";
	final static String BR_BORDER = "in bottom right corner";
	final static String INSIDE = "inside the matrix";

	public static void main(String[] args) {

		int i, j;
		String result = "";

		// READ THE POSITION I,J
		System.out.printf("The matrix has %d rows and %d columns \n", DIM_N, DIM_M);
		System.out.print("Introduce the row for the position: ");
		i = KEYBOARD.nextInt();

		if (i > LAST_ROW || i < FIRST_ROW)
			System.out.println("The row must be in the range [" + FIRST_ROW + ", " + LAST_ROW
					+ "], the program will finish...");

		else {

			System.out.print("Introduce the column for the position: ");
			j = KEYBOARD.nextInt();
			if (j > LAST_COLUMN || j < FIRST_COLUMN)
				System.out.println("The column must be in the range [" + FIRST_COLUMN + ", " + LAST_COLUMN
						+ "], the program will finish...");

			else { // Check if the position is in any corner or border
				if ((FIRST_ROW < i && i < LAST_ROW) && (FIRST_COLUMN < j && j < LAST_COLUMN))
					result = INSIDE;

				else if (i == FIRST_ROW)
					switch (j) {
					case FIRST_COLUMN:
						result = TL_CORNER;
						break;
					case LAST_COLUMN:
						result = TR_CORNER;
						break;
					default:
						result = TOP_BORDER;
						break;
					}

				else if (i == LAST_ROW)
					switch (j) {
					case FIRST_COLUMN:
						result = BL_BORDER;
						break;
					case LAST_COLUMN:
						result = BR_BORDER;
						break;
					default:
						result = BOTTOM_BORDER;
						break;
					}

				// CHECK If IT IS IN THE LEFT OR RIGHT BORDER
				else if (j == FIRST_COLUMN)

					result = LEFT_BORDER;

				else if (j == LAST_COLUMN)

					result = RIGHT_BORDER;

				System.out.println("The position is " + result);
			}
		}
		System.out.println("End of the program...");
	}// end main
}// end program
