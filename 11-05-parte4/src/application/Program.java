package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax Payer #" + i + " data:");
			System.out.print("Rectangle or Circle (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.next();
			String name = sc.nextLine();
			System.out.print("Anual Income: ");
			double income = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, income, healthExpenditures));
			}else {
				System.out.print("Numbers of employees : ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, income, numberOfEmployees));
			}
			
		}
		
		double sum = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer tp  : list) {
			double tax = tp.tax();
			System.out.println(tp.getName() + ": $ " + String.format("%.2f",tax));
			sum += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		
		sc.close();

	}
}