package espelhamento4;

/*
Adaptado de 
ASCENCIO, Ana Fernanda Gomes et al. 
Estruturas de dados: algoritmos, análise da complexidade e implementações em JAVA e C/C++. 
São Paulo: Pearson Prentice Hall, 2010. 
ISBN 978-85-7605-881-6.
Página 271 a 273.
*/

import java.text.Normalizer;
import java.text.Normalizer.Form;

public class Hash_Lista {
	static int tam = 26; // tamanho da tabela
	static hash tabela[] = new hash[tam];

	public static class hash {
		String chave;
		hash prox;
	}

	public static void inserir(String nome) {
		int pos = hash(removerAcentos(nome.toUpperCase()));
		hash novo = new hash();
		novo.chave = nome;
		novo.prox = tabela[pos];
		tabela[pos] = novo;
	}

	static int hash(String conteudo) {
		return (int) conteudo.charAt(0) - 65;
	}

	static int unHash(int n) {
		return n + 65;
	}

	static void mostrarHash() {
		hash aux;
		for (int i = 0; i < tam; i++) {
			aux = tabela[i];
			if (aux != null) {
				System.out.print("Entrada " + (char) unHash(i) + ": ");
				while (aux != null) {
					System.out.print(aux.chave);
					if (aux.prox != null) {
						System.out.print(", ");
					}
					aux = aux.prox;
				}
				System.out.println("\n");
			}
		}
	}

	static void mostrarHash(String nome) {
		hash aux;
		int i = hash(nome.toUpperCase());

		aux = tabela[i];

		while (aux != null) {
			if (aux.chave != null && aux.chave.equals(nome)) {
				System.out.println("\nEntrada " + (char) unHash(i) + ": " + aux.chave);
			}
			aux = aux.prox;
		}
	}

	static void mostrarHash(char inicial) {
		hash aux;
		int i = hash(Character.toString(inicial).toUpperCase());
		aux = tabela[i];

		System.out.print("\nEntrada " + (char) unHash(i) + ": ");

		while (aux != null) {
			if (aux.chave != null && Character.compare(aux.chave.charAt(0), inicial) == 0) {
				System.out.print(aux.chave);
				if (aux.prox != null) {
					System.out.print(", ");
				}
			}
			aux = aux.prox;
		}

		System.out.println("\n");
	}

	static void excluirHash(String nome) {
		int pos = hash(nome.toUpperCase());
		hash aux;

		if (tabela[pos] != null) {
			if (tabela[pos].chave.equals(nome)) {
				tabela[pos] = tabela[pos].prox;
			} else {
				aux = tabela[pos].prox;
				hash ant = tabela[pos];
				while (aux != null && !aux.chave.equals(nome)) {
					ant = aux;
					aux = aux.prox;
				}
				if (aux != null) {
					ant.prox = aux.prox;
				} else {
					System.out.println("Nome não encontrado");
				}
			}
		} else {
			System.out.println("Nome não encontrado");
		}
	}

	//Retirado de https://pt.stackoverflow.com/questions/42/como-remover-acentos-e-outros-sinais-gr%C3%A1ficos-de-uma-string-em-java/44
	static String removerAcentos(String str) {
		return Normalizer.normalize(str, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}
