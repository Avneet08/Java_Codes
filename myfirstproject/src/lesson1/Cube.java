package lesson1;

public class Cube {
	int len;
	int bredth;
	int height;
	
	public int getCubeVol(){
		return(len*bredth*height);
	}
	
	Cube(){// this is the constructor which has same anme as class
		System.out.println("we r in cons");
		len=10;
		bredth=20;
		height=23;
	}
	Cube(int l,int b ,int h){
		len=l;
		bredth=b;
		height=h;
	}
}
