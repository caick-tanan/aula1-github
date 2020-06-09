package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("commom, used or imported ? ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("price: ");
			Double price = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Custom fee: ");
				double customFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
			}
			else if ( ch == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			
			}
			else {
				list.add(new Product(name, price));
			}

		}
		
		System.out.println("\nPRICE TAGS:");
		for (Product emp : list) {
			System.out.println(emp.priceTag());
		}
		
		sc.close();
	}
}