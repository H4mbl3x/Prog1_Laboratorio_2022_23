// Daniel Barchino Rodríguez-Caro
// Jorge Carrascosa Clemente
// Andrés García López
// Marcos Hurtado Morcillo

package session4;

import java.util.Scanner;

public class Session4Exercise1 {

	private static final Scanner KEYB = new Scanner(System.in);

	public static void main(String[] args) {
		int sequenceNumber, loopNumber, integer, odd = 0, even = 0, errors = 0;

		do {
			System.out.print(
					"How many integers do you want the sequence to have (it must be greater than or equal to 2) ");
			sequenceNumber = KEYB.nextInt();
		} while (sequenceNumber < 2);
		int[] sequenceVector = new int[sequenceNumber];
		System.out.print("Introduce the first integer: ");
		integer = KEYB.nextInt();
		sequenceVector[0] = integer;
		if (integer % 2 == 0)
			even = integer;
		else
			odd = integer;
		for (loopNumber = 1; loopNumber < sequenceVector.length; loopNumber++) {
			if (integer % 2 == 0) {
				System.out.print("Introduce an odd number ");
				integer = KEYB.nextInt();
				while (integer % 2 == 0) {
					errors++;
					System.out.print("You must introduce an odd number ");
					integer = KEYB.nextInt();
				}
				odd = odd + integer;
				sequenceVector[loopNumber] = integer;

			} else {
				System.out.print("Introduce an even number ");
				integer = KEYB.nextInt();
				while (integer % 2 != 0) {
					errors++;
					System.out.print("You must introduce an even number ");
					integer = KEYB.nextInt();
				}
				even = even + integer;
				sequenceVector[loopNumber] = integer;
			}

		}
		System.out.print("The vector obtained is: [");
		for (loopNumber = 0; loopNumber < sequenceVector.length; loopNumber++) {
			
			if (loopNumber == sequenceVector.length - 1)
				System.out.println(sequenceVector[loopNumber] + "]");
			else
				System.out.print(sequenceVector[loopNumber] + ", ");
		}
		System.out.println("The number of errors when reading the values is: " + errors);
		System.out.println("The sum of even numbers is " + even + " and the sum of odd numbers is " + odd);
	}

}
