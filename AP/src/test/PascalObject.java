package test;

import java.util.HashMap;

import java.util.Map;

import java.util.concurrent.ForkJoinPool;

import java.util.concurrent.RecursiveTask;



public class PascalObject  extends RecursiveTask<Integer>{


	private final int n ,k ;	//immutable


	private static Map<String, PascalObject> instances  = new HashMap<String,PascalObject>();


	public static PascalObject getInstance(int n,int k)

	{

		String key = n + ", "+k;

		if(!instances.containsKey(key))

		{

			instances.put(key, new PascalObject(n,k));

		}

		return instances.get(key);

	}


	private PascalObject(int n,int k)

	{

		this.n = n;

		this.k = k;

	}


	public String toString()

	{

		String str = "(" + n + "," + k + ")";

		return str;

	}



	@Override

	protected Integer compute() {

		if(n==0||k==0||n==k)

		{

			return 1;

		}

		else

		{

			PascalObject left = PascalObject.getInstance(n-1, k-1);

			PascalObject right = PascalObject.getInstance(n-1, k);

			left.fork();

			return right.compute()+left.join();

		}



	}




	public static void main(String[] args)

	{

		long startTime = System.currentTimeMillis();



		ForkJoinPool pool = new ForkJoinPool(1);

		PascalObject task =  PascalObject.getInstance(1000, 200);



		int result = pool.invoke(task);

		System.out.println(result);

		long endTime   = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		System.out.println(totalTime);

	}



}