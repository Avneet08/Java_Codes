package DSA;

public class InsertionShift {
	
	
	public static void main(String[] args) {
		InsertionShift hi=new InsertionShift();
		hi.Shift();
		// TODO Auto-generated method stub

	}
	void Shift(){
		
		int[] a=new int[5];
		a[0]=4;
		a[1]=8;
		a[2]=11;
		int[] c={1,7};
		int d=0;
		if(c[0]==1){
			int v=0;
			for(int x=0;x<a.length ;x++){
				if(a[x]>c[1]){
					
					 v=x;
					 break;
				}
				
			for(int i=a.length-1;i<x-1;i--){
						a[i+1]=a[i];
						
					}
				a[v-1]=c[0];
					a[v]=c[1];
					d=a.length-(x+1);
				 
					}
			
			}
			System.out.println(a.length+" "+d);
			for(int i=0;i<a.length;i++){
				System.out.println(a[i]);	
			
		}
	
		
		
		}
		
			
	}
	

