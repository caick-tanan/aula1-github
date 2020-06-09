package espelhamento4;

/*
    Adaptado de 
    ASCENCIO, Ana Fernanda Gomes et al. 
    Estruturas de dados: algoritmos, an�lise da complexidade e implementa��es em JAVA e C/C++. 
    S�o Paulo: Pearson Prentice Hall, 2010. 
    ISBN 978-85-7605-881-6.
    P�gina 271 a 273.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
            Nenhuma das formas que encontrei no Google para fazer com que o
            Scanner leia conte�do UTF-8 deu certo. Por isso, para manter a
            simplicidade do projeto, optei por mostrar as mensagens
            para n�o utilizar acentua��o e incluir uma fun��o que checa
            por acentos na entrada no usu�rio que utiliza o Scanner
         */

        Scanner in = new Scanner(System.in);
        int opcao = 0;
        String nome = "";

        do {
            switch (opcao) {
                case 1:
                    System.out.println("N�O UTILIZE ACENTUA��O!");
                    System.out.print("\nQual o nome? ");
                    nome = in.next();

                    if (contemAcento(nome)) {
                        break;
                    }

                    Hash_Lista.inserir(nome);
                    opcao = 0;
                    break;
                case 2:
                    System.out.println("\n");
                    Hash_Lista.mostrarHash();
                    opcao = 0;
                    break;
                case 3:
                    System.out.println("N�O UTILIZE ACENTUA��O!");
                    System.out.print("\nQual o nome? ");
                    nome = in.next();

                    if (contemAcento(nome)) {
                        break;
                    }

                    Hash_Lista.mostrarHash(nome);
                    opcao = 0;
                    break;
                case 4:
                    System.out.println("N�O UTILIZE ACENTUA��O!");
                    System.out.print("\nQual a inicial? ");
                    nome = in.next();

                    if (contemAcento(nome)) {
                        break;
                    }

                    Hash_Lista.mostrarHash(nome.charAt(0));
                    opcao = 0;
                    break;
                case 5:
                    System.out.println("N�O UTILIZE ACENTUA��O");
                    System.out.print("\nQual o nome? ");
                    nome = in.next();

                    if (contemAcento(nome)) {
                        break;
                    }

                    Hash_Lista.excluirHash(nome);
                    opcao = 0;
                    break;
                default:
                    System.out.println("MENU");
                    System.out.println("1. Inserir nome");
                    System.out.println("2. Consultar todas as pessoas");
                    System.out.println("3. Consultar uma pessoa");
                    System.out.println("4. Consultar as pessoas com uma inicial digitada");
                    System.out.println(
                    		"5. Excluir uma pessoa");
                    System.out.println("6. Sair");
                    System.out.print("\nInsira a op��o desejada: ");
                    opcao = in.nextInt();
            }
        } while (opcao != 6);
    }

    public static boolean contemAcento(String conteudo) {
        for (int i = 0; i < conteudo.length(); i++) {
            if (conteudo.charAt(i) == 65533) {
                System.out.println("Acentua��o utilizada. "
                        + "Tente novamente.");
                return true;
            }
        }

        return false;
        
        
    }
 
}
