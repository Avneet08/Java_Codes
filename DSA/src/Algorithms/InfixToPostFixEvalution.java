package Algorithms;
//Avneet kaur
//2016233
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


class Stack{
  int maxsize=1000000000;
  char stack[]=new char[maxsize];
int top=-1;
char pop(){
return stack[top--];
}

char peek(){
return stack[top];
}

boolean isEmpty(){
return (top==-1)?true:false;
}

void push(char c){
stack[++top]= c;
}
 boolean isFull() // true if stack is full
{
return (top == maxsize-1);
}

}	

public class InfixToPostFixEvalution {
	private static boolean isOperator(char a) {
        return a == '-' || a == '+' || a == '/' || a == '*' || a == '^' || a == '(' || a == ')'||a==',' ;
    }
	

    private static int PrecedenceOrder(char j) {
    	// the precedence order is changed as according to the instructions
    	if(j=='/' || j=='-'){
    		return 3;
    	}
    	else if(j=='*' || j=='+'){
    		return 2;
    	}
    	else if(j=='~' ){
    		return 1;
    	}
    	else if(j==','){
    		return 4;
    	}
    	return 0;
        
    }

  public static String convertToPostfix(String infixexp) {
        Stack stack = new Stack();
        StringBuffer postfixform = new StringBuffer(infixexp.length());
        char z;
        for (int i = 0; i < infixexp.length(); i++) {
            z = infixexp.charAt(i);
       if ((z>='1' && z<='9') || (z=='0') || (z>='A' && z<='Z')) {
                postfixform.append(z);
                postfixform.append(" ");
            } else if (z == '(') {
                stack.push(z);
                //as this operator is of the highest precendence  so it directly is pushed into the stack
            }
            
            else if (z == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixform.append(stack.pop());
                    postfixform.append(" ");
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (isOperator(z)){
            	if(z=='/' && stack.peek()=='('){
            	z='~';
            	
            }
            	
                if (!stack.isEmpty() && PrecedenceOrder(z) <= PrecedenceOrder(stack.peek())) {
                	char x=stack.pop();
                	postfixform.append(x);
                	postfixform.append(" ");
                	 stack.push(z);
                }
                stack.push(z);
            }
        }
        while (!stack.isEmpty()) {
        	char x=stack.pop();
        	postfixform.append(x);
        	postfixform.append(" ");
        }
        
        return postfixform.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(convertToPostfix("8 * 8 - 4 + 2 + 3 + 8 * 8 * 2 / 3 / 2 * 4 / 7 * 9 / 7 - 8 * 4 - 3 / 5 / 3 * 3 / 7 / 8 / 8"));
        /*String infixform;
        String to;
       
        //System.out.print("\nEnter the algebraic expression in infix: ");
		BufferedReader exp = new BufferedReader (new InputStreamReader(System.in));
		BufferedReader test = new BufferedReader (new InputStreamReader(System.in));
		to=exp.readLine();
		infixform = test.readLine();

		System.out.println(convertToPostfix(infixform));*/
        /*;
		
		
		Reader1.init(System.in);
		try {
			int no=Reader1.nextInt();
			String MAXN = Reader1.next();
			InfixToPostFixEvalution b=new InfixToPostFixEvalution();
			System.out.println(b.convertToPostfix(MAXN));
			
			
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
    }
	
}
class Reader1 {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
        	
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
