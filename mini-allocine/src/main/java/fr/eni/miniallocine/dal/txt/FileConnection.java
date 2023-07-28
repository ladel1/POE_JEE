package fr.eni.miniallocine.dal.txt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileConnection {

	public static PrintWriter getPrintFile(String filename) throws IOException {
		FileWriter file = new FileWriter(filename);
		PrintWriter printWriter = new PrintWriter(file);		
		return printWriter;
	}
	
}
