/**
 * 
 */
package assignment2;

import java.util.*;

public class Assignment2OnlyIf {

	// SELECTION

	final static Scanner KEYBOARD = new Scanner(System.in);

	// define values for each border and corner
	final static int TOP_BORDER = 1;
	final static int BOTTOM_BORDER = 2;
	final static int LEFT_BORDER = 3;
	final static int RIGHT_BORDER = 4;
	final static int TL_CORNER = 13;
	final static int TR_CORNER = 14;
	final static int BL_BORDER = 23;
	final static int BR_BORDER = 24;
	final static int INSIDE = 0;
	final static int MIN_NUM_ROWS = 2;
	final static int MIN_NUM_COLUMNS = 2;

	public static void main(String[] args) {

		// DATA matrix of 1 to dimN rows and 1 to dimM columns
		int dimN, dimM, i, j;
		int firstRow = 1, lastRow, firstColumn = 1, lastColumn, result = -1;

		// INSTRUCTIONS

		// READ DIMESION FOR THE MATRIX
		System.out.print("Introduce the number of rows for the matrix: ");
		dimN = KEYBOARD.nextInt();

		if (dimN < MIN_NUM_ROWS)
			System.out.println("The number of rows must be greater than or equal to " + MIN_NUM_ROWS
					+ " , the program will finish...");

		else {
			System.out.print("Introduce the number of columns for the matrix: ");
			dimM = KEYBOARD.nextInt();
			if (dimM < MIN_NUM_COLUMNS)
				System.out.println("The number of columns must be greater than or equal to " + MIN_NUM_COLUMNS
						+ " , the program will finish...");

			else {

				lastRow = dimN;
				lastColumn = dimM;

				// READ THE POSITION I,J

				System.out.print("Introduce the row for the position: ");
				i = KEYBOARD.nextInt();

				if (i > lastRow || i < firstRow)
					System.out.println("The row must be in the range [" + firstRow + ", " + lastRow
							+ "], the program will finish...");

				else {

					System.out.print("Introduce the column for the position: ");
					j = KEYBOARD.nextInt();
					if (j > lastColumn || j < firstColumn)
						System.out.println("The column must be in the range [" + firstColumn + ", " + lastColumn
								+ "], the program will finish...");

					else { // i and j are correct. Check if the position is in any corner or border
						if ((firstRow < i && i < lastRow) && (firstColumn < j && j < lastColumn))
							result = INSIDE;
						else if (i == firstRow)
							if (j == firstColumn)
								result = TL_CORNER;
							else if (j == lastColumn)
								result = TR_CORNER;
							else
								result = TOP_BORDER;

						else if (i == lastRow)
							if (j == firstColumn)
								result = BL_BORDER;
							else if (j == lastColumn)
								result = BR_BORDER;
							else
								result = BOTTOM_BORDER;

						// CHECK If IT IS IN THE LEFT OR RIGHT BORDER
						else if (j == firstColumn)

							result = LEFT_BORDER;

						else if (j == lastColumn)

							result = RIGHT_BORDER;

						System.out.println("The position is in " + result);
					}
				}
			}
		}
		System.out.println("End of the program...");
	}// end main

}// end program
