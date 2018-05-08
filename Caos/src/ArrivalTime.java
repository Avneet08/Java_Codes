import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class ArrivalTime extends Random{
	
	 static Random random = new Random();
	    public static int generatePoissonDeviate(double a)
	    {
	        double limit = Math.exp(-a);
	        double product = random.nextDouble();
	        int n;
	        for (n = 0; product >= limit; n++)
	        {
	            product *= random.nextDouble();
	        }
	        //System.out.println("Product is"+product);
	        return n;
	    }
	    
	public double poissonRandomInterarrivalDelay(double L) {
	    return (Math.log(1.0-Math.random())/-L);
	}
	public static double nextExponential(double b) {
    	double randx;
		 double result;
		randx = Math.random();
		result = -1*b*Math.log(randx);
		return result;
		
    }
	   
	public static void main(String[] args) throws InterruptedException  {
		/*double x=150;
		ArrivalTime c=new ArrivalTime();
		int y=0;
		ArrayList<Long> at=new ArrayList<Long>();
		
		//long startTime = System.currentTimeMillis();
		long startTime= System.currentTimeMillis();
		long end = startTime+5000;
		while(System.currentTimeMillis()<end)
		{
			 long intu=(long)generatePoissonDeviate(x);
			 Thread.sleep(100);
	           System.out.println(intu);
	             at.add(intu);
			//System.out.println(startTime +" "+System.currentTimeMillis()+" "+end);
			}
		
        System.out.println(at.size());*/
		//System.out.println(y);
		//System.out.println(c.nextPoisson(x));
		ArrivalTime c=new ArrivalTime();
		/*ArrayList<Long> at=new ArrayList<Long>();
		
		double x=(100.0/9000.0);
		int y=0;
		int t=0;
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis()<startTime+9000)
		{
			long interval= (long)c.poissonRandomInterarrivalDelay(x);
			Thread.sleep(50);
			System.out.println(interval);
			
			y++;
			at.add(interval);}
		
			
		System.out.println(at.size());
		System.out.println(y);*/
		ArrayList<Long> at=new ArrayList<Long>();
		ArrayList<Double> bt=new ArrayList<Double>();
		double b=(25);
		int y=0;int z=0;
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis()<startTime+9000)
		{
			long interval= (long)c.poissonRandomInterarrivalDelay(b);
			Thread.sleep(1);
			//System.out.println(interval);
			
			z++;
			at.add(interval);
			double value=c.nextExponential(b);
			Thread.sleep(1);
			//System.out.println(value);
			y++;
			bt.add(value);}
		/*long startTime2 = System.currentTimeMillis();
		while(System.currentTimeMillis()<startTime2+9000)
		{
			
		}*/
		
		//System.out.println("z ydb dbjd"+z );
		
		at.forEach(System.out::println);
		System.out.println("z ydb dbjd"+z );
System.out.println('\n');
System.out.println('\n');
System.out.println('\n');
System.out.println('\n');
		bt.forEach(System.out::println);
		System.out.println("ydb dbjd"+y );
		

	}
}