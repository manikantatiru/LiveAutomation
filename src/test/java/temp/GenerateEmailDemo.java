package temp;

import java.util.Date;

public class GenerateEmailDemo {
	
	public static void main(String[] args) {
	
	Date date = new Date();
	String dateString=date.toString();
	String GenerateEmail=dateString.replaceAll("\\s","").replaceAll("\\:", "");
	String Email=GenerateEmail+"@gmail.com";
	System.out.println(Email);
	}

}
