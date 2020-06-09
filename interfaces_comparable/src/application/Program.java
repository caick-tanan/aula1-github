package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Emplyee;

public class Program {
	public static void main(String[] args) {
		List<Emplyee> list = new ArrayList<>();
		String path = "C:\\temp\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String emplyeeCsv = br.readLine();
			while (emplyeeCsv != null) {
				String[] fields = emplyeeCsv.split(",");
				list.add(new Emplyee(fields[0], Double.parseDouble(fields[1])));
				emplyeeCsv = br.readLine();
			}
			Collections.sort(list);
			for (Emplyee emp : list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
