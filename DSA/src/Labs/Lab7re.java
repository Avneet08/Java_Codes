package Labs;
class Stack{
int stack[]=new int[100000000];
int top=-1;
int pop(){
return stack[top--];
}

int peek(){
return stack[top];
}

boolean isEmpty(){
return (top==-1)?true:false;
}

void push(int c){
stack[++top]= c;
}

}	
public class Lab7re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;

        System.out.printf("Factorial %d = %s%n", n, factorial(n));
	}
	public static String factorial(int n) {
        return factorial(n,10000000);
    }
	private static String factorial(int n,int maxsize) {
		Stack res=new Stack();
		res.push(1);
		int res_size=1;
		for(int x=2;x<=n;x++){
			res_size=multiply(2, res, res_size);
		}
		
		StringBuffer buff1 = new StringBuffer();
		while(!res.isEmpty()){
			 buff1.append(res.pop());
		}
		return buff1.toString();
		
		}
	private static int multiply(int x,Stack res, int res_size) {
		int carry = 0; // Initialize carry.

        // One by one multiply n with individual digits of res[].
        for (int i = 0; i < res_size; i++) {
            int prod = res.pop() * x + carry;
            res.push(prod % 10);  // Store last digit of 'prod' in res[]
            carry = prod / 10;  // Put rest in carry
        }
        while (carry != 0) {
            res .push(carry % 10);
            carry = carry / 10;
            res_size++;
        }
        return res_size;
	}

}
