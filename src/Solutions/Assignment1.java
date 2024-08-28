package assignment1;

import java.util.*;

/**
  Write a program that reads the value of an integer X from the keyboard, calculates the 70% of that value and prints it out. Then, read another integer Y, and calculate the result of multiplying Y by the 70% of X: 
  •	¿What happened with the decimals in the operations? ¿Is the result correct?
  •	Keep the code you already have and add the code necessary to the program so that it transforms the integer X to a real number and perform again the previous calculations. ¿Is the new result correct?
  •	Add the code necessary so that the result of the operations above is shown on screen with 3 decimals.
  The program must be properly documented and facilitate user interaction.
 */


public class Assignment1 {

	final static Scanner KEYBOARD = new Scanner(System.in);
	final static int PERCENT = 70;
	
	public static void main(String[] args) {

		// data
		int integer, multiplier; 						
		double resultPercent, resultMultipl; 

		// instructions
		System.out.println("Enter an integer number ");
		integer = KEYBOARD.nextInt();
		
		resultPercent = (integer * PERCENT) / 100;
		System.out.println("     The " + PERCENT + "% of " + integer + " is: " + resultPercent);
		
		System.out.println("Introduce another integer number for the multiplier ");
		multiplier = KEYBOARD.nextInt();

		
		resultMultipl = resultPercent * multiplier;
		System.out.println("    The result of multiplying the " + PERCENT + "% of " + integer + " by " + multiplier+ " is: " + resultMultipl);
	
    //  Repeat the steps with real values
		
		System.out.println("      Repeat the steps avove, this time considering the number as real instead of integer: " + (double)integer);
		
		resultPercent = ((double)integer * PERCENT) / 100;
		System.out.println("     The " + PERCENT + "% of " + integer + " is: " + resultPercent);
		resultMultipl = resultPercent * multiplier;
		System.out.println("    The result of multiplying the " + PERCENT + "% of " + integer + " by " + multiplier+ " is: " + resultMultipl);

		// %% is used to print % on the screen
		System.out.printf("    The result of multiplying the %d%% of %d by %d is: %.3f ",PERCENT, integer, multiplier, resultMultipl);	
	}
}
