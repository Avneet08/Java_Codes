
public class Ass2 {
/*
 * Ques3 Assignment 2
 * Alice gave Bob a 2D box with the box divided into tiny 2D boxes called as pebbles and each
having a color. Alice gave a problem to Bob to replace color of a given pebble and all adjacent
same colored pebbles with given color. Bob is stuck and your goal is to design an algorithm for
him to solve his problem
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{2, 1, 1, 1, 1, 1, 1, 1},
				        {2, 2, 1, 1, 1, 2, 0, 0},
				        {1, 2, 2, 1, 1, 2, 2, 2},
				        {1, 2, 2, 2, 2, 2, 1, 2},
				        {1, 2, 2, 2, 2, 0, 1, 0}};
		System.out.println(matrix.length+" "+matrix[0].length);
		changecolor(matrix,3,4,7);
		for (int i = 0; i < matrix.length; i++) {
		    for (int j = 0; j < matrix[i].length; j++) {
		        System.out.print(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
	}

	private static int[][] changecolor(int[][] matrix, int i, int j, int k) {
		
		if(i+1>=matrix.length || j+1>=matrix[0].length || i-1==-1 || j-1==-1 ){
			System.out.println("hi");
			return matrix;
		}
		
		System.out.println(i+" "+j);
		int h=matrix[i][j];
		matrix[i][j]=k;
		
		 if(matrix[i][j-1]==h  ){
			System.out.println("kj "+i+" "+j);
			changecolor(matrix,i,j-1,k);
			 matrix[i][j-1]=k;
		}
		 if(matrix[i-1][j]==h  ){
				
				changecolor(matrix,i-1,j,k);
				 matrix[i-1][j]=k;
			}
		 if(matrix[i+1][j]==h  ){
				System.out.println("jf "+ i+" "+j);
				changecolor(matrix,i+1,j,k);
				 matrix[i+1][j]=k;
			}
		 
		if(matrix[i][j+1]==h ){
			
			changecolor(matrix,i,j+1,k);
			 matrix[i][j+1]=k;
		}
		return matrix;
		
	}

}
