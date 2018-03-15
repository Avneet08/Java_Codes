import java.util.*;
import java.io.IOException;
import java.lang.Math;
public class FIFO2 {
	public double poissonRandomInterarrivalDelay(double L) {
	    return (Math.log(1.0-Math.random())/-L);
	}
	public double nextExponential(double b) {
    	double randx;
		 double result;
		randx = Math.random();
		result = -1*b*Math.log(randx);
		return result;
		
    }
	/*public void sizeequal(ArrayList<Double> bt, ArrayList<Long> at){
		int l=bt.size();
		int y=at.size();
		if(l>y){
			for(int i=y;i<l;i++){
				bt.remove(i);
			}
		}else if(y>l){
			for(int i=l;i<y;i++){
				at.remove(i);
			}
			
		}
	}*/
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FIFO2 c=new FIFO2();
		ArrayList<Long> arrivalt=new ArrayList<Long>();
		ArrayList<Double> burstt=new ArrayList<Double>();
		ArrayList<Double> avgwaitingt=new ArrayList<Double>();
		ArrayList<Double> turnaroundt=new ArrayList<Double>();
		Scanner sc=new Scanner(System.in);  
		System.out.println("Enter the initial running time");  
		   int time=sc.nextInt();  
		   double x=(100.0/1000.0*time);
		   long startTime= System.currentTimeMillis();
			long end = startTime+1000*time;
			
			while(System.currentTimeMillis()<end)
			{long interval= (long)c.poissonRandomInterarrivalDelay(x);
			Thread.sleep(1);
			//System.out.println(interval);
			arrivalt.add(interval);
			}
			int sizeat=0;
			int b=25;
			while(sizeat<arrivalt.size())
			{
				double value=c.nextExponential(b);
				Thread.sleep(1);
				//System.out.println(value);
				burstt.add(value);
				sizeat++;
			}
			System.out.println(arrivalt.size());
			System.out.println(burstt.size());
				double s=0;
				double t=0;
				//while(System.currentTimeMillis()<end2){
		avgwaitingt.add(0.0);
		System.out.println(avgwaitingt.size());
		for(int i=1;i<arrivalt.size();i++) 
		{ 
			avgwaitingt.add(i,avgwaitingt.get(i-1)+burstt.get(i-1) ); 
			double j=avgwaitingt.get(i);
			//avgwaitingt.set(i,j+arrivalt.get(i-1) ); 
			s=s+j;
		}
		for(int i=0;i<arrivalt.size();i++) 
		{ 
			double o=avgwaitingt.get(i);
			turnaroundt.add(i,o+burstt.get(i) ); 
			double j=turnaroundt.get(i);
			 t+=j;
		} 
		System.out.println("  ArrivalTime\t\tBURST-TIME\tWAITING-TIME\tTURN AROUND-TIME\n"); 
		for(int i=0;i<arrivalt.size();i++) 
		{
		System.out.println("          "+ i+" " + "\t\t"+burstt.get(i)+"\t"+avgwaitingt.get(i)+"\t"+turnaroundt.get(i));
		} 
		s=s/arrivalt.size()*1000; 
		

				System.out.println("Average waiting time is"+s);
				System.out.println("Average Tat is"+ t);
				System.out.println(avgwaitingt.size()+" "+turnaroundt.size());
	}
}
