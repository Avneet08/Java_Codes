package myProject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ans2_b implements java.lang.Runnable  {
	
static	volatile	int	counter	=	0;	
private	Object	lock	=	new	Object();	
//public	synchronized	static	void	increment()	{counter++;}	
public	void	run()	{	/*increment();*/synchronized(lock)	{	
	counter++;		
}		}	
public	static	void	main(String[]	args)		
		throws	InterruptedException	{	
	ExecutorService	exec =Executors.newFixedThreadPool(2);	
	ans2_b	task	=	new	ans2_b();	
	for(int i=0;	i<1000;	i++)	{	
		exec.execute(task);	
	}	
	if(!exec.isTerminated())	{	
		exec.shutdown();	
		exec.awaitTermination(5L,TimeUnit.SECONDS);	
	}									
	System.out.println(task.counter);	
}
}