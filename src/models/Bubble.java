package models;

public class Bubble extends Ordenacao {

    public Bubble(int totalInsert, int[] dataInsert, long timeExec) {
        super(totalInsert, dataInsert, timeExec);
    }

    public void bubbleSorte(int[] lista) {
        int tamanhoLista = lista.length;
        for (int i = 0; i < tamanhoLista - 1; i++) {
            for (int j = 0; j < tamanhoLista - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    // Troca os elementos de posição
                    int elementoAtual = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = elementoAtual;
                }
            }
        }
    }
}
