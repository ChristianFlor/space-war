package model;

import java.util.Random;

public class SpaceWar {

	private int[][] coefficientMatrix;
	
	public SpaceWar() {
		
	}
	
	public void randomMatrix(int rows, int columns, boolean repetition){
		
	}
	
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
	
}
