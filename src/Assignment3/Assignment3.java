// Daniel Barchino Rodríguez-Caro, Jorge Carrascosa Clemente, Andrés García López, Marcos Hurtado Morcillo

package session3;

import java.util.Scanner;

public class Assignment3 {

	private static final Scanner KEYB = new Scanner(System.in);

	public static void main(String[] args) {

		int sequenceNumber, loopNumber, integer, odd = 0, even = 0, errors = 0;

		do {
			System.out.print(
					"How many integers do you want the sequence to have (it must be greater than or equal to 2) ");
			sequenceNumber = KEYB.nextInt();
		} while (sequenceNumber < 2);
		System.out.print("Introduce the first integer: ");
		integer = KEYB.nextInt();
		System.out.println("The integer #1 in the sequence is: " + integer);
		if (integer % 2 == 0)
			even = integer;
		else
			odd = integer;
		for (loopNumber = 2; loopNumber <= sequenceNumber; loopNumber++) {
			if (integer % 2 == 0) {
				System.out.print("Introduce an odd number ");
				integer = KEYB.nextInt();
				while (integer % 2 == 0) {
					errors++;
					System.out.print("You must introduce an odd number ");
					integer = KEYB.nextInt();
				}
				odd = odd + integer;
				System.out.println("The integer #" + loopNumber + " in the sequence is: " + integer);

			} else {
				System.out.print("Introduce an even number ");
				integer = KEYB.nextInt();
				while (integer % 2 != 0) {
					errors++;
					System.out.print("You must introduce an even number ");
					integer = KEYB.nextInt();
				}
				even = even + integer;
				System.out.println("The integer #" + loopNumber + " in the sequence is: " + integer);
			}

		}
		System.out.println("The number of errors when reading the values is: " + errors);
		System.out.println("The sum of even numbers is " + even + " and the sum of odd numbers is " + odd);
	}

}
