package myProject;
/*Avneet Kaur
2016233*/

public class Lab2 {
	String mystr;
	
	


public void palindrome(String s){
	mystr=s;
	StringBuilder str=new StringBuilder();
	StringBuilder str2=new StringBuilder();
	int l=s.length();
	int i;
	for( i=0 ;i<l ;i++){
		char a =s.charAt(i);
		str.append(a);
	}
	for( l=s.length()-1;l>=0;l--){
		char a =s.charAt(l);
		str2.append(a);
	}
	if(str==str2){
		System.out.println("True");
		
	}
	else{
		System.out.println("False");
	}
	
	
}

public void Sort(String d){
	mystr=d;
	int j;
	char t;
	char[] chars = d.toCharArray();
	int l=d.length();
	for( j=0;j<l;j++){
		for(int k=j+1;k<l;k++){
			if(chars[j]>chars[k]){
				t=chars[j];
				chars[j]=chars[k];
				chars[k]=t;
			}
			
			}
		
		
		}
	System.out.println(chars);
	
	}

}
	
	
	
	
	

	

