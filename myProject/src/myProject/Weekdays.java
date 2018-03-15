package myProject;
import java.util.Scanner;
public class Weekdays {

	public static void main(String[] args) {
		String dayString;
		Scanner scan1=new Scanner(System.in);
		System.out.println("Enter some int num");
		int day=scan1.nextInt();
		/*switch(day){
		case 1: dayString="Monday";
			break;
		case 2 : dayString="Tuesday";
			break;
		case 3: dayString="wednesday";
			break;
		case 4 : dayString="Thursday";
			break;
		case 5 : dayString="Friday";
			break;
		case 6 : dayString="Saturday";
			break;
		case 7 : dayString="Sunday";
			break;
		default : dayString="Invalid entry";
			break;*/
		if(day==1){
			dayString="Monday";
		}else if(day==2) {
			dayString="Tuesday";
		}
		else if(day==3) {
			dayString="wednesday";
		}
		else if(day==4){
			dayString="Thursday";
		}
		else if(day==5){
			dayString="Friday";
		}
		else if (day==6){
			dayString="Saturday";
		}
		else if(day==7){
			dayString="Sunday";
		}
		else{
			dayString="Invalid entry";
		}
	
		System.out.println(dayString);	

	}

}
