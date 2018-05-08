import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class FIFO {
	static Random random = new Random();
    public static int generatePoissonDeviate(double a)
    {
        double limit = Math.exp(-a);
        double product = random.nextDouble();
        System.out.println(product);
        int n;
        for (n = 0; product >= limit; n++)
        {
            product *= random.nextDouble();
        }
        System.out.println("Product is"+product);
        return n;
    }
	public static void main(String[] args) throws IOException  {
		//generatePoissonDeviate(98);
		ArrayList<Integer> bs=new ArrayList<Integer>();
		bs.add(1);
		bs.add(2);
		bs.add(5);
		bs.add(9);
		bs.add(90);
		bs.add(19);
		bs.add(939);
		bs.forEach(System.out::println);
		bs.set(3, bs.get(3)+17);
		bs.forEach(System.out::println);
		/*int time=5;
		long startTime2= System.currentTimeMillis();
		long end2= startTime2+time*6000;
		int y=0;*/
		
		
		
	}
}
