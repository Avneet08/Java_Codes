package pra;

public class rotation {
	public int[][] Transpose(int[][] matrix,int order){
		for(int i=0;i<order;i++){
			for(int j=i+1;j<order;j++){
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
				
			}
		}
		return matrix;
	}
	public int[][] MirrorHori(int[][] matrix,int order){
		for(int i=0;i<order/2;i++){
			for(int j=0;j<order;j++){
				int temp=matrix[j][i];
				matrix[j][i]=matrix[j][order-(i+1)];
				matrix[j][order-(i+1)]=temp;
				
			}
		}
		return matrix;
	}
	public void printmatrix(int[][] matrix,int order){
		for(int i=0;i<order;i++){
			for(int j=0;j<order;j++){
				System.out.print(matrix[i][j]+" ");
				
			}
			System.out.println(' ');
		}
	}
	public void rotationby90(int[][] matrix,int order){
		this.Transpose(matrix, order);
		this.MirrorHori(matrix, order);
		this.printmatrix(matrix, order);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{ 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int order=matrix.length;
		rotation b=new rotation();
		/*b.Transpose(matrix, order);
		
		b.MirrorHori(matrix, order);
		b.printmatrix(matrix, order);*/
		b.rotationby90(matrix, order);
		

	}

}
