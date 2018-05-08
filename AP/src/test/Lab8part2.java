package test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class Lab8part2  {
	public static void main(String[] args) {
		Long n=(long) 1000;
		Long k=(long) 5;

			/*long startTime = System.currentTimeMillis();
			ForkJoinPool pool = new ForkJoinPool(1);
			
			CombinationPair task =  CombinationPair.getInstance(n,k);
			Long result = pool.invoke(task);
			System.out.println(result);
			long endTime   = System.currentTimeMillis();
			System.out.println(endTime-startTime);*/
			
			long startTime2 = System.currentTimeMillis();
			ForkJoinPool pool2 = new ForkJoinPool(2);
			
			CombinationPair task2 =  CombinationPair.getInstance(n,k);
			Long result2 = pool2.invoke(task2);
			System.out.println(result2);
			long endTime2   = System.currentTimeMillis();

			System.out.println(endTime2-startTime2);
			
			long startTime3 = System.currentTimeMillis();
			ForkJoinPool pool3 = new ForkJoinPool(3);
			
			CombinationPair task3 =  CombinationPair.getInstance(n,k);
			Long result3 = pool3.invoke(task3);
			System.out.println(result3);
			long endTime3   = System.currentTimeMillis();
			System.out.println(endTime3-startTime3);
	}

	
	
}
class CombinationPair extends RecursiveTask<Long>{
	private final Long n;private final Long k;
	Long result=(long) 0;

	private CombinationPair(Long n,Long k){
		this.n=n;
		this.k=k;
	}
	public Long getresult(){
		return this.result;
	}
	private	static	Map<String,	CombinationPair>	instances	=		
			new	HashMap<String,	CombinationPair>();
			public static CombinationPair getInstance(Long n,Long k)

			{

				String key = n + ", "+k;

				if(!instances.containsKey(key))

				{

					instances.put(key, new CombinationPair(n,k));

				}

				return instances.get(key);

			}


			public String toString()

			{

				String str = "(" + n + "," + k + ")";

				return str;

			}



			@Override

			protected Long compute() {

				if(n==0||k==0||n==k)

				{

					return (long) 1;

				}

				else

				{

					CombinationPair left = CombinationPair.getInstance(n-1, k-1);

					CombinationPair right = CombinationPair.getInstance(n-1, k);

					left.fork();

					return right.compute()+left.join();

				}


			}
}
