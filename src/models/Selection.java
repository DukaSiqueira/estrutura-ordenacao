package models;

public class Selection extends Ordenacao {

    public Selection(int totalInsert, int[] dataInsert, long timeExec) {
        super(totalInsert, dataInsert, timeExec);
    }

    public void selctionSort(int[] lista) {
        for (int i = 0; i < lista.length-1; i++) {
            int menorIndex = i;
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[menorIndex]) {
                    menorIndex = j;
                }
            }
            int aux = lista[i];
            lista[i] = lista[menorIndex];
            lista[menorIndex] = aux;
        }
    }

}
