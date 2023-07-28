package demotxt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		
		try(			
			FileWriter file = new FileWriter("client.txt");
			PrintWriter printWriter = new PrintWriter(file)			
			){
			System.out.println("Starting...");
			printWriter.print("blabalbalablababl");
			System.out.println("End.");
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
