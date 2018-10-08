package Ass1;

import java.util.HashMap;

public class Q3_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Arr="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ()-1234567890.,";
		String key="BIRDWATCHNGEFJKLMOPQSUVXYZbirdwatchngefjklmopqsuvxyz ()-1234567890.,";
		char[] keyarr = key.toCharArray();
		char[] arr = Arr.toCharArray();
		
		String str="Qcw Hjdhbj lbobdhpw aeyrbqrcwo (Qwolphlckjw lbobdhph) hp b fwdhsf-phzwd lbppwohjw ihod jbqhuw qk Bphb qcbq hp vhdwey dhpqohisqwd. Bp qcw tekibe lklsebqhkj hp rkjphdwowd" + 
				"pqbiew, hq cbp iwwj ehpqwd bp Ewbpq Rkjrwoj kj qcw HSRJ Owd Ehpq phjrw 2004. Hq hp" + 
				"jbqhuw qk qcw Hjdhbj psirkjqhjwjq, Rwjqobe Bphb bjd Fybjfbo";
		String strnew=new String();
		for(int i=0;i<str.length();i++) {
			strnew+=(Arr.charAt(key.indexOf(str.charAt(i))));
			
		}
		System.out.println(strnew);
		
	}

}
