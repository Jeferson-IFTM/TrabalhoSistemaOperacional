import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe para armazenar os dados de cada processo
class Processo {
    String nome;
    int tempoCPU;
    int tempoChegada;
    int prioridade;
    int tempoRestante;

    public Processo(String nome, int tempoCPU, int tempoChegada, int prioridade) {
        this.nome = nome;
        this.tempoCPU = tempoCPU;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
        this.tempoRestante = tempoCPU;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Processo> listaProcessos = new ArrayList<>();

        System.out.println("=== TRABALHO DE SISTEMAS OPERACIONAIS ===");
        System.out.println("Escolha o Algoritmo:");
        System.out.println("1 - SRT (Shortest Remaining Time Next)");
        System.out.println("2 - Prioridades com Aging");
        int escolha = scanner.nextInt();

        // Loop para cadastrar as entradas manuais [4]
        while (true) {
            System.out.println("\n--- Adicionar Novo Processo ---");
            System.out.print("Nome do Processo (ou 'sair' para iniciar a simulacao): ");
            String nome = scanner.next();

            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Tempo de uso da CPU: ");
            int tempoCPU = scanner.nextInt();

            System.out.print("Tempo de chegada: ");
            int tempoChegada = scanner.nextInt();

            System.out.print("Prioridade: ");
            int prioridade = scanner.nextInt();

            listaProcessos.add(new Processo(nome, tempoCPU, tempoChegada, prioridade));
        }

        System.out.println("\nEntradas finalizadas! Iniciando a simulacaao da linha do tempo...\n");

        // Direciona para a classe correta baseada na escolha do usuário
        if (escolha == 1) {
            EscalonadorSRT.executar(listaProcessos);
        } else if (escolha == 2) {
            EscalonadorPrioridadeAging.executar(listaProcessos);
        } else {
            System.out.println("Opcao invalida! Reinicie o programa.");
        }

        scanner.close();
    }
}