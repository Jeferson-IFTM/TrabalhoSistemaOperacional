# Simulação de Algoritmos de Escalonamento

Este projeto foi desenvolvido como trabalho avaliativo para a disciplina de **Sistemas Operacionais**. O objetivo é simular o comportamento de diferentes estratégias de gerenciamento de processos em um ambiente de CPU única.

## 👥 Integrantes do Grupo
* **Italo Atonnio**
* **Jeefersone**
* **Otavio**

---

## 🎯 Objetivo do Projeto

O software simula dois algoritmos clássicos de escalonamento com entrada manual de dados, permitindo observar passo a passo o comportamento da CPU e da fila de prontos.

### Algoritmos Implementados:
1. **SRT (Shortest Remaining Time):** Escalonamento preemptivo baseado no menor tempo restante de execução.
2. **Prioridade com Aging:** Escalonamento baseado em níveis de prioridade, contando com um mecanismo de *Aging* (envelhecimento) para aumentar a prioridade de processos que esperam muito tempo, evitando a inanição (*starvation*).

### Visualização da Simulação:
A cada unidade de tempo, o console exibe:
* O processo que está ocupando a CPU.
* A lista de processos na fila de prontos.
* O tempo restante de cada processo presente na fila.

---

## 📂 Estrutura do Projeto

O código-fonte está organizado seguindo o padrão Maven:

```text
src/main/java/com/mycompany/simulacaodealgoritimos/
├── Main.java                        # Ponto de entrada da aplicação
├── EscalonadorSRT.java              # Lógica do algoritmo SRT
└── EscalonadorPrioridadeAging.java  # Lógica do algoritmo de Prioridade
