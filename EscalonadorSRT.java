import java.util.ArrayList;
import java.util.List;

public class EscalonadorSRT {

    public static void executar(List<Processo> processos) {
        System.out.println("\n>>> INICIANDO ALGORITMO SRT <<<");
        int tempoAtual = 0;
        int processosConcluidos = 0;
        int totalProcessos = processos.size();

        // O relógio vai rodar até que todos os processos cheguem ao tempoRestante == 0
        while (processosConcluidos < totalProcessos) {

            List<Processo> filaProntos = new ArrayList<>();
            Processo processoNaCPU = null;
            int menorTempo = Integer.MAX_VALUE;

            // 1. Verifica quem já chegou até o tempo atual e ainda não terminou
            for (Processo p : processos) {
                if (p.tempoChegada <= tempoAtual && p.tempoRestante > 0) {
                    filaProntos.add(p); // Coloca na fila de prontos

                    // LÓGICA SRT: Pega o que tem o menor tempo restante [1]
                    if (p.tempoRestante < menorTempo) {
                        menorTempo = p.tempoRestante;
                        processoNaCPU = p;
                    }
                }
            }

            // 2. Impressão da Timeline exigida pelo trabalho [2, 3]
            System.out.println("=== Tempo: " + tempoAtual + " ===");

            if (processoNaCPU != null) {
                System.out.println("Na CPU: " + processoNaCPU.nome);

                System.out.print("Fila de Prontos e tempo restante: ");
                if (filaProntos.size() == 1) {
                    System.out.print("Nenhum outro (Apenas o processo na CPU)");
                } else {
                    for (Processo p : filaProntos) {
                        if (p != processoNaCPU) {
                            System.out.print("[" + p.nome + " (resta " + p.tempoRestante + ")] ");
                        }
                    }
                }
                System.out.println();

                // 3. Executa o processo (Desconta 1 unidade de tempo)
                processoNaCPU.tempoRestante--;

                // Se o tempo dele zerou, ele concluiu!
                if (processoNaCPU.tempoRestante == 0) {
                    processosConcluidos++;
                }

            } else {
                System.out.println("Na CPU: Ociosa (Nenhum processo chegou ainda)");
            }

            System.out.println("------------------------------------------------");
            tempoAtual++;
        }

        System.out.println(">>> SIMULAÇÃO SRT CONCLUÍDA NO TEMPO " + tempoAtual + " <<<");
    }
}
