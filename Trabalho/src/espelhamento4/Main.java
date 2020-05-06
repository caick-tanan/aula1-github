package espelhamento4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		int opcao = 0;
		String nome = "";

	while (opcao != 6) {
        switch (opcao) {
		case 1:
			System.out.println("\nQual o nome? ");
			nome = in.next();
			Hash_Lista.inserir(nome);
			opcao = 0;
			break;
		 case 2:
             System.out.println("\n");
             Hash_Lista.mostrarHash();
             opcao = 0;
             break;
		 case 3:
             System.out.print("\nQual o nome? ");
             nome = in.next();
             Hash_Lista.mostrarHash();
             opcao = 0;
             break;
         case 4:
             System.out.print("\nQual a inicial? ");
             nome = in.next();
             Hash_Lista.mostrarHash(nome.charAt(0));
             opcao = 0;
             break;
         case 5:
             System.out.println("Excluir uma pessoa");
             System.out.print("\nQual o nome? ");
             nome = in.next();
             Hash_Lista.excluirHash(nome);
             opcao = 0;
             break;
         default:
             System.out.println("MENU");
             System.out.println("1. Inserir nome");
             System.out.println("2. Consultar todas as pessoas");
             System.out.println("3. Consultar uma pessoa");
             System.out.println("4. Consultar as pessoas com uma inicial digitada");
             System.out.println("5. Excluir uma pessoa");
             System.out.println("6. Sair");
             System.out.print("\nInsira a op��o desejada: ");
             opcao = in.nextInt();
        	}
		}

	}

}

