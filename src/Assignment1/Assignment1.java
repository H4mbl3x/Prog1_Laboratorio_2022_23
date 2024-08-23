// Daniel Barchino Rodríguez-Caro
// Jorge Carrascosa Clemente
// Andrés García López
// Marcos Hurtado Morcillo

package session1;
import java.util.Scanner;

public class Assignment1 {
	private static final Scanner KEYBOARD = new Scanner(System.in);
	public static void main(String[] args) {
		// EXERCISE
		/* Write a program that reads the value of an integer X from the keyboard,
		   calculates the 70% of that value and prints it out.
		   Then, read another integer Y, and calculate the result of multiplying Y by the 70% of X */
		
		int first, second, firstResult, secondResult;
		/* Variables uses:
		    - first: The first number given
		    - second: The second number given
		    - firstResult: It will stores the 70% of the first number
		    - secondResult: It will stores the product of the second number * (70% of the first one)
		*/
		System.out.println("Tell me an integer");
		first = KEYBOARD.nextInt(); // Stores the first number
		firstResult = first * 70 / 100; // The 70% of the given number
		System.out.println("The 70% of " + first + " is " + firstResult); // Answer output
		System.out.println("\n------------------\n"); // Separation decoration
		System.out.println("Tell me another integer");
		second = KEYBOARD.nextInt(); //Stores the second number
		secondResult = second * firstResult; // The given number * (70% of the first number)
		System.out.println("The result of " + second + " * (70% of " + first + ") is " + secondResult); // Answer output
		
		// Question: What happened with the decimals in the operations?
		// Answer: We suffered loss of information, specifically the decimal part of the results.
		// Question: Is the result correct?
		// Answer: No, we receive an integer as output and the correct result is an real number.
		
		// Separation decoration
		System.out.println("\n**********************");
		System.out.println("* Now with decimals! *");
		System.out.println("**********************\n");
		
		
		/* Keep the code you already have and add the code necessary to the program so that
		   it transforms the integer X to a real number and perform again the previous calculations. */
		
		float firstFloat, secondFloat, firstResultFloat, secondResultFloat;
		/* Variables uses:
			- firstFloat: The first number given
	    	- secondFloat: The second number given
	    	- firstResultFloat: It will stores the 70% of the first number
	    	- secondResultFloat: It will stores the product of the second number * (70% of the first one)
		*/
		System.out.println("Tell me a number");
		firstFloat = KEYBOARD.nextFloat(); // Stores the first number
		firstResultFloat = firstFloat * 70 / 100; // The 70% of the given number
		System.out.println("The 70% of " + firstFloat + " is " + firstResultFloat); // Answer output
		System.out.println("\n------------------\n"); // Separation decoration
		System.out.println("Tell me another number");
		secondFloat = KEYBOARD.nextInt(); //Stores the second number
		secondResultFloat = secondFloat * firstResultFloat; // The given number * (70% of the first number)
		System.out.println("The result of " + firstFloat + " * (70% of " + secondFloat + ") is " + secondResultFloat); // Answer output
		
		// Question: Is the new result correct?
		// Answer: Now that the output is a float, the result is correct.
		
		System.out.println("\n******************\n"); // Separation decoration
		
		// Add the code necessary so that the result of the operations above is shown on screen with 3 decimals
		System.out.printf("The 70%% of %.0f is %.3f\n", firstFloat, firstResultFloat);
		System.out.printf("The result of %.0f * (70%% of %.0f) is %.3f", firstFloat, secondFloat, secondResultFloat);
	}
}
