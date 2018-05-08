package DSA;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearch b=new BinarySearch();
		b.Binary_Search(8);
	}
	public void Binary_Search(int a){
		int[] my_array={3,6,1,2,8};
		Arrays.sort(my_array);
		int first=0;
		int last=my_array.length -1;
		int middle=(first+last)/2;
		while(first<=last){
			if(my_array[middle]<a){
				first=middle+1;
			}
			else if(my_array[middle]>a){
				last=middle-1;
				middle=(first+last)/2;
			}
			else{
				System.out.println("binary search "+a+" :found at index "+middle);
				break;
			}
		}
		if(first>last){
			System.out.println("not found");
		}
		
		}
		
}


