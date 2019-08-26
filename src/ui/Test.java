package ui;

import java.util.Random;

import model.SpaceWar;

public class Test {

	public static void main(String[] args) {
		SpaceWar sw = new SpaceWar();
		int[][] a = new int[4][4];
		int[][] b = new int[4][4];
		Random r = new Random();
		String A = "";
		String B = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = r.nextInt(100);
				A += a[i][j]+" ";
				b[i][j] = r.nextInt(100);
				B += b[i][j]+" ";
			}
			A+= "\n";
			B+= "\n";
		}
		System.out.println(A+"\n"+B);
		
		int[][] c = sw.strassen(a, b);
		int[][] d = sw.iterativeMultiplication(a, b);
		
		String C = "";
		String D = "";
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				C += c[i][j] + " ";
				D += d[i][j] + " ";
			}
			C+= "\n";
			D+= "\n";
		}
		System.out.println(C+"\n"+D);
		
		
		
		
		/*Random r = new Random();
		int[][] matrix = new int[1][15];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = r.nextInt(20);
			}
		}
		boolean[][] result = sw.findShips(matrix);
		for (int i = 0; i < result[0].length; i++) {
			System.out.print(result[0][i]+" ");
		}
		System.out.println();
		for (int i = 0; i < matrix[0].length; i++) {
			System.out.print(matrix[0][i]+" ");
		}*/
		
		

	}

}
