package models;

import java.util.Arrays;

public class Insertion extends Ordenacao {

    public Insertion(int totalInsert, int[] dataInsert, long timeExec) {
        super(totalInsert, dataInsert, timeExec);
    }

    public void insertionSort(int[] lista) {
        for (int i = 1; i < lista.length; i++) {
            int aux = lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j] > aux) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = aux;
        }
    }

}
