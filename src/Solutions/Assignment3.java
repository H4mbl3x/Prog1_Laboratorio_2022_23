/*Write a Java program that helps the user to obtain a sequence of n integers (with n being greater than or equal to 2) 
 * in which even numbers are alternated with odd numbers. To do this, the integer values will be read from the keyboard, 
 * and when the rule above is not fulfilled, the program will ask for another value repeatedly until the number 
 * read fulfils it. The correct sequence will be printed on the screen as it is entered. At the end, the program will 
 * show how many wrong numbers have been read in the sequence. The sequence of numbers may start with an odd or even number, 
 * depending on the value of the first number entered by the user.
 */
package assignment3;

import java.util.*;

public class Assignment3 {

	final static Scanner KEYBOARD = new Scanner(System.in);

	public static void main(String[] args) {
		// DATA

		int n, // number of integers for the sequence
		    readNumber, // store the integer read from the keyboard
		    errors; // count incorrect values entered by the user
		boolean isCurrentEven, isNewEven;

		// INSTRUCTIONS
	
		errors = 0;

		// ask the amount of numbers to be read
		System.out.print("How many integers do you want the sequence to have (it must be greater than or equal to 2)?... ");
		n = KEYBOARD.nextInt();


		// ask again for a value while it is less than 2
		while (n < 2) {
			System.out.print("Error, the value must be greater than or equal to 2. Try again... ");
			n = KEYBOARD.nextInt();
		}

		/* Data processing*/

		// Read the first integer and check if is even
		System.out.print("Introduce the first integer ");
		readNumber = KEYBOARD.nextInt();

		if (readNumber % 2 == 0)
			isCurrentEven = true;
		else
			isCurrentEven = false;

		// isCurrentEven = (readNumber % 2 == 0) ? true : false;

		// read the rest of the numbers from the keyboard. Since we know how many we have to read (n), we can use a for loop

		System.out.println("The integer #1 in the sequence is: " + readNumber);

		for (int num = 2; num <= n; num++) {
			
			System.out.print("   Introduce an " + (isCurrentEven ? "odd " : "even ") + "integer " );
			readNumber = KEYBOARD.nextInt();
			isNewEven = (readNumber % 2 == 0) ? true : false;

			// Check if the condition about odd or even is met
			if (isCurrentEven != isNewEven)
				isCurrentEven = isNewEven;
			else { 
				do {// repeat until the number meets the condition
					errors++;
					System.out.print("        You must introduce an " + (isCurrentEven ? "odd " : "even ") + "integer ");
					readNumber = KEYBOARD.nextInt();
					isNewEven = (readNumber % 2 == 0) ? true : false;
				} while (isCurrentEven == isNewEven);
				isCurrentEven = isNewEven;
			}
			System.out.println("The integer #" + num + " in the sequence is: " + readNumber);
		}
		System.out.println("The number of errors when reading the values is: " + errors);
		System.out.println("\nEnd of the program...");
	}// end of main
}// end of program