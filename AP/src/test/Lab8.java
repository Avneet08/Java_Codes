package test;
import	java.util.concurrent.*;	
public class Lab8 extends	RecursiveTask<Integer>{
	int n;int k;
	
	public Lab8(int n,int k){
	this.n=n;
	this.k=k;
	}
	

	
	public Integer compute() {
		// TODO Auto-generated method stub
		if (n == 0 || k == 0 || n == k) {
			return 1;
			}
		Lab8 left=new Lab8(this.n-1,this.k-1);
		Lab8 right=new Lab8(this.n-1,this.k);
		left.fork();
		return	right.compute()	+	left.join();	
		
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool	pool	=	new	ForkJoinPool(2);	
		Lab8	task	=	new	Lab8(70,45);	
		
		int	result2	=	pool.invoke(task);	
		System.out.println(result2);
	}

}
