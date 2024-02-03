
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientL {
	public static void main (String[] args) throws Exception {
		
		Socket s = new Socket("localhost", 2345);
		
		Scanner sc = new Scanner(s.getInputStream());
		PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
		Scanner in = new Scanner(System.in);
		String str="";
		
		while(!str.equals("END")){
			System.out.print("Enter your grade ");
			str = in.nextLine();
			pw.println(str);
			str = sc.nextLine();
		System.out.println("Message from Server  : "+str);
	        }
	
		s.close();
	}
}