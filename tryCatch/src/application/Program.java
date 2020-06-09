package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		method2();
		
		System.out.println("End off program");
		
	}
		
		public static void method2() {
			
			System.out.println("***METHOD 2 START***");
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
		
		try {
		String[] vect = sc.nextLine().split(" ");
		int position = sc.nextInt();
		System.out.println(vect[position]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position");
			e.printStackTrace(); // imprimi o rastreamento do stack ou seja faz o rastreamento do erro
			sc.next();
		}
		catch (InputMismatchException e) {
			System.out.println("Input error");
		}
		
		sc.close();
		System.out.println("***METHOD 2 END***");
	}

}
