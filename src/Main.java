import models.Bubble;
import models.Insertion;
import models.Selection;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Opções de ordenação
        String[] options = {"Inserção", "Seleção", "Bolha", "Comparar todos métodos"};

        // Menu de opções
        int option = JOptionPane.showOptionDialog(null,"Escolha um método de ordenação: ",
        "Opcções:",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);

        // Quantidade de números a ordenar
        int totalInsert = Integer.parseInt(JOptionPane.showInputDialog("Quantos números deseja ordenar?"));

        // Vetor de números a ordenar
        int[] numeros = new int[totalInsert];

        for (int i = 0; i < totalInsert; i++) {
            Random random = new Random();
            numeros[i] = random.nextInt(100);/*Integer.parseInt(JOptionPane.showInputDialog("Número " + (i + 1) + ":"))*/;
        }

        // Cópia do vetor original
        int[] vetorOriginal = Arrays.copyOf(numeros, numeros.length);
        // Não consegui pensar em como não perder o valor de referência para cada métod
        // quando o usuário seleciona para comparar os métodos
        int[] vetorInsertion = Arrays.copyOf(numeros, numeros.length);
        int[] vetorSelection = Arrays.copyOf(numeros, numeros.length);
        int[] vetorBubble = Arrays.copyOf(numeros, numeros.length);

        // Variável auxiliar
        // Define qual retorno utilizar, não consegui pensar em como padronizar para ambos os retornos
        boolean allMethods = false;
        String metodo = new String();
        long finalTime = 0;
        long finalTimeInsertion = 0;
        long finalTimeSelection = 0;
        long finalTimeBubble = 0;

        // Não consegui separar a lógica repetida em blocos de código separado
        switch (option) {
            case 0:
                // Define o título da inserção
                metodo = "Inserção";
                // Define o início da execução
                long initialTime = System.nanoTime();
                // Inicialização do objeto
                Insertion insertion = new Insertion(numeros.length, numeros, 0);
                // Chamada da função de ordenação
                insertion.insertionSort(numeros);
                // calcula o tempo de execução
                insertion.setTimeExec(initialTime);
                // Atribui o tempo de execução a uma variável aux para saída de dados
                finalTime = insertion.getTimeExec();
                break;
            case 1:
                metodo = "Seleção";
                initialTime = System.nanoTime();
                Selection selection = new Selection(numeros.length, numeros, 0);
                selection.selctionSort(numeros);
                selection.setTimeExec(initialTime);
                finalTime = selection.getTimeExec();
                break;
            case 2:
                metodo = "Bolha";
                initialTime = System.nanoTime();
                Bubble bubble = new Bubble(numeros.length, numeros, 0);
                bubble.bubbleSorte(numeros);
                bubble.setTimeExec(initialTime);
                finalTime = bubble.getTimeExec();
                break;
            case 3:
                metodo = "Comparação de métodos";
                allMethods = true;

                // Insertion
                initialTime = System.nanoTime();
                Insertion insertionAll = new Insertion(numeros.length, numeros, 0);
                insertionAll.insertionSort(vetorInsertion);
                insertionAll.setTimeExec(initialTime);
                finalTimeInsertion = insertionAll.getTimeExec();

                // Selection
                initialTime = System.nanoTime();
                Selection selectionAll = new Selection(numeros.length, numeros, 0);
                selectionAll.selctionSort(vetorSelection);
                selectionAll.setTimeExec(initialTime);
                finalTimeSelection = selectionAll.getTimeExec();

                // Bubble
                initialTime = System.nanoTime();
                Bubble bubbleAll = new Bubble(numeros.length, numeros, 0);
                bubbleAll.bubbleSorte(vetorBubble);
                bubbleAll.setTimeExec(initialTime);
                finalTimeBubble = bubbleAll.getTimeExec();
                break;
        }


        // Diferencia o retorno de um método ou de todos os métodos
        if (!allMethods) {
            JOptionPane.showMessageDialog(null,"Método: " + metodo + "\n" +
                    "Vetor não ordenado: " + Arrays.toString(vetorOriginal) + "\n" +
                    "Vetor ordenado: " + Arrays.toString(numeros) + "\n" +
                    "Tempo de execução: " + "0."+ finalTime +" segundos");
        } else {
            JOptionPane.showMessageDialog(null,"Método: " + metodo + "\n" +
                    "Vetor não ordenado: " + Arrays.toString(vetorOriginal) + "\n" +
                    "Vetor ordenado: " + Arrays.toString(vetorInsertion) + "\n" +
                    "Tempo de execução inserção: " + finalTimeInsertion +" segundos" + "\n" +
                    "Tempo de execução seleção: " + finalTimeSelection +" segundos" + "\n" +
                    "Tempo de execução bolha: " + finalTimeBubble +" segundos");
        }
    }
}
