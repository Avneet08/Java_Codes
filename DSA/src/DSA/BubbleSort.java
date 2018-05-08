package DSA;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort arr=new BubbleSort();
		arr.Bubble_Sort();
		// TODO Auto-generated method stub

	}
	private static void Bubble_Sort(){
		int[] arr={3,7,2,8,5,1,9,4};
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int k=arr[i];
					arr[i]=arr[j];
					arr[j]=k;
				}
			}
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
		
	}


