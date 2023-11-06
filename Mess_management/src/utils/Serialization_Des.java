package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import customer.Customer;

public class Serialization_Des {

	public static void encodebinary(List<Customer> clist, String filename) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(clist);
			System.out.println("file has been saved...");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static List<Customer> decodebinary(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			List<Customer> clist = new ArrayList<>();
			clist = (List<Customer>) in.readObject();
			return clist;
		} catch (ClassNotFoundException | IOException e) {

			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void StoreData(List<Customer> custlist, String fname) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(fname))) {
			pw.println(custlist);
		}
	}

	public static List<String> retriveData(String fname) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(fname)))
		{
			String line;
			List<String>custlist = new ArrayList<String>();
			while((line=br.readLine())!=null)
			{
				custlist.add(line);
				System.out.println();
			}
			
			return custlist;
		}
	}

}
