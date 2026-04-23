import java.util.ArrayList;
import java.util.List;

public class EscalonadorPrioridadeAging {

    // Método estático para podermos chamar direto do Main
    public static void executar(List<Processo> processos) {
        System.out.println("\n>>> INICIANDO ALGORITMO PRIORIDADES COM AGING <<<");
        int tempoAtual = 0;
        int processosConcluidos = 0;
        int totalProcessos = processos.size();

        // O relógio roda até todos terminarem (tempo restante zerar)
        while (processosConcluidos < totalProcessos) {
            List<Processo> filaProntos = new ArrayList<>();
            Processo processoNaCPU = null;

            // Assumindo que QUANTO MAIOR o número, MAIOR a prioridade
            int maiorPrioridade = -1;

            // 1. Verifica quem já chegou
            for (Processo p : processos) {
                if (p.tempoChegada <= tempoAtual && p.tempoRestante > 0) {
                    filaProntos.add(p);

                    // Encontra quem tem a maior prioridade no momento
                    if (p.prioridade > maiorPrioridade) {
                        maiorPrioridade = p.prioridade;
                        processoNaCPU = p;
                    }
                }
            }

            // 2. Imprime a Timeline exigida pelo trabalho
            System.out.println("=== Tempo: " + tempoAtual + " ===");

            if (processoNaCPU != null) {
                System.out.println("Na CPU: " + processoNaCPU.nome + " (Prioridade atual: " + processoNaCPU.prioridade + ")");

                System.out.print("Fila de Prontos: ");
                if (filaProntos.size() == 1) {
                    System.out.print("Nenhum outro (Apenas o processo na CPU)");
                } else {
                    for (Processo p : filaProntos) {
                        if (p != processoNaCPU) {
                            System.out.print("[" + p.nome + " (resta " + p.tempoRestante + " | prio " + p.prioridade + ")] ");

                            // *** AQUI ACONTECE O AGING (ENVELHECIMENTO) ***
                            // Aumenta a prioridade de quem está esperando para evitar inanição
                            p.prioridade++;
                        }
                    }
                }
                System.out.println();

                // 3. Executa o processo da CPU
                processoNaCPU.tempoRestante--;
                if (processoNaCPU.tempoRestante == 0) {
                    processosConcluidos++;
                }
            } else {
                System.out.println("Na CPU: Ociosa");
            }
            System.out.println("------------------------------------------------");
            tempoAtual++;
        }
        System.out.println(">>> SIMULAÇÃO PRIORIDADES COM AGING CONCLUÍDA <<<");
    }
}