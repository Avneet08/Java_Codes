package DSA;


public class MyArray {
	
	int[] my_array1={3,6,1,2,8};
	int[] array=new int[6];
	int[] array1=new int[7];
	
	public void copy(){
		
		System.out.print("copy-");
		for(int k=0;k<my_array1.length;k++){
			  System.out.print( my_array1[k]+" ");
		}
		System.out.print("\n");
		
	}
	public void Selection_Sort(){
		int[] my_array={5,2,4,6,1,3};
		for(int i=0;i<my_array.length-1;i++){
			int min=i;
			for(int j=i+1;j<my_array.length;j++){
				if(my_array[min]>my_array[j]){
					min=j;
					}
				}
			int k=my_array[i];
			my_array[i]=my_array[min];
			my_array[min]=k;
			
		}
		System.out.print("sorted arr-");
		for(int k=0;k<my_array.length;k++){
			System.out.print( my_array[k]+" ");
		}
		System.out.print("\n");
}
	public void linear_search(int b){
		int[] my_array={3,6,1,2,8};	
		for(int i=0;i<my_array.length;i++){
			if(my_array[i]==b){
				System.out.println("Search "+b+": Found at index "+(i+1));
			}
			
		}
		
	}
	public void insertion_start(int c){
			
		
		array[0]=c;
		for(int x=1;x<array.length+1;x++){
			for(int y=0;y<my_array1.length;y++){
				if(y==x-1){
					array[x]=my_array1[y];
				}
			}
		}
		
		System.out.print("array to start- ");
		for(int z=0;z<array.length;z++){
			System.out.print(array[z]+" ");
	}
		System.out.print("\n");
}
	public void insertion_end(int c){
		array1[6]=c;
			for(int x=0;x<array1.length+1;x++){
				for(int y=0;y<array.length;y++){
					if(y==x){
						array1[x]=array[y];
					}
			}
		}	
			
		System.out.print("array to end- ");
		for(int z=0;z<array1.length;z++){
			System.out.print(array1[z]+" ");
	}
}
		
	
	
}