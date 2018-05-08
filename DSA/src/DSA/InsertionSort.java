package DSA;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort arr=new InsertionSort();
		arr.Insertion_Sort();
		
	}
	private void Insertion_Sort(){
		int[] array={5,4,2,6,1,3};
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int swap=array[i];
					array[i]=array[j];
					array[j]=swap;
				}
			}
			
		}
		for(int k=0;k<array.length;k++){
			System.out.print(array[k]+" ");
		}
	}

}
