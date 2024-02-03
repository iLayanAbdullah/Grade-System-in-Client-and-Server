
import java.net.*;
import java.io.*;
import java.util.*;

public class ServerL {
	public static void main(String[] args) throws Exception {
		
		ServerSocket ss = new ServerSocket(2345);
		
		System.out.println(" Server is Running .....");
		System.out.println("Waiting to be connected");
		Socket s = ss.accept();
		
		Scanner sc = new Scanner(s.getInputStream());
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		String str = "";
		int totalMarks;
		
		while (!str.equals("END")) {
			str = sc.nextLine();
			totalMarks = Integer.parseInt(str);
			String grade = calculateGrade(totalMarks);
			str = "Grade is  " + grade;
			pw.println(str);
		}
			if (str.equals("END")) {
				pw.println("Thank You ");
				s.close();
			}
			
		}
		
		
		
	
	

	private static String calculateGrade(int totalMarks) {

		if (totalMarks < 0 || totalMarks > 100) {
			return "invalid Marks ";
		}
		if (totalMarks >= 90) {
			return "A";
		} else if (totalMarks >= 80 && totalMarks < 90) {
			return "B";
		} else if (totalMarks >= 70 && totalMarks < 80) {
			return "C";
		} else if (totalMarks >= 60 && totalMarks < 70) {
			return "D";
		} else if (totalMarks >= 0 && totalMarks < 60) {
			return "F";
		}

		else
			return "Thank you exit client ";
	}

}