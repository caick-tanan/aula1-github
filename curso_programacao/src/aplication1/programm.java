package aplication1;

import java.util.Locale;
import java.util.Scanner;
import entites1.Product;

public class programm {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Product product;
			
		System.out.println("Enter account number: ");
		int number = sc.nextInt();
		System.out.print("Enter account holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Is there na initial deposit (y/n)?: ");
		char response = sc.next().charAt(0);
		
		if (response == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			product = new Product(number, holder, initialDeposit);
		}
		else {
			product = new Product(number, holder);
		}
		
		System.out.println();
		System.out.println("Account data:");
		System.out.println(product);
		
		System.out.println();
		System.out.print("Enter a deposit value: ");
		double depositValue = sc.nextDouble();
		product.deposit(depositValue);
		System.out.println("Updated account data:");
		System.out.println(product);
		
		System.out.println();
		System.out.print("Enter a withdraw value: ");
		double withdrawValue = sc.nextDouble();
		product.withdraw(withdrawValue);
		System.out.println("Updated account data:");
		System.out.println(product);
		
		sc.close();
		}	
}

