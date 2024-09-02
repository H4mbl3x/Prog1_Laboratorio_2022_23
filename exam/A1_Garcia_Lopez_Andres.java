package exams;

import java.util.Random;
import java.util.Scanner;

public class A1_Garcia_Lopez_Andres{
	
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

		int[] sumEachRow = new int[rows];
		for(int i=0;i<rows;i++)
			sumEachRow[i]=getSumRow(matrix,i);
			
		
		int[] sumEachColumn = new int[columns];
		for(int j=0;j<rows;j++)
			sumEachColumn[j]=getSumColumn(matrix,j);
		
		getMatch(sumEachRow, sumEachColumn, matrix);
		
		// END OF CODE TO BE IMPLEMENTED
	}
	
	// CODE TO BE IMPLEMENTED

	public static int getSumRow(int[][] matrix,int i) {
		int sum = 0;
		for(int j=0;j<matrix.length;j++) {
			sum += matrix[i][j];
		}
		return sum;
	}
	
	public static int getSumColumn(int[][] matrix,int j) {
		int sum = 0;
		for(int i=0;i<matrix[j].length;i++) {
			sum += matrix[i][j];
		}
		return sum;
	}
	
	public static void getMatch(int[] sumEachRow,int[] sumEachColumn, int[][] matrix) {
		boolean match = false;
		for(int i=0;i<sumEachRow.length;i++) {
			for(int j=0;j<sumEachColumn.length;j++) {
				if(sumEachRow[i]==sumEachColumn[j]) {
					match = true;
					System.out.print("\nThe row " + i + " and the column " + j + " have a matching sum: " + sumEachRow[i]);
					System.out.print("\nThe values of the row " + i + " are: ");
					getRowElements(matrix, i);
					System.out.print("\nThe values of the column " + j + " are: ");
					getColumnElements(matrix, j);
					System.out.println();
				}
			}
		}
		if(match==false)
			System.out.print("There are no matching of sums between rows and columns.");
	}
	
	public static void getRowElements(int[][] matrix, int i) {
		for(int j=0;j<matrix.length;j++)
			System.out.print(matrix[i][j] + " ");
	}
	
	public static void getColumnElements(int[][] matrix, int j) {
		for(int i=0;i<matrix[j].length;i++)
			System.out.print(matrix[i][j] + " ");
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
