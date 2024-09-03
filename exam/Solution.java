package exams;

import java.util.Random;
import java.util.Scanner;

public class January23_laboratory{
	
	final static Scanner KEYBOARD = new Scanner(System.in);
	final static Random RANDOM = new Random();
	
	final static int MIN_ROWS = 2;
	final static int MAX_ROWS = 6;
	final static int MIN_COLUMNS = 2;
	final static int MAX_COLUMNS = 6;

	public static void main(String[] args) {
		int rows, columns;
		int[][] matrix;
		int[] rowsSum, columnsSum;
		rows = askNumberInRange(MIN_ROWS, MAX_ROWS, "Introduce the number of rows for the matrix");
		columns = askNumberInRange(MIN_COLUMNS, MAX_COLUMNS, "Introduce the number of columns for the matrix");
		matrix = createMatrix(rows, columns);
		showMatrix(matrix);
		
		// CODE TO BE IMPLEMENTED
		rowsSum = getSumOfRows(matrix);
		columnsSum = getSumOfColumns(matrix);
		showMatchingSums(matrix, rowsSum, columnsSum);
		
		// END OF CODE TO BE IMPLEMENTED
	}
	
	// CODE TO BE IMPLEMENTED

	private static int[] getSumOfRows(int[][] matrix) {
		int[] res;
		res = new int[matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				res[i] += matrix[i][j];
			}
		}
		return res;
	}

	private static int[] getSumOfColumns(int[][] matrix) {
		int[] res;
		res = new int[matrix[0].length];
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				res[i] += matrix[j][i];
			}
		}
		return res;
	}

	private static void showMatchingSums(int[][] matrix, int[] rowsSums, int[] columnsSums) {
		boolean thereAreMatches = false;
		for(int i = 0; i < rowsSums.length; i++) {
			for(int j = 0; j < columnsSums.length; j++) {
				if(rowsSums[i] == columnsSums[j]) {
					System.out.println("The row " + i + " and the column " + j + " have a matching sum: " + rowsSums[i]);
					showRow(matrix, i);
					showColumn(matrix, j);
					System.out.println();
					thereAreMatches = true;
				}
			}
		}
		if(!thereAreMatches) {
			System.out.println("There are no matchings of sums between rows and columns");
		}
	}

	private static void showRow(int[][] matrix, int row) {
		System.out.print("The values of the row "+ row + " are: ");
		for(int j = 0; j < matrix[row].length; j++) {
			System.out.print(matrix[row][j] + " ");
		}
		System.out.println();
	}
	
	private static void showColumn(int[][] matrix, int column) {
		System.out.print("The values of the column " + column + " are: ");
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i][column] + " ");
		}
		System.out.println();
	}

	// END OF CODE TO BE IMPLEMENTED
	
	private static int askNumberInRange(int min, int max, String message) {
		int res;
		System.out.print(message + " [" + min + ", " + max + "]: ");
		res = KEYBOARD.nextInt();
		while(res < min || res > max) {
			System.out.print("    ERROR. " + message + " [" + min + ", " + max + "]: ");
			res = KEYBOARD.nextInt();
		}
		return res;
	}

	private static int[][] createMatrix(int rows, int columns) {
		int[][] res;
		res = new int[rows][columns];
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[0].length; j++) {
				res[i][j] = RANDOM.nextInt(10);
			}
		}
		return res;
	}

	private static void showMatrix(int[][] matrix) {
		System.out.println();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
