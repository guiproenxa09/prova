package aplicativos;

import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        int[] pessoa = new int[MAX_ELEMENTOS];
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = scan.nextInt();
            scan.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(scan);
                    continue;
                }

                System.out.println("Digite o cpf do piloto");
                Piloto piloto = new Piloto();
                piloto.setCpf(scan.nextInt());

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(scan);
            } else if (opcao == 2) {

                for (int posicaoPilotos = 0; posicaoPilotos < MAX_ELEMENTOS; posicaoPilotos++){

                    System.out.println(pessoa[posicaoPilotos]);}
                
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(scan);
                    continue;
                }

                voltarMenu(scan);
            } else if (opcao == 3) {

            } else if (opcao == 4) {
                
                MAX_ELEMENTOS = MAX_ELEMENTOS + 1;

                System.out.println("Capacidade máxima aumentada!!");

            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        scan.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}