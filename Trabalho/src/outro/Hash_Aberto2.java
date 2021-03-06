package outro;

import java.util.Scanner;

public class Hash_Aberto2 {
	public static class hash{
		int chave;
		char livre;
		
	}
	
	static int tam=8;
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner (System.in);
	
	public static void inserir(int n) {
		int pos = funcao_hashing(n);
		int k = 1;
		while (k<tam
				&& tabela [pos].livre != 'L'
				&& tabela [pos].livre != 'R')			
		{
			pos = (pos+k)%tam;
			k = k+1;
		}
	if (k <= tam) 
	{
		tabela [pos].chave = n;
		tabela [pos].livre = 'O';
	}
	else System.out.println("Tabela Cheia ou em loop!");
	
}
	
	public static void remover(int n) {
		int posicao = buscar(n);
		
		if (posicao < tam)
			tabela[posicao].livre ='R';
		else System.out.println("Elemento n�o est� presente ");
	}
	
	public static int buscar(int n) {
		int k = 1;
		int pos = funcao_hashing(n);
		
		while (k <= tam
				&& tabela [pos].chave != 'L'
				&& tabela [pos].livre != n)
		{
			pos = (pos + k )%tam;
			k = k+1;
		}
		
		if (tabela [pos].chave == n
				&& tabela [pos].livre != 'R')
				return pos;
		else return tam;
	}
	
	static int funcao_hashing(int num) {
		return num % tam;
	}
	
	static void mostrar_hash() {
		for (int i =0; i <tam ;i++) 
			if (tabela[i].livre == 'O')
				System.out.println("Entrada" + i + ": " + tabela[i].chave);
	}
	
	public static void main (String[] args) {
		int op;
		int num, i;
		
		for (i =0; i <tam ; i++) {
			tabela[i] = new hash();
			tabela[i].livre = 'L';
		}
		do 
		{
			System.out.println("\nMenu de Op��es\n");
			System.out.println("1 - Inserir elemetno");
			System.out.println("2 - Mostrar tabela Hashing");
			System.out.println("3 - Excluir elemetno");
			System.out.println("4 - Sair");
			System.out.println("Digite sua op��o: ");
				op = entrada.nextInt();
				
				if(op < 1 || op > 4)
					System.out.println("Op��o Inv�lida");
				else 
				{
					switch(op)
					{
						case 1: System.out.println("Digite um numero:");
						num = entrada.nextInt();					
						inserir(num);
						break;
						case 2: 
							mostrar_hash();
							break;
						case 3 :
							System.out.println("Digite um numero:");
							num = entrada.nextInt();
							remover(num);
							break;
					}
				}	
			
			}
		
			while (op!=4);
	
	}
}
