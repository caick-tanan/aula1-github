package espelhamento4;

import java.text.Normalizer;

public class Hash_Lista {

    static int tam = 26; // tamanho da fun��o hashing
    static hash tabela[] = new hash[tam];

    public static class hash {
        String chave;
        hash prox;
    }

    public static void inserir(String nome) {
        int pos = hash(nome.toUpperCase());
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
            while (aux != null) {
                System.out.println("\nEntrada " + (char) unHash(i) + ": " + aux.chave);
                aux = aux.prox;
            }
        }
    }

    static void mostrarHash(String nome) {
        hash aux;
        for (int i = 0; i < tam; i++) {
            aux = tabela[i];
            if (aux != null && aux.chave != null && aux.chave.equals(nome)) {
                System.out.println("\nEntrada " + (char) unHash(i) + ": " + aux.chave);
                aux = aux.prox;
            }
        }
    }

    static void mostrarHash(char inicial) {
        hash aux;
        int i = hash(Character.toString(inicial));
        aux = tabela[i];
        while (aux != null) {
            if (aux.chave != null && Character.compare(aux.chave.charAt(0), inicial) == 0) {
                System.out.println("\nEntrada " + (char) unHash(i) + ": " + aux.chave);
            }
            aux = aux.prox;
        }
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
                    System.out.println("Nome n�o encontrado");
                }
            }
        } else {
            System.out.println("Nome n�o encontrado");
        }
    }
}