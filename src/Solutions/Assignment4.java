/* Rework the code of assignment 3, so that the numbers that form the correct sequence 
 * are stored in a vector as they are read. At the end of the program, the vector will 
 * be traversed to show the sequence obtained. The program will also show the number 
 * of errors made when reading the sequence. Also, at the end of the program, and once 
 * the vector has been obtained, the program will traverse it to obtain the sum of the 
 * even numbers and the sum of the odd numbers to finally display the result of both.
 * */

package assignment4;

import java.util.Scanner;

public class Assignment4 {
	
	final static Scanner KEYBOARD = new Scanner(System.in);

	public static void main(String[] args) {
		// DATA

		int n, // number of integers for the sequence
			readNumber, // store the integer read from the keyboard
			errors = 0; // count incorrect values entered by the user
		boolean isCurrentEven, isNewEven;
		int[] vector;

		// INSTRUCTIONS

		// ask the amount of numbers to be read
		System.out.print("How many integers do you want the sequence to have (it must be greater than or equal to 2)?... ");
		n = KEYBOARD.nextInt();
		vector = new int[n]; // by default all elements with value 0

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

		vector[0] = readNumber;
		
		// read the rest of the numbers from the keyboard. Since we know how many we have to read (n), we can use a for loop

		for (int num = 1; num < n; num++) {
			System.out.print("   Introduce an " + (isCurrentEven ? "odd " : "even ") + "integer " );
			readNumber = KEYBOARD.nextInt();
			isNewEven = (readNumber % 2 == 0) ? true : false;

			// Check if the condition about odd or even is met
			if (isCurrentEven != isNewEven) {
				vector[num] = readNumber;
				isCurrentEven = isNewEven;
			}
			else { 
				do {// repeat until the number meets the condition
					errors++;
					System.out.print("        You must introduce an " + (isCurrentEven ? "odd " : "even ") + "integer ");
					readNumber = KEYBOARD.nextInt();
					isNewEven = (readNumber % 2 == 0) ? true : false;
				} while (isCurrentEven == isNewEven);
				vector[num] = readNumber;
				isCurrentEven = isNewEven;
			}
		}
		System.out.print("The vector obtained is: [");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ", ");
		}
		System.out.println(vector[vector.length - 1] + "]");
		System.out.println("The number of errors when reading the values is: " + errors);

		// sum of even numbers and sum of odd numbers
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 0)
				evenSum = evenSum + vector[i];
			else
				oddSum = oddSum + vector[i];
		}
		System.out.println("The sum of even numbers is: " + evenSum);
		System.out.println("The sum of odd numbers is: "+ oddSum);
		System.out.println("\nEnd of the program...");
	}// end of main
}// end of program
