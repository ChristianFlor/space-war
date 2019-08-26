package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import spacewar.SpaceWarTest;

class TestCase {
	
	SpaceWarTest test;
	
	void setupScenary1(){
		test = new SpaceWarTest();
	}

	@Test
	void randomMatrixTest1() {
		setupScenary1();
		int numRow=2,numCol = 2;
		boolean rep = false;
		int [][] matrix = test.randomMatrix(numRow, numCol, rep);
		assertTrue(matrix!=null);
	}
	@Test
	void randomMatrixTest2() {
		setupScenary1();
		int numRow=2,numCol = 2;
		boolean rep = true;
		int [][] matrix = test.randomMatrix(numRow, numCol, rep);
		assertTrue(matrix!=null);
	}
	
	@Test
	void productMatrixTest1() {
		setupScenary1();
		int[][] mat1 = new int[2][2];
		int[][] coef = new int [2][2];
		mat1[0][0]=5;
		mat1[0][1]=1;
		mat1[1][0]=7;
		mat1[1][1]=1;
		coef[0][0]=1;
		coef[0][1]=2;
		coef[1][0]=2;
		coef[1][1]=1;
		int[][] res =test.strassen(mat1, coef);
		System.out.println(res[0][0]);
		System.out.println(res[0][1]);
		System.out.println(res[1][0]);
		System.out.println(res[1][1]);
		assertTrue(res[0][0]==7);
		assertTrue(res[0][1]==11);
		assertTrue(res[1][0]==9);
		assertTrue(res[1][1]==15);
	}
	@Test
	void productMatrixTest2() {
		setupScenary1();
		int[][] mat1 = new int[2][3];
		int[][] coef = new int [2][2];
		mat1[0][0]=1;
		mat1[0][1]=1;
		mat1[0][2]=1;
		mat1[1][0]=1;
		mat1[1][1]=1;
		mat1[1][2]=1;
		coef[0][0]=1;
		coef[0][1]=1;
		coef[1][0]=1;
		coef[1][1]=1;
		int[][] res =test.strassen(mat1, coef);
		//System.out.println(res);
	}
	@Test
	void productMatrixTest3() {
		setupScenary1();
		int[][] mat1 = new int[2][2];
		int[][] coef = new int [2][2];
		mat1[0][0]=5;
		mat1[0][1]=1;
		mat1[1][0]=7;
		mat1[1][1]=1;
		coef[0][0]=1;
		coef[0][1]=1;
		coef[1][0]=1;
		coef[1][1]=1;
		int[][] res =test.divideAndConquerMultiplication(mat1, coef);
		assertTrue(res[0][0]==7);
		assertTrue(res[0][1]==11);
		assertTrue(res[1][0]==15);
		assertTrue(res[1][1]==9);
	}
	@Test
	void productMatrixTest4() {
		setupScenary1();
		int[][] mat1 = new int[2][3];
		int[][] coef = new int [2][2];
		mat1[0][0]=1;
		mat1[0][1]=1;
		mat1[0][2]=1;
		mat1[1][0]=1;
		mat1[1][1]=1;
		mat1[1][2]=1;
		coef[0][0]=1;
		coef[0][1]=1;
		coef[1][0]=1;
		coef[1][1]=1;
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			test.divideAndConquerMultiplication(mat1, coef);
		});
	}
	@Test
	void primeNumberSearchTest1() {
		setupScenary1();
		int[][] warfield= new int[2][2];
		warfield[0][0]=3;
		warfield[0][1]=3;
		warfield[1][0]=3;
		warfield[1][1]=3;
		boolean[][] res = test.findShips(warfield);
		assertTrue(res[0][0]==true);
		assertTrue(res[0][1]==true);
		assertTrue(res[1][0]==true);
		assertTrue(res[1][1]==true);
	}
	
	
	@Test
	void searchHighestTest1() {
		setupScenary1();
		int[][] matrix= new int[2][2];
		matrix[0][0]=1;
		matrix[0][1]=1;
		matrix[1][0]=5;
		matrix[1][1]=1;
		assertTrue(test.searchBiggestNumberInMatrix(matrix)==5);
	}
}
