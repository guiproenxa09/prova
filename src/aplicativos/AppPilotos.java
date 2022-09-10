package aplicativos;

import java.io.IOException;
import java.util.Scanner;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pessoa = new Pessoa[MAX_ELEMENTOS];
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
                    System.out.println("\nNão há espaço para cadastrar novos pilotos!!!!");
                    voltarMenu(scan);
                    continue;
                }

                System.out.println("\n******************\nCadastro de Piloto\n******************\n");

                System.out.println("Digite o cpf do piloto: ");
                String cpf = scan.nextLine();

                System.out.println("Digite o nome do piloto: ");
                String nome = scan.nextLine();

                Pessoa pessoas = new Pessoa(cpf, nome);
                pessoa[qtdCadastrados] = pessoas;
                qtdCadastrados++;
                

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(scan);

            } else if (opcao == 2) {

                System.out.println("\n******************************\nPilotos Cadastrados no Sistema\n******************************\n");
                
                for (int i = 0; i < qtdCadastrados; i++){
                    
                    System.out.println("\nNome: " + pessoa[i].getNome());
                    System.out.println("Cpf: " + pessoa[i].getCpf() + "\n");
                }
                
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(scan);
                    continue;
                }

                voltarMenu(scan);

            } else if (opcao == 3) {

                System.out.println("\n*****************\nProcura de Piloto\n*****************\n");

                System.out.println("Qual o cpf do piloto que você deseja encontrar? ");
                
                String procuraCpf = scan.nextLine();
                
                for (int i = 0; i < qtdCadastrados; i++){

                if (pessoa[i].getCpf().equals(procuraCpf)){

                    System.out.println("O piloto requisitado é: " + pessoa[i].getNome());
                }
                
                else if(pessoa[i].getCpf() != procuraCpf){

                    System.out.println("Piloto não encontrado!!");

                }


            }

            } else if (opcao == 4) {
                
                System.out.println("Selecione um novo tamanho da lista de cadastrados:");
              int novoLimite = scan.nextInt();
              scan.nextLine();


              if ( novoLimite <= MAX_ELEMENTOS){
                    System.out.println("O tamanho não pode ser menor do que o atual!!!");

                }
                    Pessoa[] vetorAumentado = new Pessoa [novoLimite];
                    for (int i = 0; i < qtdCadastrados; i++) {
                        vetorAumentado[i] = pessoa[i];
                    }

                    pessoa = vetorAumentado;
                    MAX_ELEMENTOS = novoLimite;

                

                System.out.println("Capacidade máxima aumentada!!");}

            
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