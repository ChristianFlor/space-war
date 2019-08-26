package model;

import java.util.Random;

public class SpaceWar {
	
	public SpaceWar() {
		
	}
	/**Method: Creates a matrix with random Numbers
	 * 
	 * @param rows
	 * @param columns
	 * @param repetition
	 * @return Matrix with random numbers
	 */
	public int[][] randomMatrix(int rows, int columns, boolean repetition){
		if(repetition) {
			return randomMatrixWithRepetition(rows, columns);
		} else {
			return randomMatrixWithoutRepetition(rows, columns);
		}
	}
	/**Auxiliary Method: Creates a matrix with random numbers,
	 * Allows numbers to be repeated.
	 * @param rows
	 * @param columns
	 * @return Matrix with random numbers
	 */
	public int[][] randomMatrixWithRepetition(int rows, int columns) {
		Random r = new Random();
		int[][] matrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = r.nextInt();
			}
		}
		return matrix;
	}
	/**Auxiliary Method:  Creates a matrix with random numbers,
	 * Inhibits the creation of a matrix with repeated numbers.
	 * @param rows
	 * @param columns
	 * @return Matrix with random numbers
	 */
	public int[][] randomMatrixWithoutRepetition(int rows, int columns){
		Random r = new Random();
		int[] values = new int[rows*columns];
		int[][] matrix = new int[rows][columns];
		for(int i = 0; i < rows*columns; i++) {
			boolean repetition = true;
			int n = r.nextInt();
			while(repetition) {
				repetition= false;
				for(int j = 0; j < i && !repetition; j++) {
					 if(n==values[j]) {
						 repetition = true;
						 n = r.nextInt();
					 }
				}
			}
			
		}
		return matrix;
	}
	/**Method: Applied the Strassen's Algorithm for multiplying matrices.
	 * 
	 * @param a : Matrix a
	 * @param b : Matrix b
	 * @return The result of the operation between matrices.
	 */
	public int [][] strassen(int [][] a, int [][] b)
	{
		int n = a.length;
		int [][] result = new int[n][n];

		if((n%2 != 0 ) && (n !=1))
		{
			int[][] a1, b1, c1;
			int n1 = n+1;
			a1 = new int[n1][n1];
			b1 = new int[n1][n1];
			c1 = new int[n1][n1];

			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				{
					a1[i][j] =a[i][j];
					b1[i][j] =b[i][j];
				}
			c1 = strassen(a1, b1);
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					result[i][j] =c1[i][j];
			return result;
		}

		if(n == 1)
		{
			result[0][0] = a[0][0] * b[0][0];
		}
		else
		{
			int [][] A11 = new int[n/2][n/2];
			int [][] A12 = new int[n/2][n/2];
			int [][] A21 = new int[n/2][n/2];
			int [][] A22 = new int[n/2][n/2];

			int [][] B11 = new int[n/2][n/2];
			int [][] B12 = new int[n/2][n/2];
			int [][] B21 = new int[n/2][n/2];
			int [][] B22 = new int[n/2][n/2];

			divide(a, A11, 0 , 0);
			divide(a, A12, 0 , n/2);
			divide(a, A21, n/2, 0);
			divide(a, A22, n/2, n/2);

			divide(b, B11, 0 , 0);
			divide(b, B12, 0 , n/2);
			divide(b, B21, n/2, 0);
			divide(b, B22, n/2, n/2);

			int [][] P1 = strassen(add(A11, A22), add(B11, B22));
			int [][] P2 = strassen(add(A21, A22), B11);
			int [][] P3 = strassen(A11, sub(B12, B22));
			int [][] P4 = strassen(A22, sub(B21, B11));
			int [][] P5 = strassen(add(A11, A12), B22);
			int [][] P6 = strassen(sub(A21, A11), add(B11, B12));
			int [][] P7 = strassen(sub(A12, A22), add(B21, B22));

			int [][] C11 = add(sub(add(P1, P4), P5), P7);
			int [][] C12 = add(P3, P5);
			int [][] C21 = add(P2, P4);
			int [][] C22 = add(sub(add(P1, P3), P2), P6);

			copy(C11, result, 0 , 0);
			copy(C12, result, 0 , n/2);
			copy(C21, result, n/2, 0);
			copy(C22, result, n/2, n/2);
		}
		return result;
	}
	/**Auxiliary Method: Add operation in matrix
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private int [][] add(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] + B[i][j];

		return result;
	}
	/**Auxiliary Method: Subtract operation in matrix
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private int [][] sub(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] - B[i][j];

		return result;
	}
	/**Auxiliary method: co-factor reduction for Divide and Conquer
	 * 
	 * @param p1
	 * @param c1
	 * @param iB
	 * @param jB
	 */
	private void divide(int[][] p1, int[][] c1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				c1[i1][j1] = p1[i2][j2];
			}
	}
	/**auxiliary method: Copy operation
	 * 
	 * @param c1
	 * @param p1
	 * @param iB
	 * @param jB
	 */
	private void copy(int[][] c1, int[][] p1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				p1[i2][j2] = c1[i1][j1];
			}
	}
	/**Method: Multiplication of matrices with the method
	 * Divide and Conquer
	 * 
	 * @param A
	 * @param B
	 * @return Result of the product of the matrices
	 */
	public int[][] divideAndConquerMultiply(int[][] A, int[][] B) {
		validateDimensionsDivideAndConquer(A, B);
		return divideAndConquerMultiplyRecursive(A, B);
	}
	/**Method: Divide and Conquer algorithm for multiplying matrices
	 * 
	 * @param A
	 * @param B
	 * @return Result of the product of the matrices
	 */
	private int[][] divideAndConquerMultiplyRecursive(int[][] A, int[][] B) {
		int n = A.length;
		int[][] result = new int[n][n];
		if(n == 1) {
			result[0][0] = A[0][0] * B[0][0];
		} else {
			int[][] A1 = new int[n/2][n/2];
			int[][] A2 = new int[n/2][n/2];
			int[][] A3 = new int[n/2][n/2];
			int[][] A4 = new int[n/2][n/2];
			
			int[][] B1 = new int[n/2][n/2];
			int[][] B2 = new int[n/2][n/2];
			int[][] B3 = new int[n/2][n/2];
			int[][] B4 = new int[n/2][n/2];
			
			divide(A1, A, 0, 0);
			divide(A2, A, 0, n/2);
			divide(A3, A, n/2, 0);
			divide(A4, A, n/2, n/2);
			
			divide(B1, B, 0, 0);
			divide(B2, B, 0, n/2);
			divide(B3, B, n/2, 0);
			divide(B4, B, n/2, n/2);
			
			int[][] C1 = addDC(divideAndConquerMultiply(A1, B1), divideAndConquerMultiply(A2, B3));
			int[][] C2 = addDC(divideAndConquerMultiply(A1, B2), divideAndConquerMultiply(A2, B4));
			int[][] C3 = addDC(divideAndConquerMultiply(A3, B1), divideAndConquerMultiply(A4, B3));
			int[][] C4 = addDC(divideAndConquerMultiply(A3, B2), divideAndConquerMultiply(A4, B4));
			
			join(C1, result, 0, 0);
			join(C2, result, 0, n/2);
			join(C3, result, n/2, 0);
			join(C4, result, n/2, n/2);
		}
		return result;
	}
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] addDC(int[][] A, int[][] B) {
		int rows = A.length;
		int cols = A[0].length;
		int[][] C = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	/**
	 * 
	 * @param submatrix
	 * @param matrix
	 * @param row
	 * @param column
	 */
	private void join(int[][] submatrix, int[][] matrix, int row, int column) {
		int n = submatrix.length;
        for(int i1 = 0, i2 = row; i1 < n; i1++, i2++) {
            for(int j1 = 0, j2 = column; j1 < n; j1++, j2++) {
                matrix[i2][j2] = submatrix[i1][j1];
            }
        }
    }
	/**Auxiliary method: Validates if the matrices have the correct dimension
	 * to apply the Divide and Conquer algorithm
	 * @param A
	 * @param B
	 */
	public void validateDimensionsDivideAndConquer(int[][] A, int[][] B) {
		validateDimensions(A, B);
		double log2 = Math.log10(A.length)/Math.log10(2);
		if((int)log2 - log2 != 0 ||
				A.length != B[0].length ||
				A[0].length != B.length ||
				A.length != A[0].length) {
			throw new IllegalArgumentException("Incompatible dimensions for divide and conquer algorithm: A(" + A.length + "," + A[0].length + ") and B(" + B.length + "," + B[0].length + ")");
		}
	}
	
	private void validateDimensions(int[][] A, int[][] B) {
		if(A.length != B[0].length || A[0].length != B.length) {
			throw new IllegalArgumentException("Incompatible dimensions: A(" + A.length + "," + A[0].length + ") and B(" + B.length + "," + B[0].length + ")");
		}
	}
	/**Method: Finds the location of the ships in the matrix by finding
	 * the prime numbers in it.
	 * @param warField
	 * @return a matrix with booleans on whether a ship is in a cell of the grid.
	 */
	public boolean[][] findShips(int[][] warField) {
		int rows = warField.length;
		int columns = warField[0].length;
		int biggest = searchBiggestNumberInMatrix(warField);
		int[] primesTillBiggest = findPrimes(biggest);
		boolean[][] realUbications = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(searchInPrimes(warField[i][j], primesTillBiggest)) {
					realUbications[i][j] = true;
				}
			}
		}
		return realUbications;
	}
	/**Method: Finds prime numbers
	 * 
	 * @param n
	 * @return
	 */
	public int[] findPrimes(int n) {
        boolean arePrimes[] = new boolean[n]; 
        for(int i=0;i<n;i++) 
        	arePrimes[i] = true;
        int notPrimescounter = 0;
        for(int p = 2; p*p < n; p++) { 
        	if(arePrimes[p]) {
            	for(int i = p*2; i < n; i += p) { 
            		arePrimes[i] = false;
                	notPrimescounter++;
        		}
            }
        }
        int[] primes = new int[n-notPrimescounter];
        for (int i = 2, j = 0; i < arePrimes.length; i++) {
			if(arePrimes[i]) {
				primes[j] = i;
				j++;
			}
		}
		return primes;
    }
	/**Method: finds the highest numeber in an algorithm
	 * 
	 * @param matrix
	 * @return highest number in matrix
	 */
	public int searchBiggestNumberInMatrix(int[][] matrix) {
		int biggest = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] > biggest) {
					biggest = matrix[i][j];
				}
			}
		}
		return biggest;
	}
	/**
	 * 
	 * @param n
	 * @param numbers
	 * @return
	 */
	public boolean searchInPrimes(int n, int[] numbers) {
		int high = numbers.length;
		int low = 0;
		while(low <= high) {
			int mid = (high+low)/2;
			if(n < numbers[mid]) {
				high = mid - 1;
			} else if(n > numbers[mid]){
				low = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
	
}
